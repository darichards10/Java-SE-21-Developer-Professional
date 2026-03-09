package se21.oop.access.other;

import se21.oop.access.BaseClass;

/**
 * EXAM TOPIC: Access Modifiers — Different Package, Subclass
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Result: can access public and protected (via inheritance); NOT package-private or private
 */
public class SubOtherPackage extends BaseClass {

	void testAccess() {
		System.out.println(pub); // ✅ public — inherited
		System.out.println(pro); // ✅ protected — accessible in subclass, even in different package
		// System.out.println(def); // ❌ DOES NOT COMPILE — package-private; different package
		// System.out.println(pri); // ❌ DOES NOT COMPILE — private
	}
}
