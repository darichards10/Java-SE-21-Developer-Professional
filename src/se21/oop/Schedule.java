package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Interfaces
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - private interface methods (Java 9+): not inherited by implementing classes; exist solely to share logic between
 *   default or static methods within the same interface
 * - private static interface methods (Java 9+): like private methods but callable only from static context within the interface
 * - default method delegation: default methods can call private helpers to avoid duplicating code
 * - static interface methods: called on the interface type, not on instances; not inherited
 * - Access modifier summary for interface members: public (default for abstract/default/static), private (Java 9+, helper methods only)
 */
public interface Schedule {
	default void wakeUp()        { checkTime(7);  }  // EXAM: default method — part of the interface's public API; can call private helper methods
	private void haveBreakfast() { checkTime(9);  }  // EXAM: private instance method (Java 9+) — not visible to implementing classes; reduces code duplication among default methods
	static void workOut()        { checkTime(18); }  // EXAM: static interface method — called as Schedule.workOut(); delegates to a private static helper
	private static void checkTime(int hour) {        // EXAM: private static method (Java 9+) — shared helper for both static and default methods; cannot be called from outside the interface
		if (hour > 17) {
			System.out.println("You're late!");
		} else {
			System.out.println("You have " + (17-hour) + " hours left to make the appointment");
		}
	}
}
