package se21;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Polymorphism
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Upcasting (implicit): assigning a subtype reference to a supertype variable; always safe, no cast needed
 * - Downcasting (explicit): requires a cast; throws ClassCastException at runtime if the object is not actually that type
 * - instanceof check: use before casting to avoid ClassCastException; pattern matching instanceof (Java 16+) combines check and cast
 * - Reference type vs object type: the reference type determines which members are visible at compile time;
 *   the object's actual runtime type determines which overridden method is called (dynamic dispatch)
 * - Polymorphic method calls: virtual (instance) method calls resolve to the overriding subclass method at runtime
 * - Static methods are NOT polymorphic: they are bound at compile time to the reference type (hidden, not overridden)
 * - super keyword: explicitly calls the superclass version of an overridden method, bypassing dynamic dispatch
 * - ClassCastException: Wolf implements Canine, NOT Dog — casting wolfy to Dog will throw ClassCastException at runtime
 */
public class Polymorphism {

	void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age); // EXAM: field access uses the reference type's declared field; fields are NOT polymorphic

		HasTail hasTail = lemur; // EXAM: implicit upcast — Lemur implements HasTail; no explicit cast needed; safe
		System.out.println(hasTail.isTailStriped()); // EXAM: dynamic dispatch — runtime type is Lemur, so Lemur.isTailStriped() is called

		Primate primate = lemur; // EXAM: implicit upcast — Lemur extends Primate; only Primate members visible through this reference
		System.out.println(primate.hasHair()); // EXAM: calls Primate.hasHair() — Lemur does not override it, so the superclass version runs

		Wolf wolfy = new Wolf();
		Dog badWold = (Dog) wolfy; // EXAM: DANGER — Wolf implements Canine, NOT Dog; no compile error (both are interfaces) but throws ClassCastException at runtime

		// 8
		EmperorPenguin peng = new EmperorPenguin();
		peng.printInfo();    // EXAM: Penguin.printInfo() calls 'this.getHeight()' — 'this' is EmperorPenguin at runtime, so getHeight() returns 8 (polymorphic call)
		peng.getSuperHeight(); // EXAM: super.getHeight() bypasses overriding and always calls Penguin.getHeight(), returning 3

	}

	class Primate {
		boolean hasHair() {
			return true;
		}
	}

	interface HasTail {
		abstract boolean isTailStriped(); // EXAM: 'abstract' here is redundant — interface methods are implicitly abstract; legal but unnecessary
	}

	interface Canine {

	}

	interface Dog {
	}

	class Wolf implements Canine { // EXAM: Wolf IS-A Canine but is NOT a Dog; casting to Dog causes ClassCastException at runtime

	}

	class Lemur extends Primate implements HasTail { // EXAM: Lemur satisfies both superclass (Primate) and interface (HasTail) contracts
		int age = 10;

		@Override
		public boolean isTailStriped() { // EXAM: overrides the interface's abstract method; must be public (cannot reduce visibility from interface's implicit public)
			return false;
		}

	}

	class Penguin {
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

	public class EmperorPenguin extends Penguin {
		public int getHeight() { // EXAM: overrides Penguin.getHeight(); called whenever 'this' or a Penguin reference holds an EmperorPenguin at runtime
			return 8;
		}

		int getSuperHeight() {
			return super.getHeight(); // EXAM: super bypasses dynamic dispatch; explicitly calls Penguin.getHeight() returning 3, even though this is an EmperorPenguin
		}
	}
}
