package se21.oop;

/**
 * SELF-TEST: Java Object-Oriented Approach
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is the output of new BunnyRabbit()?
	// (BunnyRabbit extends Bunny; Bunny extends Logger; both have static initializers)
	// a) static bunny → static bunnyrabbit → constructor bunny → constructor bunnyrabbit
	// b) static bunnyrabbit → static bunny → constructor bunnyrabbit → constructor bunny
	// c) constructor bunny → constructor bunnyrabbit
	// d) compile error
	// ANSWER: ___

	// Q2: Which of the following is true about records?
	// a) Records can extend other classes
	// b) Records can implement multiple interfaces
	// c) Records can have non-final instance fields declared in the body
	// d) Records are not implicitly final
	// ANSWER: ___

	// Q3: What is the output?
	//   class Penguin { int getHeight() { return 3; } void printInfo() { System.out.println(this.getHeight()); } }
	//   class EmperorPenguin extends Penguin { int getHeight() { return 8; } }
	//   new EmperorPenguin().printInfo();
	// a) 3   b) 8   c) compile error   d) runtime error
	// ANSWER: ___

	// Q4: Which access modifier allows access from a different-package subclass?
	// a) private   b) package-private (default)   c) protected   d) protected and public
	// ANSWER: ___

	// Q5: What is wrong with the following?
	//   interface Greet {
	//       private static String helper() { return "hi"; }
	//       default String greet() { return helper(); }
	//   }
	// a) private static interface methods are illegal
	// b) default methods cannot call private methods
	// c) Nothing — this is valid Java 9+ syntax
	// d) interface methods must be public
	// ANSWER: ___

	// Q6: What is the output?
	//   public enum Color { RED, GREEN, BLUE }
	//   System.out.println(Color.GREEN.ordinal());
	// a) 0   b) 1   c) 2   d) "GREEN"
	// ANSWER: ___

	// Q7: @FunctionalInterface — which interface satisfies the SAM rule?
	// a) interface A { void m(); void n(); }
	// b) interface B { void m(); boolean equals(Object o); }
	// c) interface C { void m(); default void n() {} void p(); }
	// d) interface D {}
	// ANSWER: ___

	// Q8: What is the output?
	//   NestedClass.InnerClass inner = new NestedClass().new InnerClass();
	//   (where InnerClass prints text="private top level string" in constructor)
	// a) compile error   b) "private top level string"   c) null   d) runtime exception
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1: static initializers run at class load in parent-first order; then constructors
		System.out.println("Q1: a) static bunny → static bunnyrabbit → constructor bunny → constructor bunnyrabbit");
		new BunnyRabbit(); // run to verify order

		// Q2: b) Records can implement multiple interfaces
		System.out.println("Q2: b) Records can implement multiple interfaces");

		// Q3: dynamic dispatch — EmperorPenguin.getHeight() called via 'this'; prints 8
		System.out.println("Q3: 8 (dynamic dispatch via 'this.getHeight()')");

		// Q4: d) protected and public
		System.out.println("Q4: d) protected and public");

		// Q5: c) Valid Java 9+ — private static interface methods are legal
		System.out.println("Q5: c) Valid Java 9+ syntax");

		// Q6: GREEN is at index 1 (RED=0, GREEN=1, BLUE=2)
		System.out.println("Q6: " + 1); // ordinal() of GREEN = 1

		// Q7: b) equals(Object o) is an Object method declaration — doesn't count toward SAM; only m() is abstract
		System.out.println("Q7: b) interface B has SAM m(); equals(Object) is Object override");

		// Q8: b) Inner class can access private members of enclosing class
		System.out.println("Q8: b) \"private top level string\" — inner class accesses private outer field");
	}
}
