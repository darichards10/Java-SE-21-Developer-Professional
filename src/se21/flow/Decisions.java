<<<<<<< HEAD:src/se21/flow/Decisions.java
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
=======
package se21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * EXAM TOPIC: Controlling Program Flow
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Pattern matching for instanceof (Java 16+): binding variable in condition
 * - Traditional switch statement vs switch expression (arrow syntax, Java 14+)
 * - Switch expressions with yield for multi-statement cases (Java 14+)
 * - Pattern matching for switch (Java 21): type patterns and guarded patterns (when)
 * - Handling null in switch expressions (Java 21)
 * - Labeled break and continue for nested loop control
 * - do-while loop: body always executes at least once
 * - Comparator chaining for collection sorting
 */
public class Decisions {

	static void printIntegersGreaterThan5(Number number) {
		// checks with a short circuit then casts to "data"
		if (number instanceof Integer data && data.compareTo(5) > 0) // EXAM: pattern matching instanceof — 'data' is a binding variable, scoped to the true branch; && short-circuits
			System.out.println(data);
		else
			System.out.println("< " + number);
	}

	static void compareIntegers(Number number) {
		if (number instanceof Integer) {
			Integer data = (Integer) number; // EXAM: traditional instanceof + explicit cast — verbose; pattern matching (above) is the modern replacement
			System.out.println(data.compareTo(5));
		}
	}

	static void printOnlyIntegers(Number number) {
		if (!(number instanceof Integer data)) // EXAM: negated pattern matching; binding variable 'data' is in scope in the else/fall-through path (after the return)
			return;
		System.out.println(data.intValue()); // EXAM: 'data' is accessible here because the negated branch returns early
	}

	static String getAnimalBetter(int type) {
		String animal;
		switch (type) { // EXAM: traditional switch statement — requires break to prevent fall-through; cannot be used as an expression
		case 0:
			animal = "Lion";
			break; // EXAM: missing break causes fall-through to next case — a common exam trap
		case 1:
			animal = "Elephant";
			break;
		case 2, 3: // EXAM: multiple values in one case label (Java 14+) — works in both statement and expression forms
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
		return switch (type) { // EXAM: switch expression with arrow syntax — no fall-through, no break needed, returns a value directly
		case 0 -> "Lion";
		case 1 -> "Elephant";
		case 2, 3 -> "Alligator"; // EXAM: multiple case labels still supported in switch expressions
		case 4 -> "Crane";
		default -> "Unknown"; // EXAM: switch expressions require all possible inputs to be covered; default satisfies exhaustiveness
		};
	}

	static void printAnimalBest(String name) {
		System.out.println(switch (name) { // EXAM: switch expression on String — case labels are exact, case-sensitive matches
		case "Sancha" -> 1;
		case "Jacob", "Jake" -> 2;
		default -> 999;
		});

		var result = switch (name) { // EXAM: switch expression can be assigned to a variable; type is inferred
		case "sancha" -> 1; // EXAM: String switch is case-sensitive; "sancha" != "Sancha"
		default -> 999;
		};

		System.out.println(result);
	}

	static void shouldGetACoat(Season s) {
		System.out.println(switch (s) { // EXAM: switch on enum type; enum constants are referenced by their simple name in case labels
		case Season.FALL, Season.WINTER -> true;
		default -> false;
		});
	}

	static void printSeasonForMonth(int month) {
		switch (month) { // EXAM: default case does not need to be last in a switch statement — it is only used if no other case matches
		case 1, 2, 3:
			System.out.print("Winter-");
			break;
		case 4, 5, 6:
			System.out.print("Spring-");
			break;
		default:
			System.out.print("Unknown-");
			break;
		case 7, 8, 9:
			System.out.print("Summer-");
			break;
		case 10, 11, 12:
			System.out.print("Fall-");
			break;
		}
	}

	static String switchWithYield() {
		int fish = 5;
		int length = 12;
		return switch (fish) {
		case 1 -> "Goldfish"; // EXAM: single-expression arrow case — value is the result
		case 2 -> {
			yield "Trout"; // EXAM: yield is required inside a block ({}) within a switch expression to return a value
		}
		case 3 -> {
			if (length > 10)
				yield "Blobfish"; // EXAM: yield can appear in multiple branches of logic within a block case
			else
				yield "Green";
		}
		case 4 -> {
			throw new RuntimeException("Unsupported value"); // EXAM: throwing an exception satisfies exhaustiveness; no yield needed
		}
		default -> "Swordfish";
		};
	}

	static void printDetails(Number height) {
		String message = switch (height) { // EXAM: pattern matching for switch (Java 21) — matches on type; cases must be ordered from most specific to most general
		case Integer i -> "Rounded: " + i;  // EXAM: type pattern; 'i' is the binding variable holding the matched value
		case Double d -> "Precise: " + d;
		case Number n -> "Unknown: " + n; // EXAM: must come last among type patterns — it covers all remaining Number subtypes
		};
		System.out.println(message);
	}

	static void getTrainer(Number height) {
		System.out.println(switch (height) {
		case Integer i when i > 10 -> "Joseph"; // EXAM: guarded pattern — 'when' adds an extra boolean condition (Java 21); more specific guards must come before less specific ones
		case Integer i -> "Daniel"; // EXAM: unguarded Integer case must follow all guarded Integer cases
		case Double num when num <= 15.5 -> "Peter";
		case Double num -> "Kelly";
		case Number num -> "Ralph"; // EXAM: catch-all type pattern satisfies exhaustiveness for a Number switch
		});
	}

	static void caseNull() {
		String fish = null;
		System.out.print(switch (fish) { // EXAM: Java 21 allows 'case null' in switch expressions; without it, a null selector throws NullPointerException
		case "ClownFish" -> "Hello!";
		case "BlueTang" -> "Hello again!";
		case null -> "What type of fish are you?"; // EXAM: explicit null case prevents NPE; must appear before 'default' if both are present
		default -> "Goodbye";
		});

		System.out.print(switch (fish) {
		case String s when "ClownFish".equals(s) -> "Hello!"; // EXAM: combining type pattern + when guard on String; safe from NPE because null is handled below
		case null -> "No good";
		case String s when "BlueTang".equals(s) -> "Hello again!";
		default -> "Goodbye";
		});
	}

	static void doWhile() {
		int lizard = 0;
		do {
			lizard++; // EXAM: do-while body always executes at least once, even when the condition is false from the start
		} while (false);
		System.out.println(lizard); // EXAM: prints 1, not 0 — the body ran once before the condition was checked
	}

	static void breakLoop() {
		int[][] list = { { 1, 13 }, { 5, 2 }, { 2, 2 } };
		int searchValue = 2;
		int positionX = -1;
		int positionY = -1;

		PARENT_LOOP: for (int i = 0; i < list.length; i++) { // EXAM: labeled statement — the label targets the outer for loop
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break PARENT_LOOP; // EXAM: labeled break exits the labeled (outer) loop entirely, not just the inner loop
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
					continue CLEANING; // EXAM: labeled continue skips the rest of the current outer loop iteration and moves to the next; without the label it would only skip the inner iteration
				}
				System.out.println("Cleaning: " + stables + "," + leopard);
			}
		}
	}

	static void sortStringList() {
		List<String> words = new ArrayList<>(List.of("apple", "Banana", "Orange", "apricot"));
		Collections.sort(words, Comparator.comparing(String::length)); // EXAM: Comparator.comparing() with method reference for single-criterion sort
		System.out.println(words);
		words.removeIf(word -> word.equals("Orange")); // EXAM: removeIf() accepts a Predicate; modifies the list in place

		Collections.sort(words, Comparator.comparing(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER)); // EXAM: thenComparing() chains a secondary comparator for tie-breaking
		System.out.println(words);
	}
}
>>>>>>> fd67abe4c885af47c3feb1e4a8062213bc890584:SE21/src/se21/Decisions.java
