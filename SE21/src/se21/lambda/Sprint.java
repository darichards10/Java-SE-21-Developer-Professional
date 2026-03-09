package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions and Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - @FunctionalInterface enforces at compile time that the interface has exactly one abstract method (SAM)
 * - Methods redeclaring java.lang.Object public methods (equals, hashCode, toString) do NOT count as abstract methods
 *   toward the SAM requirement — a common exam trick
 * - The annotation is optional but recommended; it causes a compile error if the SAM rule is violated
 * - sprint(int) is the sole abstract method; the rest are Object overrides and are ignored by the SAM check
 */
@FunctionalInterface // EXAM: optional but causes compile error if more than one abstract method is added — good practice and exam-tested
public interface Sprint {
	public void sprint(int speed); // EXAM: the one true SAM — this is what a lambda or method reference must implement

	public boolean equals(Object o); // EXAM: redeclaring an Object method does NOT break the SAM rule — exam frequently tests this

	public abstract int hashCode(); // EXAM: same rule — Object method redeclarations are excluded from the abstract method count

	String toString(); // EXAM: again an Object method — still only one SAM (sprint), so @FunctionalInterface is satisfied
}
