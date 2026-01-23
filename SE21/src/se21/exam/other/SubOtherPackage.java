package se21.exam.other;

import se21.exam.BaseClass;

public class SubOtherPackage extends BaseClass {

    void testAccess() {
        System.out.println(pub); // ✅ OK
        System.out.println(pro); // ✅ OK
        // System.out.println(def); // ❌ DOES NOT COMPILE
        // System.out.println(pri); // ❌ DOES NOT COMPILE
    }
}