package se21.exam;

public class SubSamePackage extends BaseClass {

    void testAccess() {
        System.out.println(pub); // ✅ OK
        System.out.println(pro); // ✅ OK
        System.out.println(def); // ✅ OK
        // System.out.println(pri); // ❌ DOES NOT COMPILE
    }
}