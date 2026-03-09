package se21;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Inheritance
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - extends: Java supports single-class inheritance only; a class may extend exactly one class
 * - protected fields: accessible within the same package and by subclasses in any package
 * - final instance fields: must be assigned exactly once in every constructor path before the constructor completes
 * - Constructor chaining with this(): delegates to another constructor in the same class; must be the first statement
 * - Static initializer block: runs once when the class is first loaded, before any constructor
 * - Providing the required abstract method implementation: Bunny is concrete, so it must implement Logger.printMe()
 */
public class Bunny extends Logger { // EXAM: single inheritance — can only extend one class; must implement all abstract methods from Logger
	static { // EXAM: static initializer — runs once at class load time, before any instance is created
		System.out.println("static bunny");
	}
	protected final String name; // EXAM: protected — visible to subclasses (e.g. BunnyRabbit) and same-package classes; final means assigned once

	public Bunny() {
		System.out.println("constructor bunny");
		this.name = "bunny"; // EXAM: final field assigned here — every constructor path must assign it exactly once
		final String example; // EXAM: local final variable — does not need to be initialized at declaration, only before use; never read here so no compile error
	}

	public Bunny(String name) {
		this(); // EXAM: constructor chaining with this() — must be the first statement; delegates to Bunny(), which assigns the final field
	}

	public static void main(String[] args) {
		new Bunny();
	}

	void printSuperClass() {
		System.out.println("super print");
	}

	@Override
	void printMe() { // EXAM: provides the required implementation of Logger's abstract method; without this, Bunny would also need to be abstract
		System.out.println("Me");
	}
}
