package se21.exceptions;

import java.io.IOException;

/**
 * EXAM TOPIC: Exception Handling Oracle Java SE 21 Developer Professional
 * (1Z0-830)
 *
 * Covers: - Checked vs unchecked exceptions: Checked (extends Exception, not
 * RuntimeException) — must be declared with throws or caught Unchecked (extends
 * RuntimeException or Error) — no compile-time enforcement
 *
 * - try-catch-finally blocks: finally always executes (even after return or
 * exception) catch block variable is scoped to that block only
 *
 * - Multi-catch (catch (A | B e)): Catches multiple exception types in one
 * block The variable is implicitly final; cannot reassign inside the block
 * Types must not be related (no supertype/subtype relationship allowed)
 *
 * - try-with-resources (AutoCloseable): Resource declared in try(...) is
 * automatically closed in reverse order close() is called before any catch or
 * finally block Resource must implement AutoCloseable (or Closeable for I/O)
 * Suppressed exceptions: if both body and close() throw, body exception is
 * primary, close() exception is added as suppressed via getSuppressed()
 *
 * - Custom exception classes: Extend Exception (checked) or RuntimeException
 * (unchecked) Convention: provide no-arg constructor and one taking a String
 * message
 *
 * - Exception chaining (cause): new Exception("msg", cause) or
 * e.initCause(cause) Retrieve with getCause(); preserves original exception
 * context
 *
 * - Common exam exceptions to recognize: NullPointerException — accessing
 * member on null reference ArrayIndexOutOfBoundsException — index < 0 or >=
 * array length ClassCastException — invalid cast between incompatible types
 * NumberFormatException — Integer.parseInt("abc") etc. ArithmeticException —
 * integer division by zero (not floating-point) StackOverflowError — unbounded
 * recursion (Error, not Exception) IllegalArgumentException — method receives
 * invalid argument IllegalStateException — method called at wrong time /
 * invalid state
 */
public class Main {

	public static void main(String[] args) {
		// EXAM: this file is a placeholder; exam exception topics are documented in the
		// class Javadoc above
		fall(6);
	}

	static void fall(int distance) {
		try {
			if (distance > 10) {
				throw new IOException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
