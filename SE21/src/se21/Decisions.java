package se21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */
public class Decisions {

	static void printIntegersGreaterThan5(Number number) {
		// checks with a short circuit then casts to "data"
		if (number instanceof Integer data && data.compareTo(5) > 0)
			System.out.println(data);
		else
			System.out.println("< " + number);
	}

	static void compareIntegers(Number number) {
		if (number instanceof Integer) {
			Integer data = (Integer) number;
			System.out.println(data.compareTo(5));
		}
	}

	static void printOnlyIntegers(Number number) {
		if (!(number instanceof Integer data))
			return;
		System.out.println(data.intValue());
	}

	static String getAnimalBetter(int type) {
		String animal;
		switch (type) {
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
		return switch (type) {
		case 0 -> "Lion";
		case 1 -> "Elephant";
		case 2, 3 -> "Alligator";
		case 4 -> "Crane";
		default -> "Unknown";
		};
	}

	static void printAnimalBest(String name) {
		System.out.println(switch (name) { // Switch expression
		case "Sancha" -> 1;
		case "Jacob", "Jake" -> 2;
		default -> 999;
		});

		var result = switch (name) {
		case "sancha" -> 1;
		default -> 999;
		};

		System.out.println(result);
	}

	static void shouldGetACoat(Season s) {
		System.out.println(switch (s) {
		case Season.FALL, Season.WINTER -> true;
		default -> false;
		});
	}

	static void printSeasonForMonth(int month) {
		switch (month) {
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
		case 1 -> "Goldfish";
		case 2 -> {
			yield "Trout";
		}
		case 3 -> {
			if (length > 10)
				yield "Blobfish";
			else
				yield "Green";
		}
		case 4 -> {
			throw new RuntimeException("Unsupported value");
		}
		default -> "Swordfish";
		};
	}

	static void printDetails(Number height) {
		String message = switch (height) {
		case Integer i -> "Rounded: " + i;
		case Double d -> "Precise: " + d;
		case Number n -> "Unknown: " + n;
		};
		System.out.println(message);
	}

	static void getTrainer(Number height) {
		System.out.println(switch (height) {
		case Integer i when i > 10 -> "Joseph";
		case Integer i -> "Daniel";
		case Double num when num <= 15.5 -> "Peter";
		case Double num -> "Kelly";
		case Number num -> "Ralph";
		});
	}

	static void caseNull() {
		String fish = null;
		System.out.print(switch (fish) {
		case "ClownFish" -> "Hello!";
		case "BlueTang" -> "Hello again!";
		case null -> "What type of fish are you?";
		default -> "Goodbye";
		});

		System.out.print(switch (fish) {
		case String s when "ClownFish".equals(s) -> "Hello!";
		case null -> "No good";
		case String s when "BlueTang".equals(s) -> "Hello again!";
		default -> "Goodbye";
		});
	}

	static void doWhile() {
		int lizard = 0;
		do {
			lizard++;
		} while (false);
		System.out.println(lizard);
	}

	static void breakLoop() {
		int[][] list = { { 1, 13 }, { 5, 2 }, { 2, 2 } };
		int searchValue = 2;
		int positionX = -1;
		int positionY = -1;

		PARENT_LOOP: for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break PARENT_LOOP;
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
					continue CLEANING;
				}
				System.out.println("Cleaning: " + stables + "," + leopard);
			}
		}
	}
	
	static void sortStringList() {
		List<String> words = new ArrayList<>(List.of("apple", "Banana", "Orange", "apricot"));
		Collections.sort(words, Comparator.comparing(String::length));
		System.out.println(words);
		words.removeIf(word -> word.equals("Orange"));
		
		Collections.sort(words, Comparator.comparing(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
		System.out.println(words);
	}
}
