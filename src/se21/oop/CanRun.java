package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Interface abstract methods: implicitly public and abstract; implementing class must provide a body
 * - Interface constants: fields are implicitly public static final; the explicit modifiers here are redundant but legal
 * - default methods (Java 8+): provide a method body in the interface; implementing classes inherit the body and may override it
 * - static interface methods (Java 8+): belong to the interface type, not instances; called via CanRun.printStatic(), never via a reference variable
 * - An interface with exactly one abstract method is a functional interface and can be used as a lambda target
 */
public interface CanRun {
	Float getSpeed(); // EXAM: implicitly public abstract — implementing class must override; single abstract method makes this a functional interface candidate

	static final Float MIN_SPEED = 0.0f; // EXAM: interface field — implicitly public static final; 'static final' here is redundant but not a compile error

	default void printDefault() { // EXAM: default method (Java 8+) — provides an implementation; implementing classes inherit it and may optionally override
		System.out.println("Default");
	}

	static void printStatic() { // EXAM: static interface method (Java 8+) — must be called as CanRun.printStatic(); NOT inherited by implementing classes
		System.out.println("Static");
	}
}
