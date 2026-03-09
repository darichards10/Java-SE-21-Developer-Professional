package se21.exam;

/**
 * EXAM TOPIC: Access Modifiers — Same Package Access
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - A non-subclass in the same package can access: public, protected, and package-private members
 * - A non-subclass in the same package CANNOT access: private members
 * - Note: protected access here is granted by same-package rule, NOT by inheritance
 * - This class does NOT extend BaseClass — it holds a reference to one
 */
public class SamePackage {
	void testAccess() {
        BaseClass b = new BaseClass();

        System.out.println(b.pub); // EXAM: public — accessible from anywhere, including unrelated classes in same package
        System.out.println(b.pro); // EXAM: protected — accessible in same package even without inheritance (same-package rule)
        System.out.println(b.def); // EXAM: package-private — accessible because SamePackage is in the same package (se21.exam)
        // System.out.println(b.pri); // EXAM: private — DOES NOT COMPILE; private is never accessible outside the declaring class
    }
}
