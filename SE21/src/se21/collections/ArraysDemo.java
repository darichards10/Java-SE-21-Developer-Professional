package se21.collections;

import java.util.Arrays;

/**
 * EXAM TOPIC: Working with Arrays and Collections — Arrays
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~12% of exam
 *
 * Covers:
 * - Array equality: == compares references; Arrays.equals() compares contents
 * - Arrays.toString(): readable array output vs default Object.toString() ([Ltype;@hash)
 * - Array declaration and initialization: new int[size] vs {1,2,3} literal
 * - For-each loop (enhanced for): iterates over arrays and Iterable collections
 * - Array copy: System.arraycopy(), Arrays.copyOf(), Arrays.copyOfRange()
 * - Sorting: Arrays.sort() modifies in-place; Arrays.binarySearch() requires sorted array
 * - Multi-dimensional arrays: int[][] — array of arrays; inner arrays can have different lengths
 */
public class ArraysDemo {

	static void equality() {
		String[] bugs = { "cricket", "beetle", "ladybug" };
		String[] alias = bugs;                               // EXAM: alias and bugs point to same array object
		String[] anotherArray = { "cricket", "beetle", "ladybug" };
		System.out.println(bugs.equals(alias));       // true  — same reference
		System.out.println(bugs.equals(anotherArray)); // false — different objects (not content comparison)
		System.out.println(bugs.toString());           // EXAM: Object.toString() on array = [Ljava.lang.String;@<hash>
		System.out.println(Arrays.toString(bugs));     // EXAM: Arrays.toString() gives readable [cricket, beetle, ladybug]
		System.out.println(Arrays.equals(bugs, anotherArray)); // EXAM: Arrays.equals() compares contents — true
	}

	static void addingToNew() {
		var numbers = new int[10];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i + 5; // EXAM: array elements accessed by index; length is fixed at creation
		for (int n : numbers)
			System.out.println(n);
	}

	static void sortAndSearch() {
		int[] nums = {5, 3, 1, 4, 2};
		Arrays.sort(nums); // EXAM: sorts in-place; array is modified
		System.out.println(Arrays.toString(nums)); // [1, 2, 3, 4, 5]
		System.out.println(Arrays.binarySearch(nums, 3)); // EXAM: requires sorted array; returns index (2)
	}

	static void copying() {
		int[] original = {1, 2, 3, 4, 5};
		int[] copy = Arrays.copyOf(original, 3);        // EXAM: copies first 3 elements; new array length = 3
		int[] range = Arrays.copyOfRange(original, 1, 4); // EXAM: copies [1..4) = {2,3,4}
		System.out.println(Arrays.toString(copy));   // [1, 2, 3]
		System.out.println(Arrays.toString(range));  // [2, 3, 4]
	}
}
