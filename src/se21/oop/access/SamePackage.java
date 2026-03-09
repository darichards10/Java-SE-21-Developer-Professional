package se21.oop.access;

/**
 * EXAM TOPIC: Access Modifiers — Same Package, Non-Subclass
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Result: can access public, protected, and package-private; NOT private
 */
public class SamePackage {
	void testAccess() {
		BaseClass b = new BaseClass();

		System.out.println(b.pub); // ✅ public — accessible everywhere
		System.out.println(b.pro); // ✅ protected — accessible within same package
		System.out.println(b.def); // ✅ package-private — same package
		// System.out.println(b.pri); // ❌ DOES NOT COMPILE — private
	}
}
