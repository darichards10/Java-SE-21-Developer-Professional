package se21;

/**
 * EXAM TOPIC: Java Object-Oriented Approach
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - abstract class vs interface: abstract classes support constructors, instance fields, and any access modifier;
 *   interfaces (pre-Java 8) could only have public abstract methods and public static final fields
 * - abstract method declaration: declared without a body; forces concrete subclasses to provide an implementation
 * - Concrete methods in abstract classes: allowed and inherited by subclasses without requiring override
 * - A concrete subclass must implement ALL inherited abstract methods or be declared abstract itself
 */
public abstract class AbstractClass { // EXAM: abstract class — bridges abstract and concrete behavior; cannot be instantiated
	abstract int getVal(); // EXAM: abstract method — no body; every non-abstract subclass must override this

	void printSomething() { // EXAM: concrete method in an abstract class — subclasses inherit this without needing to override
		System.out.println("print me");
	}
}
