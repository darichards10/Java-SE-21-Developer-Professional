package se21.functional;

import java.util.List;

/**
 * EXAM TOPIC: Records + Functional Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Covers:
 * - Records auto-generate accessor methods (canHop(), canSwim(), species()) usable as method references
 * - Passing a functional interface (CheckTrait) as a method parameter enables lambda/method-reference arguments at the call site
 * - Records are implicitly final and cannot be extended; their accessors match the component names exactly
 * - Static methods in records are valid and commonly used as utility/factory helpers
 */
public record LambdaAnimal(String species, boolean canHop, boolean canSwim) { // EXAM: record auto-generates canHop(), canSwim(), species() accessors — usable as instance method references

	// EXAM: accepting a functional interface parameter here allows callers to pass a lambda or method reference (e.g., a -> a.canHop())
	static void printAnimals(List<LambdaAnimal> animals, CheckTrait checker) {
		for (LambdaAnimal animal : animals) {
			boolean test = checker.test(animal); // EXAM: invoking the SAM of the functional interface — checker could be a lambda, method ref, or class instance
			System.out.println(test);
		}
	}
}
