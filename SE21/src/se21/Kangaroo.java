package se21;

import java.util.List;
import static java.util.Arrays.asList;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Nested Classes
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Inner class (non-static nested class): Joey is a member inner class; it requires an enclosing Kangaroo instance to instantiate
 * - Static vs instance members in inner classes: static fields/methods in inner classes require the 'static' keyword (Java 16+ allows this)
 * - Instance initializer in inner class: the { } block runs each time a Joey instance is created, before the constructor body
 * - Static initializer in inner class: the static { } block runs once when Joey is first loaded
 * - Local interfaces and enums (Java 16+): interfaces and enums may be declared inside method bodies
 * - Static import: 'import static java.util.Arrays.asList' lets you call asList() without the class qualifier
 */
public class Kangaroo {

	public static void main(String[] args) {
		List<String> list = asList("one", "two"); // EXAM: static import in action — asList() comes from Arrays; result is a fixed-size list (not fully immutable, but size is fixed)
	}

	class Joey { // EXAM: inner class (non-static) — requires an enclosing Kangaroo instance; instantiate with: new Kangaroo().new Joey()
		static int numJoeys = 0;          // EXAM: static field in inner class — allowed in Java 16+ (prior versions required it to be in a static nested class)
		final static int sumJoeyAges;     // EXAM: final static field — must be assigned in the static initializer block; no instance needed
		final int sumJoeyLegs;            // EXAM: final instance field — must be assigned in every constructor or instance initializer before the constructor completes

		static { // EXAM: static initializer in inner class — runs once when Joey class is loaded; used here to assign the final static field
			sumJoeyAges = 0;
		}

		{ // EXAM: instance initializer block — runs every time a Joey is constructed, after super() but before the rest of the constructor body
			sumJoeyLegs = 0;
		}
	}

	void hop() {
		interface Hopper { // EXAM: local interface (Java 16+) — declared inside a method; implicitly static; only usable within this method scope
		}
		enum Size { // EXAM: local enum (Java 16+) — declared inside a method; implicitly static; scope is limited to this method
			SMALL, MEDIUM, LARGE
		}
	}
}