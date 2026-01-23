package se21;

import java.util.Arrays;

public class ArraysDemo {

	static void equality() {
		String[] bugs = { "cricket", "beetle", "ladybug" };
		String[] alias = bugs;
		String[] anotherArray = { "cricket", "beetle", "ladybug" };
		System.out.println(bugs.equals(alias)); // true
		System.out.println(bugs.equals(anotherArray)); // false
		System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0
		System.out.println(Arrays.toString(bugs));
	}

	static void addingToNew() {
		var numbers = new int[10];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i + 5;
		for (int n : numbers)
			System.out.println(n);
	}
}
