package se21.exam.other;

import se21.exam.BaseClass;

/**
 * EXAM TOPIC: Access Modifiers — Protected Access via Inheritance (Different Package)
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - The critical 'protected trick': in a different package, protected is accessible ONLY through inheritance
 * - A subclass in a different package CAN access protected members via 'this' or a reference of its own type
 * - A subclass in a different package CANNOT access protected members via a reference of the parent type (BaseClass)
 * - This is one of the most frequently tested access modifier nuances on the 1Z0-830 exam
 * - Rule: 'b.pro' fails because 'b' is typed as BaseClass; 's.pro' succeeds because 's' is typed as ProtectedTrick (the subclass)
 */
public class ProtectedTrick extends BaseClass {

    void testAccess() {
        BaseClass b = new BaseClass();
        ProtectedTrick s = new ProtectedTrick();

        // System.out.println(b.pro); // EXAM: DOES NOT COMPILE — accessing protected via a BaseClass reference in a different package is forbidden, even from a subclass
        System.out.println(s.pro);    // EXAM: OK — accessing protected via a ProtectedTrick (subclass) reference is allowed; the receiver type matters
        System.out.println(pro);      // EXAM: OK — unqualified 'pro' is equivalent to 'this.pro'; 'this' is always the subclass type
    }
}