package se21.exam.other;

import se21.exam.BaseClass;

/**
 * EXAM TOPIC: Access Modifiers — Different Package (No Inheritance)
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - A non-subclass in a different package can ONLY access: public members
 * - protected, package-private, and private are all inaccessible from a different package without inheritance
 * - This is the most restricted case: no inheritance, no same-package privilege
 * - This class is in se21.exam.other; BaseClass is in se21.exam — a different package
 */
public class OtherPackage {
	void testAccess() {
		BaseClass b = new BaseClass();

		System.out.println(b.pub); // EXAM: public — the ONLY modifier accessible from a completely unrelated class in a different package
		// System.out.println(b.pro); // EXAM: protected — DOES NOT COMPILE; protected requires same package OR subclass relationship
		// System.out.println(b.def); // EXAM: package-private — DOES NOT COMPILE; only accessible within se21.exam, not se21.exam.other
		// System.out.println(b.pri); // EXAM: private — DOES NOT COMPILE; never accessible outside declaring class
	}
}
