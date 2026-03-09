package se21;

import java.util.Arrays;

/**
 * EXAM TOPIC: Working with Arrays and Collections
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Arrays.equals() vs == vs Object.equals() for array comparison
 * - Arrays.toString() for human-readable array output vs default toString()
 * - Array initialization and element-level manipulation
 * - Enhanced for loop vs indexed for loop over arrays
 * - var inference with array types
 */
public class ArraysDemo {

	static void equality() {
		String[] bugs = { "cricket", "beetle", "ladybug" };
		String[] alias = bugs; // EXAM: alias points to the same object; == and .equals() both return true
		String[] anotherArray = { "cricket", "beetle", "ladybug" };
		System.out.println(bugs.equals(alias)); // true  // EXAM: arrays inherit Object.equals(), so this is reference equality, not content equality
		System.out.println(bugs.equals(anotherArray)); // false // EXAM: different objects even with identical contents; use Arrays.equals() for content comparison
		System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0 // EXAM: default array toString() returns type descriptor + hash, NOT readable content
		System.out.println(Arrays.toString(bugs)); // EXAM: Arrays.toString() produces a readable "[a, b, c]" representation; required for printing array contents
	}

	static void addingToNew() {
		var numbers = new int[10]; // EXAM: var infers int[]; array elements default to 0 for int arrays
		for (int i = 0; i < numbers.length; i++) // EXAM: .length is a field (not a method) on arrays
			numbers[i] = i + 5;
		for (int n : numbers) // EXAM: enhanced for loop iterates over array values; cannot modify the array reference this way
			System.out.println(n);
	}
}
