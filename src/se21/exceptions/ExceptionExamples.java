package se21.exceptions;

import java.io.IOException;

/**
 * EXAM TOPIC: Handling Exceptions Oracle Java SE 21 Developer Professional
 * (1Z0-830) — ~7% of exam
 *
 * Covers: - Checked vs unchecked exceptions: Checked (extends Exception, not
 * RuntimeException) — must be declared with throws or caught Unchecked (extends
 * RuntimeException or Error) — no compile-time enforcement - try-catch-finally
 * blocks: finally always executes (even after return or exception) -
 * Multi-catch (catch (A | B e)): catches multiple exception types in one block;
 * the variable is implicitly final; types must not be related (no
 * supertype/subtype relationship) - try-with-resources (AutoCloseable):
 * resource declared in try(...) is automatically closed; close() is called
 * before any catch or finally block; resources closed in reverse declaration
 * order - Suppressed exceptions: if body and close() both throw, body exception
 * is primary; close() exception added as suppressed via getSuppressed() -
 * Custom exception classes: extend Exception (checked) or RuntimeException
 * (unchecked) - Exception chaining (cause): new Exception("msg", cause) —
 * retrieve with getCause() - Common exam exceptions: NullPointerException,
 * ArrayIndexOutOfBoundsException, ClassCastException, NumberFormatException,
 * ArithmeticException (integer /0), StackOverflowError,
 * IllegalArgumentException, IllegalStateException
 */
public class ExceptionExamples {

	public static void main(String[] args) {
		tryCatchFinally((int) 10.9);
		multiCatch();
		tryWithResources();
		exceptionChaining();
		arithmeticException();
		goHome();
	}

	static void arithmeticException() {
		try {
			int answer = 11 / 0;

//			catch(Exception1 e | Exception2 e | Exception3 e)    // DOES NOT COMPILE
//			catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // DOES NOT COMPILE
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println("Caught: " + e.getClass().getSimpleName());
		}

	}

	static void tryCatchFinally(int distance) {
		try {
			if (distance > 10) {
				throw new IOException(); // EXAM: checked exception — must be declared in throws or caught
			}
			System.out.println("No exception for distance " + distance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally always runs"); // EXAM: finally runs even if return or exception in try/catch
		}
	}

	static void multiCatch() {
		try {
			String s = null;
			s.length(); // throws NullPointerException
		} catch (NullPointerException | IllegalArgumentException e) {
			// EXAM: multi-catch; 'e' is implicitly final; cannot reassign e inside block
			System.out.println("Caught: " + e.getClass().getSimpleName());
		}
	}

	static void tryWithResources() {
		// EXAM: AutoCloseable resources are closed before catch/finally; reverse
		// declaration order
		try (var r1 = new MyResource("R1"); var r2 = new MyResource("R2")) {
			System.out.println("Using resources");
			// r2.close() called first, then r1.close() — reverse order
		} catch (Exception e) {
			System.out.println("Caught: " + e.getMessage());
		}
	}

	static void exceptionChaining() {
		try {
			try {
				throw new IOException("original"); // EXAM: original cause
			} catch (IOException e) {
				throw new RuntimeException("wrapped", e); // EXAM: wraps with cause for context
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage()); // "wrapped"
			System.out.println(e.getCause().getMessage()); // "original"
		}
	}

	// EXAM: custom checked exception — extend Exception (not RuntimeException)
	static class AppException extends Exception {
		public AppException(String message) {
			super(message);
		}
	}

	// EXAM: custom unchecked exception — extend RuntimeException
	static class AppRuntimeException extends RuntimeException {
		public AppRuntimeException(String message) {
			super(message);
		}
	}

	// EXAM: AutoCloseable implementation for try-with-resources
	static class MyResource implements AutoCloseable {
		private final String name;

		MyResource(String name) {
			this.name = name;
			System.out.println("Opening " + name);
		}

		@Override
		public void close() throws Exception {
			System.out.println("Closing " + name); // EXAM: called automatically at end of try block
		}
	}

	@SuppressWarnings("finally")
	static int goHome() {
		try {
			System.out.println("-1");
			return -1;
		} catch (AppRuntimeException e) {
			System.out.println("-2");
			return -2;
		} finally {
			System.out.println("-3");
			return -3;
		}
	}
}
