package se21;

/**
 * EXAM TOPIC: Multiple exam topics — comprehensive demo
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Control flow: if/else, switch expressions, while, do-while, for, break, continue, labeled loops
 * - Concurrency: parallel streams vs sequential streams
 * - String and StringBuilder: object equality, compile-time constants, common methods
 * - Arrays: equality semantics, copying/expanding arrays
 * - Math/Number API: BigInteger operations
 * - Date/Time API: LocalDate, LocalDateTime, ZonedDateTime
 * - Methods: varargs, overloading, method signatures
 * - Inheritance and interfaces: abstract classes, interface default/static methods, polymorphism
 * - Enums: values(), name(), ordinal(), use in switch
 * - Records: canonical constructor, compact constructor, equals/hashCode/toString auto-generated
 * - Pattern matching: instanceof pattern matching (Java 16+), record deconstruction (Java 21)
 * - Nested classes: inner class instantiation, static nested class, inner records, local classes
 * - var (local variable type inference): used throughout
 */
public class Main {

	public static void main(String[] args) {
		// EXAM: Control flow — if/else, switch expressions, loops (Decisions class covers all branching topics)
		Decisions.compareIntegers(1);
		Decisions.printIntegersGreaterThan5(6);
		Decisions.printOnlyIntegers(-200);
		Decisions.printAnimalBest("Sancha");
		Decisions.shouldGetACoat(Season.FALL); // EXAM: enum used in switch — Season is an enum type

		// EXAM: method overloading — printDetails called with int, double, float; different signatures resolved at compile time
		Decisions.printDetails(5);
		Decisions.printDetails(5.0);
		Decisions.printDetails(5f);

		Decisions.getTrainer(5);

		// EXAM: loop control flow — do-while guarantees at least one execution; break exits loop; continue skips to next iteration
		Decisions.doWhile();
		Decisions.breakLoop();
		Decisions.continueLoop();
		Decisions.sortStringList();

		// EXAM: Concurrency — parallel stream uses ForkJoinPool; sequential stream processes in order; both return same result but order differs
		Concurrency.printListWithParallelStream();
		Concurrency.printListWithStream();

		// EXAM: String and StringBuilder — object vs value equality; compile-time string pool; StringBuilder mutability
		SB.objectExample();
		SB.commonMethods();
		SB.compilationEquality();

		// EXAM: Arrays — arrays do not override equals() (reference comparison); Arrays.copyOf/copyOfRange for expansion
		ArraysDemo.equality();
		ArraysDemo.addingToNew();

		// EXAM: Math/Number API — BigInteger is immutable; operations return new instances; used when values exceed long range
		MathAPI.bigIntOperations();

		// EXAM: Date/Time API — LocalDate/LocalDateTime are immutable; ZonedDateTime includes time zone offset
		DateTimeAPI.examples();
		DateTimeAPI.localExamples();
		DateTimeAPI.zonedExamples();

		// EXAM: varargs — 'int... nums' parameter accepts zero or more ints; must be last parameter; can pass array or individual values
		Methods.zooAnimalCheckup(true);

		Methods.walk(1, new int[] { 1, 2, 3 });
		Methods.walk(4, 5, 6);
		Methods.walk(7);
		Methods.walk(1, new int[] { 1, 2, 3 });

		// EXAM: varargs with String — method can be called with 1, 2, or 3 args; compiler packages extras into an array
		System.out.println(Methods.glide("a"));
		System.out.println(Methods.glide("a", "b"));
		System.out.println(Methods.glide("a", "b", "c"));

		new Methods();

		// EXAM: Inheritance — Bunny and BunnyRabbit demonstrate super calls, method overriding, and interface default methods
		new Bunny().printSuperClass();
		new BunnyRabbit().printSuperClass();
		new BunnyRabbit().printDefault();
		CanRun.printStatic(); // EXAM: interface static methods are NOT inherited; must be called on the interface type directly

		new BunnyRabbit().printObject(new Object(), new Object());

		Object an = new Animal(); // EXAM: polymorphism — Animal stored as Object reference; can only call Object methods without a cast

		Season a = Season.FALL; // EXAM: enum constant assignment; Season.FALL is a singleton instance

		// EXAM: enum iteration — values() returns all constants in declaration order; ordinal() is zero-based index; name() returns constant name
		for (var season : Season.values()) {
			System.out.println(season.name() + "  " + season.ordinal());
		}

		// EXAM: records — auto-generate canonical constructor, equals(), hashCode(), toString() based on components
		var drew = new Programmer("Drew", "Richards", 26);
		var drewClone = new Programmer("Drew Richards", 26);

		System.out.println(drew); // EXAM: record toString() auto-generated; prints all component values

		System.out.println(drew.equals(drewClone)); // EXAM: record equals() compares component values; not reference identity

		// EXAM: record deconstruction pattern (Java 21) — instanceof with record pattern extracts components directly into variables
		if (drew instanceof Programmer(String name2, Integer age2)) {
			System.out.println(name2);
		}

		// EXAM: inner class instantiation syntax — must use an outer instance: 'outerInstance.new InnerClass()'
		new NestedClass().new InnerClass().protectedTopLevelPrint();
		new NestedClass().new InnerClass().new InnerInnerClass(); // EXAM: chained inner class instantiation; each level requires an enclosing instance

		var nestedClass = new NestedClass();

		// EXAM: static nested class — instantiated without an outer instance using 'OuterClass.StaticNested' syntax
		NestedClass.StaticInnerClass staticClass1 = new NestedClass.StaticInnerClass();
		NestedClass.StaticInnerClass staticClass2 = new NestedClass.StaticInnerClass();
		staticClass1.setX(123);

		System.out.println(staticClass2.getX()); // EXAM: static nested class instances are independent; staticClass2 is unaffected by changes to staticClass1

		// EXAM: nested record is implicitly static — accessed as OuterClass.RecordName, no outer instance required
		var innerRecord = new NestedClass.InnerRecord("im static!");

		nestedClass.createLocalClass(); // EXAM: local class — defined and used entirely within a single method; not visible outside
	}

}
