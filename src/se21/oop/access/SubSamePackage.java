package se21.oop.access;

/**
 * EXAM TOPIC: Access Modifiers — Same Package, Subclass
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Result: can access public, protected, and package-private; NOT private
 * Same as SamePackage but accessed via inheritance (unqualified field access)
 */
public class SubSamePackage extends BaseClass {

	void testAccess() {
		System.out.println(pub); // ✅ public — inherited
		System.out.println(pro); // ✅ protected — inherited; accessible in subclass
		System.out.println(def); // ✅ package-private — same package
		// System.out.println(pri); // ❌ DOES NOT COMPILE — private
	}
}
