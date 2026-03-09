package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions / Implementing Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Concrete class implementing a @FunctionalInterface — valid and equivalent to a lambda at the call site
 * - A class must implement exactly the one abstract method; inherited Object methods (equals, hashCode, toString) do not count
 * - Lambda equivalent: Sprint s = speed -> System.out.println("Sprinting fast: " + speed);
 */
public class Tiger implements Sprint { // EXAM: concrete class satisfying the SAM contract of @FunctionalInterface Sprint

	@Override
	public void sprint(int speed) { // EXAM: only one abstract method to implement — satisfies the SAM requirement; lambda equivalent eliminates this class entirely
		System.out.println("Sprinting fast: " + speed);
	}

}
