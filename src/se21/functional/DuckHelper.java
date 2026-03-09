package se21.functional;

/**
 * EXAM TOPIC: Lambda Expressions — Method References
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Covers:
 * - Accepting a functional interface as a parameter enables callers to supply lambdas or method references
 * - The method does not need to know whether the caller provided a lambda, method reference, or class instance
 * - Pattern used throughout java.util.function and the Streams API (e.g., forEach, filter, map)
 */
public class DuckHelper {

	// EXAM: functional interface as parameter — callers pass System.out::println (instance method ref) or a lambda; both are interchangeable here
	public static void teacher(String name, LearnToSpeak learner) {
		learner.speak(name); // EXAM: invoking the SAM — the actual behavior is determined by whatever lambda/method ref was passed in
	}
}
