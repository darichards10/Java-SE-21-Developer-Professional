package se21;

/**
 * EXAM TOPIC: Building Blocks / Methods
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Varargs: must be the last parameter, only one per method, treated as an array
 * - final local variables: must be assigned exactly once before use (blank finals)
 * - final instance fields: can be assigned in field declaration, instance initializer, or constructor
 * - Text blocks (Java 15+): triple-quote syntax, formatted() for interpolation
 * - Method overloading resolution: most specific type wins; varargs is the last resort
 * - Modifier ordering: Java allows flexible ordering (public final vs final public)
 * - Primitives are passed by value; changes inside a method do not affect the caller
 */
public class Methods {
	final int age = 10; // EXAM: final field initialized at declaration — cannot be reassigned
	final int fishEaten; // EXAM: blank final field — must be assigned in an instance initializer OR every constructor
	final String name;   // EXAM: blank final field — assigned in constructor below

	{
		fishEaten = 10; // EXAM: instance initializer block — runs before constructor; valid place to assign blank final fields
	}

	public Methods() {
		name = "Robert"; // EXAM: blank final 'name' assigned here; if any constructor omitted this, it would be a compile error
		int num = 1;
		newNumber(3); // EXAM: primitives are passed by value; the caller's 'num' is unaffected by changes inside newNumber()
		String txt = """
				nums = %d
				""".formatted(num); // EXAM: text block (Java 15+) — triple quotes start a multi-line string; formatted() substitutes placeholders

		System.out.println(txt);
	}

	public void bike1() {
	}

	public final void bike2() { // EXAM: final method cannot be overridden in a subclass
	}

	public static final void bike3() { // EXAM: modifier order (public static final) is conventional but not required by the compiler
	}

	public final static void bike4() { // EXAM: 'final static' is legal — modifier order is flexible in Java
	}

	final public void bike7() { // EXAM: 'final' before 'public' is also legal — access modifiers and other modifiers can be reordered
	}

	native void example(); // EXAM: native method — implemented in native code (C/C++); has no body in Java; rarely tested but valid modifier

	public void Jog_$() { // EXAM: method names can include letters, digits, $, and _; cannot start with a digit
	}

	static void zooAnimalCheckup(boolean isWeekend) {
		final int rest; // EXAM: blank final local variable — not assigned at declaration; must be assigned exactly once before use
		if (isWeekend)
			rest = 5;  // EXAM: assigned in one branch
		else
			rest = 20; // EXAM: assigned in the other branch; compiler verifies all paths assign it exactly once
		System.out.println(rest); // EXAM: safe to use here because both branches guarantee assignment
	}

	static void walk(int step, int... steps) { // EXAM: varargs ('int... steps') must be the LAST parameter; only ONE varargs per method; treated as int[] inside the method
		System.out.println(steps.length); // EXAM: varargs parameter is accessed as an array; caller can pass 0 or more values, or an explicit array
	}


	static void newNumber(int num) {
		num = 2; // EXAM: 'num' is a local copy (pass-by-value); this change does NOT affect the caller's variable
	}


	static String glide(String s) { // EXAM: overloading — most specific match wins; glide("hello") calls this (exact type match preferred over varargs or Object)
		return "1";
	}

	static String glide(String... s) { // EXAM: varargs overload — lowest priority; only selected when no exact or widened match exists
		return "2";
	}

	static String glide(String s, String t) { // EXAM: exact two-arg match wins over varargs when two Strings are passed
		return "3";
	}

	static String glide(Object s) { // EXAM: widening to Object — selected over varargs but after exact-type matches
		return "4";
	}
}
