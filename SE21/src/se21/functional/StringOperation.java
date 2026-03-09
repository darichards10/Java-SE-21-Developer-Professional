package se21.functional;

/**
 * EXAM TOPIC: Lambda Expressions and Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Covers:
 * - Custom functional interface with a non-void (String) return type — analogous to java.util.function.UnaryOperator<String>
 * - @FunctionalInterface with one parameter in, one parameter out (same type) mirrors UnaryOperator<T>
 * - Compatible with static method references (Main::toUpper), instance method references (instance::method),
 *   and constructor references (String::new) — all demonstrated in LambdaExamples.java
 * - Lambda must explicitly or implicitly return a String value
 */
@FunctionalInterface // EXAM: SAM-enforcing annotation; this interface mirrors UnaryOperator<String> from java.util.function
public interface StringOperation {
	String process(String input); // EXAM: String-in / String-out SAM — used in LambdaExamples.java to demonstrate all four method reference types
}
