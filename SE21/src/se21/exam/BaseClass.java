package se21.exam;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Access Modifiers
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - public: accessible everywhere — same class, same package, subclass, different package
 * - protected: accessible in same class, same package, AND subclasses in other packages (via inheritance only)
 * - package-private (no modifier): accessible only within the same package; NOT accessible from subclasses in other packages
 * - private: accessible only within the declaring class itself; never inherited
 * - Access modifier rules apply to both fields and methods
 * - This class is the baseline used by SamePackage, SubSamePackage, OtherPackage, ProtectedTrick, SubOtherPackage
 */
public class BaseClass {

    public int pub = 1;        // EXAM: public — widest access; visible to all classes everywhere
    protected int pro = 2;     // EXAM: protected — visible in same package AND in subclasses of other packages (via 'this', not a parent-typed reference)
    int def = 3;               // EXAM: package-private (default, no modifier) — visible only within se21.exam package; NOT accessible in se21.exam.other even through inheritance
    private int pri = 4;       // EXAM: private — visible only inside BaseClass; never accessible in subclasses or other classes

    protected void protectedMethod() {} // EXAM: protected method — same rules as protected field; accessible via subclass reference in other packages
    void defaultMethod() {}             // EXAM: package-private method — only callable from within se21.exam package
    private void privateMethod() {}     // EXAM: private method — cannot be overridden or called from any other class
}