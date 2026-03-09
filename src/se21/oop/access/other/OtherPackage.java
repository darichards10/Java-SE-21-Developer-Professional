package se21.oop.access.other;

import se21.oop.access.BaseClass;

/**
 * EXAM TOPIC: Access Modifiers — Different Package, Non-Subclass
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Result: can ONLY access public; NOT protected, package-private, or private
 */
public class OtherPackage {
	void testAccess() {
		BaseClass b = new BaseClass();

		System.out.println(b.pub); // ✅ public — accessible everywhere
		// System.out.println(b.pro); // ❌ DOES NOT COMPILE — protected, but NOT a subclass here
		// System.out.println(b.def); // ❌ DOES NOT COMPILE — package-private; different package
		// System.out.println(b.pri); // ❌ DOES NOT COMPILE — private
	}
}
