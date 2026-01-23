package se21.exam.other;

import se21.exam.BaseClass;

public class OtherPackage {
	void testAccess() {
		BaseClass b = new BaseClass();

		System.out.println(b.pub); // ✅ OK
		// System.out.println(b.pro); // ❌ DOES NOT COMPILE
		// System.out.println(b.def); // ❌ DOES NOT COMPILE
		// System.out.println(b.pri); // ❌ DOES NOT COMPILE
	}
}
