package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - abstract class rules: cannot be instantiated directly; may mix abstract and concrete methods
 * - abstract method declaration: no body; subclass must override unless it is also abstract
 * - varargs (Object...objects): treated as an array inside the method; must be the last parameter
 * - Default (package-private) access: methods without an access modifier are accessible only within the same package
 */
public abstract class Logger { // EXAM: abstract class — cannot use 'new Logger()'; must be subclassed

	void printObject(Object...objects) { // EXAM: varargs — caller may pass zero or more Object args; internally treated as Object[]
		for (Object obj : objects) {
			System.out.println(obj);
		}
		System.out.println(objects.toString()); // EXAM: calls Object.toString() on the array itself — prints [Ljava.lang.Object;@<hashcode>
	}

	abstract void printMe(); // EXAM: abstract method — no body, no braces; concrete subclass must provide an implementation or itself be declared abstract
}
