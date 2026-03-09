package se21.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * EXAM TOPIC: Controlling Program Flow
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~9% of exam
 *
 * Covers:
 * - Pattern matching for instanceof (Java 16+): combines type check and cast in one step
 * - Traditional switch statement vs switch expression (Java 14+)
 * - Switch expression with arrow labels (->): no fall-through, no break needed
 * - Switch expression with yield: used inside block bodies to return a value
 * - Pattern matching for switch (Java 21): case Integer i, case Double d, guarded patterns (when)
 * - Null case in switch (Java 21): case null handles null without NullPointerException
 * - do-while loop: body executes at least once before condition is checked
 * - Labeled break/continue: exits or skips to a specific outer loop
 */
public class Decisions {

	static void printIntegersGreaterThan5(Number number) {
		// EXAM: pattern matching instanceof — check AND cast in one statement; 'data' scoped to true-branch
		if (number instanceof Integer data && data.compareTo(5) > 0)
			System.out.println(data);
		else
			System.out.println("< " + number);
	}

	public static void compareIntegers(Number number) {
		if (number instanceof Integer) {
			Integer data = (Integer) number; // EXAM: old-style cast after instanceof check
			System.out.println(data.compareTo(5));
		}
	}

	static void printOnlyIntegers(Number number) {
		if (!(number instanceof Integer data)) // EXAM: negated pattern match — acts as a guard clause
			return;
		System.out.println(data.intValue());
	}

	static String getAnimalBetter(int type) {
		String animal;
		switch (type) { // EXAM: traditional switch statement — requires break; fall-through is a common exam trap
		case 0:
			animal = "Lion";
			break;
		case 1:
			animal = "Elephant";
			break;
		case 2, 3:
			animal = "Alligator";
			break;
		case 4:
			animal = "Crane";
			break;
		default:
			animal = "Unknown";
		}
		return animal;
	}

	static String getAnimalBest(int type) {
		return switch (type) { // EXAM: switch expression with arrow labels — no fall-through, no break, returns a value
		case 0 -> "Lion";
		case 1 -> "Elephant";
		case 2, 3 -> "Alligator";
		case 4 -> "Crane";
		default -> "Unknown";
		};
	}

	static void printAnimalBest(String name) {
		System.out.println(switch (name) { // EXAM: switch expression can be used inline in method calls
		case "Sancha" -> 1;
		case "Jacob", "Jake" -> 2;
		default -> 999;
		});

		var result = switch (name) {
		case "sancha" -> 1; // EXAM: String switch is case-sensitive; "sancha" ≠ "Sancha"
		default -> 999;
		};

		System.out.println(result);
	}

	static void shouldGetACoat(Season s) {
		System.out.println(switch (s) {
		case Season.FALL, Season.WINTER -> true; // EXAM: enum switch — use constant names, not ordinal values
		default -> false;
		});
	}

	static String switchWithYield() {
		int fish = 5;
		int length = 12;
		return switch (fish) {
		case 1 -> "Goldfish";
		case 2 -> {
			yield "Trout"; // EXAM: yield returns value from a block body in a switch expression
		}
		case 3 -> {
			if (length > 10)
				yield "Blobfish"; // EXAM: conditional yield inside a block
			else
				yield "Green";
		}
		case 4 -> {
			throw new RuntimeException("Unsupported value"); // EXAM: throw is valid in a switch expression arm
		}
		default -> "Swordfish";
		};
	}

	static void printDetails(Number height) {
		// EXAM: pattern matching for switch (Java 21) — matches on type
		String message = switch (height) {
		case Integer i -> "Rounded: " + i;
		case Double d -> "Precise: " + d;
		case Number n -> "Unknown: " + n; // EXAM: must come LAST — most general type goes last (dominance rule)
		};
		System.out.println(message);
	}

	static void getTrainer(Number height) {
		System.out.println(switch (height) {
		case Integer i when i > 10 -> "Joseph"; // EXAM: guarded pattern (when) — Java 21; condition refines the type match
		case Integer i -> "Daniel";              // EXAM: catches remaining Integer cases (≤ 10)
		case Double num when num <= 15.5 -> "Peter";
		case Double num -> "Kelly";
		case Number num -> "Ralph";              // EXAM: catch-all for remaining Number subtypes
		});
	}

	static void caseNull() {
		String fish = null;
		System.out.print(switch (fish) { // EXAM: null handled without NullPointerException via case null (Java 21)
		case "ClownFish" -> "Hello!";
		case "BlueTang" -> "Hello again!";
		case null -> "What type of fish are you?";
		default -> "Goodbye";
		});
	}

	public static void doWhile() {
		int lizard = 0;
		do {
			lizard++; // EXAM: do-while executes body BEFORE checking condition; lizard is always at least 1
		} while (false);
		System.out.println(lizard); // 1
	}

	static void breakLoop() {
		int[][] list = { { 1, 13 }, { 5, 2 }, { 2, 2 } };
		int searchValue = 2;
		int positionX = -1;
		int positionY = -1;

		PARENT_LOOP: for (int i = 0; i < list.length; i++) { // EXAM: labeled loop — label names the loop to target with break/continue
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break PARENT_LOOP; // EXAM: breaks out of the OUTER loop, not just the inner one
				}
			}
		}
		if (positionX == -1 || positionY == -1) {
			System.out.println("Value " + searchValue + " not found");
		} else {
			System.out.println("Value " + searchValue + " found at: " + "(" + positionX + "," + positionY + ")");
		}
	}

	static void continueLoop() {
		CLEANING: for (char stables = 'a'; stables <= 'd'; stables++) {
			for (int leopard = 1; leopard <= 3; leopard++) {
				if (stables == 'b' || leopard == 2) {
					continue CLEANING; // EXAM: continues the OUTER loop, skipping rest of inner iterations
				}
				System.out.println("Cleaning: " + stables + "," + leopard);
			}
		}
	}

	public static void sortStringList() {
		List<String> words = new ArrayList<>(List.of("apple", "Banana", "Orange", "apricot"));
		Collections.sort(words, Comparator.comparing(String::length));
		System.out.println(words);
		words.removeIf(word -> word.equals("Orange")); // EXAM: removeIf takes a Predicate

		Collections.sort(words, Comparator.comparing(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
		System.out.println(words);
	}
}
