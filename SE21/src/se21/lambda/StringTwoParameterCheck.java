package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions and Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Custom functional interface with two parameters — analogous to java.util.function.BiPredicate<String, String>
 * - Without @FunctionalInterface: still usable as a functional interface (annotation is optional)
 * - Two-parameter lambdas require parentheses: (a, b) -> a.startsWith(b)
 * - Compatible with instance method references where the first parameter is the instance:
 *   instance::startsWith — the instance is bound, second param maps to the method arg
 */
public interface StringTwoParameterCheck { // EXAM: no @FunctionalInterface but still a valid SAM type — exam tests that the annotation is not required
	boolean check(String a, String b); // EXAM: two-parameter SAM — lambda must use parentheses; mirrors BiPredicate<String,String>
}
