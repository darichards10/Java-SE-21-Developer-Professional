package se21.functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * EXAM TOPIC: Lambda Expressions, Functional Interfaces, and Method References
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Covers:
 * - All built-in functional interfaces: Predicate, BiPredicate, Consumer, BiConsumer,
 *   Supplier, Function, BiFunction, UnaryOperator, BinaryOperator
 * - Lambda syntax variations: no-brace single expression, explicit return with braces, typed/untyped params
 * - Four method reference types:
 *     1. Static:               ClassName::staticMethod   (e.g., LambdaExamples::toUpper, Integer::compare)
 *     2. Instance on instance: obj::instanceMethod       (e.g., mainInstance::addExclamation, System.out::println)
 *     3. Instance on type:     ClassName::instanceMethod (e.g., String::isEmpty, String::length)
 *     4. Constructor:          ClassName::new            (e.g., String::new)
 * - Chaining default methods: Predicate.and(), or(), negate(); Function.andThen(), compose()
 * - Consumer chaining with andThen()
 * - Variable capture: lambdas may reference effectively final local variables only
 */
public class LambdaExamples {

	public static void main(String[] args) {
		var animals = new ArrayList<LambdaAnimal>();
		animals.add(new LambdaAnimal("fish", false, true));
		animals.add(new LambdaAnimal("kangaroo", true, false));
		animals.add(new LambdaAnimal("rabbit", true, false));
		animals.add(new LambdaAnimal("turtle", false, true));

		LambdaAnimal.printAnimals(animals, a -> a.canHop()); // EXAM: lambda with single param (no parens needed), no-brace body

		Duckling.makeSound("gyyang");

		List<Integer> nums = Arrays.asList(5, 2, 3, 4, 1, 6);
		nums.stream().sorted(Integer::compare).forEach(System.out::println); // EXAM: static method ref + instance-on-instance ref chained on a stream

		// References to static methods
		StringOperation lambda = s -> LambdaExamples.toUpper(s); // EXAM: lambda wrapping a static method call — equivalent to the method reference below
		System.out.println(lambda.process("hello"));

		StringOperation ref = LambdaExamples::toUpper; // EXAM: static method reference (ClassName::staticMethod) — preferred concise form
		System.out.println(ref.process("world"));

		List<String> names = List.of("kylo", "thomas");
		names.forEach(System.out::println); // EXAM: instance-on-instance method reference; System.out is the specific PrintStream instance

		// Instance reference
		LambdaExamples mainInstance = new LambdaExamples(); // EXAM: mainInstance must be effectively final to be captured by lambdas

		StringOperation intLambda = s -> mainInstance.addExclamation(s); // EXAM: lambda capturing an effectively final variable
		System.out.println(intLambda.process("wow"));

		StringOperation reflambda = mainInstance::addExclamation; // EXAM: instance-on-instance method reference — obj::instanceMethod
		System.out.println(reflambda.process("what"));

		StringTwoParameterCheck paramCheck = mainInstance::startsWith; // EXAM: instance-on-instance ref for a two-param SAM
		System.out.println(paramCheck.check("test", "t"));

		StringOperation construct = String::new; // EXAM: constructor reference (ClassName::new) — calls String(String) constructor
		System.out.println(construct.process("2"));

		// Supplier
		Supplier<LocalDate> s1 = LocalDate::now; // EXAM: Supplier<T> — takes no arguments, returns T; get() is the SAM
		LocalDate d1 = s1.get(); // EXAM: Supplier SAM is get() — no parameters, returns the supplied type
		System.out.println(d1);
		System.out.println(s1);

		// Consumer
		Consumer<String> c1 = System.out::println;                                    // EXAM: Consumer<T> SAM is accept(T); void return
		Consumer<String> c2 = x -> System.out.println(" and then theres -> " + x);   // EXAM: lambda equivalent for Consumer
		Consumer<String> c3 = c1.andThen(c2);                                         // EXAM: Consumer.andThen() chains two consumers; c1 runs first, then c2
		c1.accept("accepted");  // EXAM: invoking the Consumer SAM directly
		c3.accept("Convenience"); // EXAM: andThen chain — prints twice

		var map = new HashMap<String, Integer>();
		BiConsumer<String, Integer> b1 = map::put;                      // EXAM: BiConsumer<T,U> — two params, void return
		BiConsumer<String, Integer> b2 = (x, y) -> map.put(x, y);      // EXAM: two-param lambda requires parentheses around parameters
		b1.accept("a", 123); // EXAM: BiConsumer SAM is accept(T, U)
		b2.accept("b", 321);
		System.out.println(map.toString());

		// Predicate
		Predicate<String> p1 = String::isEmpty;      // EXAM: Predicate<T> SAM is test(T); returns boolean; instance-on-type ref
		Predicate<String> p2 = x -> x.isEmpty();    // EXAM: lambda equivalent

		Predicate<String> isBoth = p1.and(p2); // EXAM: Predicate.and() — default method; short-circuits if first is false
		System.out.println(p1.test(""));
		System.out.println("am i both? " + isBoth.test("am i both?")); // EXAM: also know Predicate.or() and Predicate.negate()

		BiPredicate<String, String> b3 = (x, y) -> x.equals(y); // EXAM: BiPredicate<T,U> SAM is test(T,U); two params require parentheses
		System.out.println(b3.test("", new String()));

		// Function
		Function<String, Integer> f1 = String::length;  // EXAM: Function<T,R> SAM is apply(T); returns R; instance-on-type ref
		Function<String, Integer> f2 = x -> x.length();

		System.out.println(f1.apply("😂")); // EXAM: emoji is 2 chars in UTF-16 (length() returns 2)

		Function<Integer, Integer> before = x -> x + 1;
		Function<Integer, Integer> after = Integer::reverse;
		Function<Integer, Integer> combined = before.andThen(after); // EXAM: Function.andThen(f) — applies 'before' first, pipes result into 'after'
		System.out.println(combined.apply(5));

		BiFunction<String, String, Integer> bf1 = (x, y) -> new String(x + y).length(); // EXAM: BiFunction<T,U,R> SAM is apply(T,U)
		System.out.println(bf1.apply("abc", "123"));

		// Operator
		UnaryOperator<String> o1 = String::toUpperCase; // EXAM: UnaryOperator<T> extends Function<T,T>; input and output same type
		System.out.println(o1.apply("upper-case✅"));

		BinaryOperator<String> bo1 = String::concat; // EXAM: BinaryOperator<T> extends BiFunction<T,T,T>; both inputs and output share the same type
		System.out.println(bo1.apply("first-", "second"));
	}

	// EXAM: static method — eligible for static method reference: LambdaExamples::toUpper (ClassName::staticMethod)
	public static String toUpper(String s) {
		return s.toUpperCase();
	}

	// EXAM: instance method — eligible for instance-on-instance method reference: mainInstance::addExclamation
	public String addExclamation(String s) {
		return s + "!!!";
	}

	// EXAM: two-parameter instance method — when used as mainInstance::startsWith it maps to StringTwoParameterCheck
	public boolean startsWith(String a, String b) {
		return a.startsWith(b);
	}
}
