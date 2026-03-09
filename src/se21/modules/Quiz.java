package se21.modules;

/**
 * SELF-TEST: Packaging and Deploying Java Code — Java Platform Module System
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What keyword in module-info.java makes a package accessible to ALL other modules?
	// a) requires   b) exports   c) opens   d) provides
	// ANSWER: ___

	// Q2: What is the difference between 'exports' and 'opens'?
	// a) No difference   b) exports allows compile-time access; opens allows deep reflective access at runtime
	// c) opens is for test modules only   d) exports also allows reflection
	// ANSWER: ___

	// Q3: What does 'requires transitive' do?
	// a) Makes the module optional   b) Causes modules depending on this module to also get access to the transitive dependency
	// c) Opens packages reflectively   d) Exports all packages transitively
	// ANSWER: ___

	// Q4: What is the unnamed module?
	// a) A module without a name   b) All code on the classpath (not module path); can access all other packages
	// c) A module that was deleted   d) The default module in every application
	// ANSWER: ___

	// Q5: Which command-line option specifies the module path?
	// a) --classpath / -cp   b) --module-path / -p   c) --module / -m   d) --add-modules
	// ANSWER: ___

	// Q6: Which module contains java.lang.String?
	// a) java.se   b) java.base   c) java.core   d) java.lang
	// ANSWER: ___

	// Q7: What tool analyzes module dependencies in a JAR?
	// a) javac   b) jar   c) jdeps   d) jlink
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1: b) exports
		System.out.println("Q1: b) exports");

		// Q2: b) exports = compile-time visibility; opens = reflective access at runtime
		System.out.println("Q2: b) exports for compile-time; opens for reflection");

		// Q3: b) requires transitive — dependents also get the transitive module
		System.out.println("Q3: b) requires transitive propagates dependency");

		// Q4: b) Unnamed module = all code on classpath
		System.out.println("Q4: b) All code on classpath forms the unnamed module");

		// Q5: b) --module-path / -p
		System.out.println("Q5: b) --module-path / -p");

		// Q6: b) java.base — the foundational module; automatically required
		Module javaBase = String.class.getModule();
		System.out.println("Q6: " + javaBase.getName()); // java.base

		// Q7: c) jdeps — Java dependency analysis tool
		System.out.println("Q7: c) jdeps");
	}
}
