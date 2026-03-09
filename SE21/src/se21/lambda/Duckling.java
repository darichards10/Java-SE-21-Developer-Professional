package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions — Method References
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Instance method reference on a specific instance: System.out::println
 * - The four method reference types: static (Class::static), instance on instance (obj::method),
 *   instance on type (Class::instanceMethod), constructor (Class::new)
 * - System.out is a specific PrintStream instance, so System.out::println is an instance-on-instance reference
 * - The method reference is assigned to a functional interface variable (LearnToSpeak) matching its signature
 */
public class Duckling {

	public static void makeSound(String sound) {
		LearnToSpeak learner = System.out::println; // EXAM: instance method reference — System.out is the specific instance; equivalent lambda: s -> System.out.println(s)
		DuckHelper.teacher(sound, learner); // EXAM: the method reference is passed as the functional interface argument — fully interchangeable with a lambda
	}
}
