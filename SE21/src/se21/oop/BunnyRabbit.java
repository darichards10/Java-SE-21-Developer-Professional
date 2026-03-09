package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Inheritance
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Multiple interface implementation: a class may implement any number of interfaces simultaneously
 * - Static initializer blocks: run once per class when the class is first loaded; parent static init runs before child static init
 * - Instance initializer blocks: run every time an instance is created, after super() completes but before the rest of the constructor
 * - Constructor execution order: static initializers (parent → child) → instance initializers → constructor body
 *   Full sequence for 'new BunnyRabbit()': static Bunny → static BunnyRabbit → Bunny() → BunnyRabbit()
 * - super(): explicit call to the parent constructor; must be the first statement if used
 * - Method overriding: @Override on printSuperClass() replaces Bunny's version at runtime via dynamic dispatch
 */
public class BunnyRabbit extends Bunny implements CanRun { // EXAM: extends one class AND implements one interface simultaneously
	static { // EXAM: static initializer — runs after Bunny's static block (parent loads first), and only once ever
		System.out.println("static bunnyrabbit");
	}

	public BunnyRabbit() {
		super(); // EXAM: explicit super() — calls Bunny(); if omitted the compiler inserts it implicitly (must still be first statement)
		System.out.println("constructor bunnyrabbit");
	}

	@Override
	void printSuperClass() { // EXAM: method overriding — runtime type is BunnyRabbit, so this version is called via polymorphism
		System.out.println("Over ridder");
	}

	@Override
	public Float getSpeed() { // EXAM: satisfies the CanRun interface contract; returning null is valid but callers must guard against NullPointerException
		return null;
	}
}
