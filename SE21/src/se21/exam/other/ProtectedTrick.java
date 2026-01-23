package se21.exam.other;

import se21.exam.BaseClass;

public class ProtectedTrick extends BaseClass {

    void testAccess() {
        BaseClass b = new BaseClass();
        ProtectedTrick s = new ProtectedTrick();

        // System.out.println(b.pro); // ❌ DOES NOT COMPILE
        System.out.println(s.pro);    // ✅ OK
        System.out.println(pro);      // ✅ OK
    }
}