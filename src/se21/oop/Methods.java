package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach — Methods and Constructors
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Method modifiers: public, final, static, native — and valid modifier orderings
 * - final methods: cannot be overridden by subclasses
 * - native methods: implemented in native code (C/C++); no body in Java
 * - Instance initializer block: runs before constructor body, after super()
 * - final instance fields: must be assigned in every constructor path or instance initializer
 * - Blank final local variables: may be declared without initialization; must be assigned before use
 * - Varargs: must be the last parameter; caller may pass array or individual elements
 * - Method overloading resolution: most specific matching method is selected at compile time
 * - Pass-by-value: primitive copies are independent; object references are copied (not the object)
 * - Text blocks (Java 15+): triple-quoted strings with auto-stripped indentation
 */
public class Methods {
	final int age = 10;
	final int fishEaten; // EXAM: blank final instance field — must be assigned in instance initializer or constructor
	final String name;

	{ // EXAM: instance initializer — assigns blank final field; runs after super(), before rest of constructor
		fishEaten = 10;
	}

	public Methods() {
		name = "Robert"; // EXAM: assigns blank final field in constructor
		int num = 1;
		newNumber(3);
		String txt = """
				nums = %d
				""".formatted(num); // EXAM: text block (Java 15+) — triple quotes; leading whitespace stripped by common indent
		System.out.println(txt);
	}

	public void bike1() {}

	public final void bike2() {} // EXAM: final method — cannot be overridden

	public static final void bike3() {} // EXAM: modifier order: public static final — all valid orderings are legal

	public final static void bike4() {} // EXAM: same as bike3; Java allows any order of access + non-access modifiers

	final public void bike7() {} // EXAM: modifier before access modifier — unusual but legal

	native void example(); // EXAM: native method — no body; implemented in native library; must declare a body-less signature

	public void Jog_$() {} // EXAM: valid identifier — letters, digits, $, _; cannot start with digit; case-sensitive

	static void zooAnimalCheckup(boolean isWeekend) {
		final int rest; // EXAM: blank final local — not yet assigned; must be assigned before use
		if (isWeekend)
			rest = 5;
		else
			rest = 20;
		System.out.println(rest); // EXAM: guaranteed assigned on all paths; valid to read here
	}

	static void walk(int step, int... steps) { // EXAM: varargs as last parameter; caller passes zero or more ints
		System.out.println(steps.length);
	}

	static void newNumber(int num) {
		num = 2; // EXAM: pass-by-value — primitive copy; original variable at call site is unchanged
	}

	// EXAM: overload resolution — most specific match wins at compile time
	static String glide(String s)          { return "1"; } // most specific for single String
	static String glide(String... s)       { return "2"; } // varargs — last resort
	static String glide(String s, String t){ return "3"; } // two String params
	static String glide(Object s)          { return "4"; } // less specific than String
}
