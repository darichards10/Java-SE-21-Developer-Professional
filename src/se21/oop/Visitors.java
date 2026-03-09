package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Marker/simple interface: an interface with very few (here, one) abstract methods
 * - Functional interface candidate: exactly one abstract method qualifies this interface for use with lambdas and method references
 * - Interface method is implicitly public abstract — no modifiers needed; adding them is redundant but legal
 * - Implementing classes must provide a public (not weaker) implementation of printVistors()
 */
public interface Visitors {
	void printVistors(); // EXAM: single abstract method — implicitly public abstract; makes Visitors a functional interface usable with lambdas (e.g. Visitors v = () -> System.out.println("hi");)
}
