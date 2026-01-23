package se21.exam;

public class SamePackage {
	void testAccess() {
        BaseClass b = new BaseClass();

        System.out.println(b.pub); // ✅ OK
        System.out.println(b.pro); // ✅ OK
        System.out.println(b.def); // ✅ OK
        // System.out.println(b.pri); // ❌ DOES NOT COMPILE
    }
}
