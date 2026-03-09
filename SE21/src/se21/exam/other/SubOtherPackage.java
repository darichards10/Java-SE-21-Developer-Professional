package se21.exam.other;

import se21.exam.BaseClass;

/**
 * EXAM TOPIC: Access Modifiers — Subclass in Different Package
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - A subclass in a different package inherits: public and protected members
 * - A subclass in a different package does NOT inherit: package-private or private members
 * - package-private (default) access does NOT cross package boundaries, even via inheritance
 * - Contrast with SubSamePackage: same-package subclass DOES inherit package-private members
 * - This is the key difference between 'protected' and 'package-private' for subclass access
 */
public class SubOtherPackage extends BaseClass {

    void testAccess() {
        System.out.println(pub); // EXAM: public — inherited by all subclasses regardless of package
        System.out.println(pro); // EXAM: protected — inherited by subclasses even across packages; this is protected's cross-package benefit over package-private
        // System.out.println(def); // EXAM: package-private — DOES NOT COMPILE; default access does NOT cross package boundaries even through inheritance
        // System.out.println(pri); // EXAM: private — DOES NOT COMPILE; private is never inherited
    }
}