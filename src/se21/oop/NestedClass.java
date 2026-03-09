package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Nested Classes
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Static nested class: declared with 'static'; no implicit outer instance; can only access outer static members
 * - Inner class (non-static nested): holds implicit reference to enclosing instance (Outer.this); can access all outer members including private
 * - Local class: declared inside a method; scoped to that method; can access effectively final local variables
 * - Anonymous class: nameless class defined and instantiated inline; implements interface or extends class
 * - Inner record (Java 16+): records nested inside a class are implicitly static
 * - Nested interface: implicitly static regardless of whether 'static' keyword is used
 * - Qualified 'this' syntax: InnerClass.this and NestedClass.this to disambiguate shadowed fields
 * - Access rules: inner classes can access private members of the enclosing class
 */
public class NestedClass {
	private String text = "private top level string";
	int x = 7;
	AbstractClass anon = new AbstractClass() { // EXAM: anonymous class extending AbstractClass — no class name, declared and instantiated inline
		int getVal() { return 10;}
	};

	// EXAM: nested interface is implicitly static — does not need an outer instance
	interface NestedInterface {
		int getVal();
		void printSomething();
	}

	// EXAM: anonymous class implementing a nested interface — common exam pattern
	NestedInterface nestFace = new NestedInterface() {
		@Override
		public int getVal() {
			return 0;
		}

		@Override
		public void printSomething() {
		}
	};

	public NestedClass() {
		new InnerClass(); // EXAM: inner class instantiation requires an enclosing instance (implicitly 'this')
		var x = new StaticInnerClass().x; // EXAM: static nested class instantiated without an outer instance
		anon.printSomething();
	}

	//@TODO
	public static void main(String[] args) {
		
	}

	public void createLocalClass() {
		// EXAM: local class — declared inside a method body; only accessible within that method
		class LocalClass {
			static void print() {System.out.println("im a local");} // EXAM: local classes can have static members in Java 16+
		}
		LocalClass.print();
	}

	// EXAM: records nested inside a class are implicitly static (Java 16+); cannot be non-static inner records
	record InnerRecord(String name) {
		//implicitly static
	}

	// EXAM: static nested class — no implicit reference to enclosing instance; cannot access instance members of outer class
	static class StaticInnerClass {
		private int x = 10;

		void setX(int x) {
			this.x = x;
		}

		int getX() {
			return this.x;
		}
	}

	// EXAM: non-static inner class — holds implicit reference to enclosing NestedClass instance
	protected class InnerClass {
		int x = 8; // EXAM: field 'x' shadows NestedClass.this.x — disambiguation required
		private void printTopLevelString() {
			System.out.println(text); // EXAM: inner class can access private members of the enclosing outer class
		}

		public InnerClass() {
			printTopLevelString();
		}

		protected void protectedTopLevelPrint() {
			printTopLevelString();
		}

		// EXAM: inner class nested inside another inner class — both levels maintain their enclosing instance references
		class InnerInnerClass {
			int x = 9; // EXAM: third level of field shadowing

			InnerInnerClass() {
				System.out.println(this.x);            // EXAM: 'this.x' = InnerInnerClass.x (9)
				System.out.println(x);                 // EXAM: unqualified 'x' also resolves to InnerInnerClass.x (9)
				System.out.println(InnerClass.this.x); // EXAM: qualified 'this' to access InnerClass.x (8)
				System.out.println(NestedClass.this.x);// EXAM: qualified 'this' to access NestedClass.x (7) — key exam syntax
			}
		}
	}
}
