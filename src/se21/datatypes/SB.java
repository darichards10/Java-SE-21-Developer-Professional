package se21.datatypes;

/**
 * EXAM TOPIC: Handling Date, Time, Text, Numeric and Boolean Values — String and StringBuilder
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - StringBuilder is mutable; String is immutable
 * - StringBuilder methods return 'this' — chaining (append, insert, delete, reverse)
 * - String pool: compile-time constants are interned; runtime-constructed strings are not
 * - == vs .equals() for Strings: == compares references; .equals() compares content
 * - String.intern(): forces use of the pool copy
 * - StringBuilder equality: == checks identity; there is no .equals() by content (uses Object.equals)
 * - Common StringBuilder methods: substring(), indexOf(), length(), charAt()
 */
public class SB {
	
	public static void main(String[] args) {
		objectExample();
		commonMethods();
		compilationEquality();
	}
	
	public static void objectExample() {
		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a.append("de"); // EXAM: append() returns the same StringBuilder (this); a and b point to the same object
		b = b.append("f").append("g");    // EXAM: chaining — each call returns 'this'
		System.out.println("a=" + a);     // a=abcdefg
		System.out.println("b=" + b);     // b=abcdefg (same object as a)
	}

	static void commonMethods() {
		var sb = new StringBuilder("animals");
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al")); // EXAM: substring() is a read-only operation; does NOT modify sb
		int len = sb.length();
		char ch = sb.charAt(6);
		System.out.println(sub + " " + len + " " + ch);
	}

	static void append() {
		var sb = new StringBuilder().appendCodePoint(87).append(',').append((char) 87).append(',').append(87)
				.append(',').appendCodePoint(8217);
		System.out.println(sb);
	}

	static void equality() {
		var one = new StringBuilder();
		var two = new StringBuilder();
		var three = one.append("a"); // EXAM: append returns 'this'; three IS one (same reference)
		System.out.println(one == two);   // false — different objects
		System.out.println(one == three); // true  — same object (append returns this)
	}

	static void compilationEquality() {
		var first = "rat" + 1;                      // EXAM: compile-time constant → interned
		var second = "r" + "a" + "t" + "1";        // EXAM: compile-time constant → interned; same pool entry as first
		var third = "r" + "a" + "t" + new String("1"); // EXAM: new String() forces a new heap object; NOT interned
		System.out.println(first == second);        // true  — both compile-time constants, same pool entry
		System.out.println(first == second.intern()); // true  — intern() returns pool entry
		System.out.println(first == third);         // false — third is a new heap String
		System.out.println(first == third.intern()); // true  — intern() retrieves pool entry
	}
}
