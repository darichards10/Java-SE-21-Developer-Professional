package se21.oop.access;

/**
 * EXAM TOPIC: Java Object-Oriented Approach — Access Modifiers
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Four access levels: public, protected, package-private (default), private
 * - public: accessible everywhere
 * - protected: accessible within same package AND by subclasses in other packages (but only via inheritance)
 * - package-private (default): accessible only within the same package
 * - private: accessible only within the declaring class
 *
 * Study with the sibling classes to see how access rules apply:
 *   SamePackage         — non-subclass in same package
 *   SubSamePackage      — subclass in same package
 *   access.other.OtherPackage      — non-subclass in different package
 *   access.other.SubOtherPackage   — subclass in different package
 *   access.other.ProtectedTrick    — subclass in different package; shows protected trick
 */
public class BaseClass {

	public int pub = 1;        // EXAM: visible everywhere
	protected int pro = 2;    // EXAM: same package + subclasses (via reference of their own type — see ProtectedTrick)
	int def = 3;              // EXAM: package-private — visible only within se21.oop.access
	private int pri = 4;      // EXAM: invisible outside BaseClass

	protected void protectedMethod() {}
	void defaultMethod() {}
	private void privateMethod() {}
}
