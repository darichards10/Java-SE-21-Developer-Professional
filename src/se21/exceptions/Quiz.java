package se21.exceptions;

/**
 * SELF-TEST: Handling Exceptions
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~7% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: Which is a CHECKED exception?
	// a) NullPointerException   b) IOException   c) RuntimeException   d) StackOverflowError
	// ANSWER: ___

	// Q2: What happens to a try-with-resources exception if close() also throws?
	// a) The close() exception replaces the original exception
	// b) The original exception is primary; close() exception added as suppressed
	// c) Both exceptions are thrown simultaneously
	// d) The finally block handles both
	// ANSWER: ___

	// Q3: What is the output?
	//   try { throw new RuntimeException("a"); }
	//   catch (RuntimeException e) { System.out.println("caught: " + e.getMessage()); }
	//   finally { System.out.println("finally"); }
	// a) "caught: a" then "finally"   b) "finally" only   c) "caught: a" only   d) nothing
	// ANSWER: ___

	// Q4: Which of the following is ILLEGAL in a multi-catch block?
	// a) catch (IOException | SQLException e)
	// b) catch (IOException | RuntimeException e)
	// c) catch (Exception | RuntimeException e)  ← one is supertype of other
	// d) All of the above are legal
	// ANSWER: ___

	// Q5: What is the output?
	//   try { int x = 5 / 0; }
	//   catch (ArithmeticException e) { System.out.println("div: " + e.getMessage()); return; }
	//   finally { System.out.println("always"); }
	// a) "div: / by zero" then "always"   b) "div: / by zero" only   c) "always" only   d) compile error
	// ANSWER: ___

	// Q6: What extends RuntimeException?
	// a) IOException   b) NullPointerException   c) Error   d) Exception
	// ANSWER: ___

	// Q7: Can you catch Error in a catch block?
	// a) No — Error cannot be caught
	// b) Yes — Error can be caught with catch (Error e) or catch (Throwable t)
	// c) Only in finally blocks
	// d) Only if the method declares throws Error
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1: b) IOException — extends Exception but not RuntimeException; must be caught or declared
		System.out.println("Q1: b) IOException is checked");

		// Q2: b) Body exception is primary; close() exception is suppressed (getSuppressed())
		System.out.println("Q2: b) Original is primary; close() exception is suppressed");

		// Q3 verification
		try {
			throw new RuntimeException("a");
		} catch (RuntimeException e) {
			System.out.println("Q3: caught: " + e.getMessage());
		} finally {
			System.out.println("Q3: finally"); // always runs, even after return in catch
		}

		// Q4: c) Exception is a supertype of RuntimeException — multi-catch cannot have related types
		System.out.println("Q4: c) Illegal — related exception types in multi-catch");

		// Q5 verification
		try {
			int x = 5 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Q5: div: " + e.getMessage());
			// finally still runs even though catch has return
		} finally {
			System.out.println("Q5: always"); // finally runs before the return in catch
		}

		// Q6: b) NullPointerException extends RuntimeException
		System.out.println("Q6: b) NullPointerException extends RuntimeException");

		// Q7: b) Error CAN be caught; generally bad practice, but legal
		try {
			throw new StackOverflowError();
		} catch (Error e) {
			System.out.println("Q7: caught Error: " + e.getClass().getSimpleName());
		}
	}
}
