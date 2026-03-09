package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions and Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Custom functional interface with a void return type — analogous to java.util.function.Consumer<T>
 * - @FunctionalInterface enforces the SAM rule at compile time
 * - void-returning SAMs are assigned lambdas whose body is a single statement (no return keyword needed)
 * - Compatible with instance method references like System.out::println (same void/String signature)
 */
@FunctionalInterface // EXAM: compiler enforces SAM rule; removing this and adding a second abstract method would still compile but break lambda usability
public interface LearnToSpeak {
	void speak(String sound); // EXAM: void return + one parameter — matches Consumer<String> shape; compatible with System.out::println method reference
}
