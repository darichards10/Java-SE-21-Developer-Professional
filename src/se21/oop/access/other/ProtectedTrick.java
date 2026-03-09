package se21.oop.access.other;

import se21.oop.access.BaseClass;

/**
 * EXAM TOPIC: Access Modifiers — Protected Trick (Key Exam Pattern)
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * EXAM TRAP: In a different-package subclass, you can access 'protected' on YOUR OWN INSTANCE (this or subclass ref),
 * but NOT on a reference of the PARENT type (BaseClass b = new BaseClass()).
 *
 * Rule: protected access through inheritance is only allowed on a reference of the same class or a subtype.
 */
public class ProtectedTrick extends BaseClass {

	void testAccess() {
		BaseClass b = new BaseClass();
		ProtectedTrick s = new ProtectedTrick();

		// System.out.println(b.pro); // ❌ DOES NOT COMPILE — 'b' is a BaseClass reference; protected not accessible this way from a different package
		System.out.println(s.pro);    // ✅ OK — 's' is a ProtectedTrick reference (subclass); protected accessible via subclass reference
		System.out.println(pro);      // ✅ OK — unqualified 'pro' is inherited; equivalent to this.pro
	}
}
