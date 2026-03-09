package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions and Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Defining a custom functional interface (single abstract method = SAM rule)
 * - Without @FunctionalInterface annotation: still valid as a functional interface
 * - SAM rule: exactly one abstract method allows lambda assignment
 * - Used as the target type for lambda expressions and method references
 */
public interface CheckTrait {
	boolean test(Animal a); // EXAM: single abstract method — makes this a functional interface eligible for lambda assignment
}