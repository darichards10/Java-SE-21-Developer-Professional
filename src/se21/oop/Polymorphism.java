package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Polymorphism
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
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

	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age); // EXAM: field access uses the reference type's declared field; fields are NOT polymorphic

		HasTail hasTail = lemur; // EXAM: implicit upcast — Lemur implements HasTail; no explicit cast needed; safe
		System.out.println(hasTail.isTailStriped()); // EXAM: dynamic dispatch — runtime type is Lemur, so Lemur.isTailStriped() is called

		Primate primate = lemur; // EXAM: implicit upcast — Lemur extends Primate; only Primate members visible through this reference
		System.out.println(primate.hasHair()); // EXAM: calls Primate.hasHair() — Lemur does not override it, so the superclass version runs

		Wolf wolfy = new Wolf();
//		Dog badWold = (Dog) wolfy; // EXAM: DANGER — Wolf implements Canine, NOT Dog; no compile error (both are interfaces) but throws ClassCastException at runtime

		// 8
		EmperorPenguin peng = new EmperorPenguin();
		peng.printInfo();    // EXAM: Penguin.printInfo() calls 'this.getHeight()' — 'this' is EmperorPenguin at runtime, so getHeight() returns 8 (polymorphic call)
		peng.getSuperHeight(); // EXAM: super.getHeight() bypasses overriding and always calls Penguin.getHeight(), returning 3
	}
}
