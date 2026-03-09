package se21.lambda;

/**
 * EXAM TOPIC: Lambda Expressions / Implementing Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Traditional class-based implementation of a functional interface (verbose, pre-lambda style)
 * - The lambda equivalent would be: CheckTrait checker = a -> a.canHop();
 * - Understanding that a class implementing a functional interface and a lambda are interchangeable at the call site
 * - @Override ensures the compiler verifies the method signature matches the SAM
 */
public class CheckIfHopper implements CheckTrait { // EXAM: class implementing a functional interface — functionally identical to the lambda: a -> a.canHop()

	//old bad - do not do
	@Override // EXAM: @Override catches signature mismatches at compile time; the lambda equivalent requires no such boilerplate
	public boolean test(Animal a) {
		return a.canHop(); // EXAM: same logic expressible as a lambda body — demonstrates why lambdas replace anonymous/concrete implementations
	}

}