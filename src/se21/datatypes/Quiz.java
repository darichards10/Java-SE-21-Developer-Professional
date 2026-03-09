package se21.datatypes;

/**
 * SELF-TEST: Handling Date, Time, Text, Numeric and Boolean Values
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is the output?
	//   var x = 5;
	//   x += 1.9;         // compound assignment with widening then narrowing
	//   System.out.println(x);
	// a) 6.9   b) 6   c) compile error   d) 7
	// ANSWER: ___

	// Q2: What does Boolean.parseBoolean("True") return?
	// a) true   b) false   c) throws IllegalArgumentException   d) compile error
	// ANSWER: ___

	// Q3: What is printed?
	//   var a = "hello";
	//   var b = "hel" + "lo";
	//   System.out.println(a == b);
	// a) true   b) false   c) compile error
	// ANSWER: ___

	// Q4: What is the default value of Integer[] arr = new Integer[3][0]?
	// a) 0   b) null   c) 0.0   d) false
	// ANSWER: ___

	// Q5: What is printed?
	//   StringBuilder sb = new StringBuilder("hello");
	//   sb.delete(1, 3);
	//   System.out.println(sb);
	// a) "hllo"   b) "helo"   c) "hello"   d) "hlo"
	// ANSWER: ___

	// Q6: What is printed?
	//   var a = new StringBuilder("a");
	//   var b = a;
	//   b.append("b");
	//   System.out.println(a);
	// a) "a"   b) "ab"   c) "b"   d) compile error
	// ANSWER: ___

	// Q7: What is the output?
	//   System.out.println(Math.round(2.5));
	//   System.out.println(Math.round(-2.5));
	// a) 3 and -3   b) 3 and -2   c) 2 and -2   d) 2 and -3
	// ANSWER: ___

	// Q8: Which of the following causes a compile error?
	// a) float f = 1;           b) double d = 1.0;
	// c) long l = 1L;           d) int i = 1L;
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1 verification
		int x = 5;
		x += 1.9; // compound assignment applies implicit cast: (int)(5 + 1.9) = 6
		System.out.println("Q1: " + x); // 6

		// Q2 verification
		System.out.println("Q2: " + Boolean.parseBoolean("True")); // true — case-insensitive

		// Q3 verification
		var a = "hello";
		var b = "hel" + "lo"; // compile-time constant — interned
		System.out.println("Q3: " + (a == b)); // true — same pool entry

		// Q4 verification: null (Integer[] stores boxed types, default is null)
		Integer[] arr = new Integer[3];
		System.out.println("Q4: " + arr[0]); // null

		// Q5 verification
		StringBuilder sb = new StringBuilder("hello");
		sb.delete(1, 3); // removes chars at index 1 (inclusive) to 3 (exclusive): removes "el"
		System.out.println("Q5: " + sb); // "hlo"

		// Q6 verification
		var a2 = new StringBuilder("a");
		var b2 = a2; // same object reference
		b2.append("b");
		System.out.println("Q6: " + a2); // "ab" — both point to same StringBuilder

		// Q7 verification
		System.out.println("Q7a: " + Math.round(2.5));  // 3
		System.out.println("Q7b: " + Math.round(-2.5)); // -2 (rounds toward positive infinity at .5)

		// Q8: d) int i = 1L — cannot assign long to int without cast (COMPILE ERROR)
		System.out.println("Q8: d) int i = 1L does not compile");
	}
}
