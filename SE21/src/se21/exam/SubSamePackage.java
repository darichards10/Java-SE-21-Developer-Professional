package se21.exam;

/**
 * EXAM TOPIC: Access Modifiers — Subclass in Same Package
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - A subclass in the same package inherits: public, protected, and package-private members
 * - A subclass in the same package does NOT inherit: private members
 * - package-private (default) members ARE inherited when subclass is in the same package
 * - Contrast with SubOtherPackage: different-package subclasses do NOT inherit package-private members
 * - Inherited members accessed directly without a reference (via implicit 'this')
 */
public class SubSamePackage extends BaseClass {

    void testAccess() {
        System.out.println(pub); // EXAM: public — inherited and directly accessible; widest access
        System.out.println(pro); // EXAM: protected — inherited by subclasses; accessible here both by inheritance AND same-package rules
        System.out.println(def); // EXAM: package-private — inherited because subclass is in the SAME package (se21.exam); would fail in a different package
        // System.out.println(pri); // EXAM: private — DOES NOT COMPILE; private members are NEVER inherited by any subclass
    }
}