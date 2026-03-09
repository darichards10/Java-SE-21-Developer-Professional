package se21.oop;

import java.util.List;
import static java.util.Arrays.asList;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Nested Classes (Advanced)
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Static import: import static allows direct use of static members without class prefix
 * - Inner class with static members: in Java 16+ inner classes can have static members
 * - Static final fields in inner class: must be a compile-time constant
 * - Instance initializer in inner class: runs before constructor body, after super()
 * - Local interface (Java 16+): interfaces can be declared inside method bodies
 * - Local enum (Java 16+): enums can be declared inside method bodies
 * - Effectively final local variables: can be captured by lambdas and local/anonymous classes
 */
public class Kangaroo {

	public static void main(String[] args) {
		List<String> list = asList("one", "two"); // EXAM: static import — asList used without Arrays prefix
	}

	class Joey { // EXAM: non-static inner class — has implicit reference to enclosing Kangaroo instance
		static int numJoeys = 0;         // EXAM: Java 16+ allows static fields in inner classes
		final static int sumJoeyAges;    // EXAM: must be a compile-time constant (blank final with static init)
		final int sumJoeyLegs;

		static {
			sumJoeyAges = 0; // EXAM: static initializer assigns the static final field
		}

		{
			sumJoeyLegs = 0; // EXAM: instance initializer assigns the instance final field; runs before constructor body
		}
	}

	void hop() {
		interface Hopper { // EXAM: local interface (Java 16+) — scoped to this method
		}
		enum Size { // EXAM: local enum (Java 16+) — scoped to this method
			SMALL, MEDIUM, LARGE
		}
	}
}
