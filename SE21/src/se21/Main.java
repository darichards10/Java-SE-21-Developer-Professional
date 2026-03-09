package se21;

/**
 * Java SE 21 Developer Professional (1Z0-830) — Study Index
 *
 * Run any domain's main() method directly to explore examples and self-tests.
 * Each package has:
 *   - Example class(es) with runnable code and EXAM comments
 *   - Quiz.java with multiple-choice questions (answer, then run main() to verify)
 *
 * Oracle 1Z0-830 Exam Domains:
 *   ~11% — Handling Date, Time, Text, Numeric and Boolean Values  → se21.datatypes
 *   ~9%  — Controlling Program Flow                               → se21.flow
 *   ~23% — Utilizing Java Object-Oriented Approach                → se21.oop
 *   ~7%  — Handling Exceptions                                    → se21.exceptions
 *   ~9%  — Working with Arrays and Collections                    → se21.collections
 *   ~17% — Working with Streams and Lambda Expressions            → se21.functional
 *   ~8%  — Packaging and Deploying Java Code (JPMS)               → se21.modules
 *   ~11% — Managing Concurrent Code Execution                     → se21.concurrency
 *   ~12% — Using Java I/O API                                     → se21.io
 *   ~9%  — Accessing Databases Using JDBC                         → se21.jdbc
 *   ~8%  — Implementing Localization                              → se21.localization
 */
public class Main {

	public static void main(String[] args) throws Exception {

		// ── DOMAIN: Handling Date, Time, Text, Numeric and Boolean Values (~11%) ──
		se21.datatypes.Types.main(args);
		se21.datatypes.SB.objectExample();
		se21.datatypes.MathAPI.bigIntOperations();
		se21.datatypes.DateTimeAPI.examples();
		// se21.datatypes.Quiz.main(args);  // self-test

		// ── DOMAIN: Controlling Program Flow (~9%) ──
		se21.flow.Decisions.compareIntegers(1);
		se21.flow.Decisions.doWhile();
		se21.flow.Decisions.sortStringList();
		// se21.flow.Quiz.main(args);  // self-test

		// ── DOMAIN: Utilizing Java Object-Oriented Approach (~23%) ──
		se21.oop.Polymorphism.main(args);
		se21.oop.Methods.main(args);
		se21.oop.NestedClass.main(args);
		// se21.oop.Quiz.main(args);  // self-test

		// ── DOMAIN: Handling Exceptions (~7%) ──
		se21.exceptions.ExceptionExamples.main(args);
		// se21.exceptions.Quiz.main(args);  // self-test

		// ── DOMAIN: Working with Arrays and Collections (~9%) ──
		se21.collections.ArraysDemo.equality();
		se21.collections.CollectionsExamples.main(args);
		// se21.collections.Quiz.main(args);  // self-test

		// ── DOMAIN: Working with Streams and Lambda Expressions (~17%) ──
		se21.functional.LambdaExamples.main(args);
		se21.functional.StreamsExamples.main(args);
		se21.functional.GenericsExamples.main(args);
		// se21.functional.Quiz.main(args);  // self-test

		// ── DOMAIN: Packaging and Deploying Java Code / JPMS (~8%) ──
		se21.modules.Modules.main(args);
		// se21.modules.Quiz.main(args);  // self-test

		// ── DOMAIN: Managing Concurrent Code Execution (~11%) ──
		se21.concurrency.Concurrency.main(args);
		// se21.concurrency.Quiz.main(args);  // self-test

		// ── DOMAIN: Using Java I/O API (~12%) ──
		se21.io.IOExamples.main(args);
		// se21.io.Quiz.main(args);  // self-test

		// ── DOMAIN: Accessing Databases Using JDBC (~9%) ──
		// se21.jdbc.JDBCExamples.main(args);  // needs a real DB — see class for details
		// se21.jdbc.Quiz.main(args);  // self-test

		// ── DOMAIN: Implementing Localization (~8%) ──
		se21.localization.LocalizationExamples.main(args);
		// se21.localization.Quiz.main(args);  // self-test
	}
}
