package se21;

/**
 * EXAM TOPIC: Handling date, time, text, numeric and boolean values / Strings
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - StringBuilder mutability: all mutating methods modify and return the SAME object
 * - Method chaining on StringBuilder because append/insert/delete return 'this'
 * - == vs equals() for Strings: == compares references; equals() compares content
 * - String pool: compile-time constant strings are interned automatically
 * - String.intern(): forces a String into the pool and returns the canonical reference
 * - new String("...") always creates a new object outside the string pool
 * - StringBuilder == comparison: two 'new StringBuilder()' are always different references
 */
public class SB {

	static void objectExample() {
		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a.append("de"); // EXAM: StringBuilder is MUTABLE; append() modifies the original object and returns 'this' (the same reference)
		b = b.append("f").append("g");    // EXAM: method chaining works because each append() returns the same StringBuilder instance
		System.out.println("a=" + a);     // EXAM: prints "a=abcdefg" — 'a' and 'b' point to the SAME object; all changes are reflected through both references
		System.out.println("b=" + b);     // EXAM: prints "b=abcdefg" — confirms a and b refer to the same mutable object
	}

	static void commonMethods() {
		var sb = new StringBuilder("animals");
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al")); // EXAM: substring() on StringBuilder returns a String (not StringBuilder); indexOf() returns the first index of the substring
		int len = sb.length(); // EXAM: length() returns the number of characters currently in the buffer
		char ch = sb.charAt(6); // EXAM: charAt() is zero-indexed; index 6 of "animals" is 's'
		System.out.println(sub + " " + len + " " + ch);
	}

	static void append() {
		var sb = new StringBuilder().appendCodePoint(87).append(',').append((char) 87).append(',').append(87) // EXAM: appendCodePoint() accepts a Unicode code point; char 87 is 'W'; int 87 appended as "87" — overloaded append() matters
				.append(',').appendCodePoint(8217);
		System.out.println(sb);
	}

	static void equality() {
		var one = new StringBuilder();
		var two = new StringBuilder(); // EXAM: two separate 'new' objects — always different references
		var three = one.append("a");   // EXAM: append() returns 'this'; 'three' is the same reference as 'one'
		System.out.println(one == two);   // false // EXAM: different objects; StringBuilder does not override equals() so == is reference comparison
		System.out.println(one == three); // true  // EXAM: same object reference; append() returned 'this'
	}

	static void compilationEquality() {
		var first = "rat" + 1;               // EXAM: compile-time constant expression (String + int literal); interned into the string pool
		var second = "r" + "a" + "t" + "1"; // EXAM: all literal concatenation — compile-time constant; same pool entry as 'first'
		var third = "r" + "a" + "t" + new String("1"); // EXAM: new String() breaks compile-time constant folding; 'third' is NOT in the pool
		System.out.println(first == second);         // true  // EXAM: both are compile-time constants and refer to the same pooled "rat1"
		System.out.println(first == second.intern()); // true  // EXAM: intern() returns the pool reference; 'second' is already pooled so no change
		System.out.println(first == third);           // false // EXAM: 'third' was created with new String(), so it lives outside the pool
		System.out.println(first == third.intern());  // true  // EXAM: intern() looks up or adds "rat1" to the pool and returns the canonical (pooled) reference
	}
}
