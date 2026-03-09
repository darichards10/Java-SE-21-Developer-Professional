package se21.oop;

public class Penguin {
	public int getHeight() { // EXAM: instance method — overridable; runtime type determines which version runs (virtual dispatch)
		return 3;
	}

	public static int getStaticHeight() { // EXAM: static method — NOT overridden by subclasses, only hidden; always resolves based on reference type at compile time
		return 3;
	}

	public void printInfo() {
		System.out.print(this.getHeight()); // EXAM: 'this.getHeight()' is a virtual call — resolves to EmperorPenguin.getHeight() when 'this' is an EmperorPenguin; prints 8
	}

	public void printStaticInfor() {
		System.out.println(this.getStaticHeight()); // EXAM: static method called via instance reference — resolved at compile time to Penguin.getStaticHeight(); always prints 3 (not polymorphic)
	}
}
