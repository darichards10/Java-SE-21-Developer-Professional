package se21.lambda;

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
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - All built-in functional interfaces: Predicate, BiPredicate, Consumer, BiConsumer,
 *   Supplier, Function, BiFunction, UnaryOperator, BinaryOperator
 * - Lambda syntax variations: no-brace single expression, explicit return with braces, typed/untyped params
 * - Four method reference types:
 *     1. Static:               ClassName::staticMethod   (e.g., Main::toUpper, Integer::compare)
 *     2. Instance on instance: obj::instanceMethod       (e.g., mainInstance::addExclamation, System.out::println)
 *     3. Instance on type:     ClassName::instanceMethod (e.g., String::isEmpty, String::length)
 *     4. Constructor:          ClassName::new            (e.g., String::new)
 * - Chaining default methods: Predicate.and(), or(), negate(); Function.andThen(), compose()
 * - Consumer chaining with andThen()
 * - Variable capture: lambdas may reference effectively final local variables only
 */
public class Main {

	public static void main(String[] args) {
		var animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));

		Animal.printAnimals(animals, a -> a.canHop()); // EXAM: lambda with single param (no parens needed), no-brace body; a.canHop() is an instance method on the parameter

		Duckling.makeSound("gyyang");

		List<Integer> nums = Arrays.asList(5, 2, 3, 4, 1, 6);

		nums.stream().sorted(Integer::compare).forEach(System.out::println); // EXAM: static method ref (Integer::compare) and instance-on-instance ref (System.out::println) chained on a stream

		// References to static methods
		StringOperation lambda = s -> Main.toUpper(s); // EXAM: lambda wrapping a static method call — equivalent to the method reference below
		System.out.println(lambda.process("hello"));

		StringOperation ref = Main::toUpper; // EXAM: static method reference (ClassName::staticMethod) — preferred concise form over the lambda above
		System.out.println(ref.process("world"));

		List<String> names = List.of("kylo", "thomas");
		names.forEach(System.out::println); // EXAM: instance-on-instance method reference; System.out is the specific PrintStream instance

		// Instance reference
		Main mainInstance = new Main(); // EXAM: mainInstance must be effectively final (or final) to be captured by the lambdas below

		StringOperation intLambda = s -> mainInstance.addExclamation(s); // EXAM: lambda capturing an effectively final variable (mainInstance); reassigning mainInstance would cause compile error
		System.out.println(intLambda.process("wow"));

		StringOperation reflambda = mainInstance::addExclamation; // EXAM: instance-on-instance method reference — obj::instanceMethod; equivalent to the lambda above
		System.out.println(reflambda.process("what"));

		StringTwoParameterCheck paramCheck = mainInstance::startsWith; // EXAM: instance-on-instance ref for a two-param SAM — mainInstance is bound, (a,b)->mainInstance.startsWith(a,b)
		System.out.println(paramCheck.check("test", "t"));

		StringOperation construct = String::new; // EXAM: constructor reference (ClassName::new) — calls String(String) constructor; return type is String, matching the SAM
		System.out.println(construct.process("2"));

		// Supplier
		Supplier<LocalDate> s1 = LocalDate::now; // EXAM: Supplier<T> — takes no arguments, returns T; get() is the SAM; static method ref used as a no-arg factory

		LocalDate d1 = s1.get(); // EXAM: Supplier SAM is get() — no parameters, returns the supplied type

		System.out.println(d1);
		System.out.println(s1);

		// Consumer
		Consumer<String> c1 = System.out::println;                                   // EXAM: Consumer<T> SAM is accept(T); void return; instance-on-instance method ref
		Consumer<String> c2 = x -> System.out.println(" and then theres -> " + x);  // EXAM: lambda equivalent for Consumer — single param, void body
		Consumer<String> c3 = c1.andThen(c2);                                        // EXAM: Consumer.andThen() chains two consumers — c1 runs first, then c2; default method on Consumer

		c1.accept("accepted"); // EXAM: invoking the Consumer SAM directly

		c3.accept("Convenience"); // EXAM: andThen chain — prints twice; order is c1 then c2

		var map = new HashMap<String, Integer>();
		BiConsumer<String, Integer> b1 = map::put;                      // EXAM: BiConsumer<T,U> — two params, void return; instance-on-instance ref (map is bound instance)
		BiConsumer<String, Integer> b2 = (x, y) -> map.put(x, y);      // EXAM: two-param lambda requires parentheses around parameters

		System.out.println(map.toString());
		b1.accept("a", 123); // EXAM: BiConsumer SAM is accept(T, U)
		b2.accept("b", 321);
		System.out.println(map.toString());

		// Predicate
		Predicate<String> p1 = String::isEmpty;      // EXAM: Predicate<T> SAM is test(T); returns boolean; instance-on-type ref — the single param becomes the instance
		Predicate<String> p2 = x -> x.isEmpty();    // EXAM: lambda equivalent; both p1 and p2 are interchangeable

		Predicate<String> isBoth = p1.and(p2); // EXAM: Predicate.and() — default method returning a composed Predicate; short-circuits if first is false

		System.out.println(p1.test("")); // EXAM: Predicate SAM is test(T) — returns boolean

		System.out.println("ami i both? " + isBoth.test("am i both?")); // EXAM: composed predicate; also know Predicate.or() and Predicate.negate()

		BiPredicate<String, String> b3 = (x, y) -> x.equals(y); // EXAM: BiPredicate<T,U> SAM is test(T,U); two params require parentheses

		System.out.println(b3.test("", new String())); // EXAM: new String() creates an empty string equal to "" — tests BiPredicate invocation

		// Function
		Function<String, Integer> f1 = String::length;  // EXAM: Function<T,R> SAM is apply(T); returns R; instance-on-type ref — the param becomes the instance; R differs from T
		Function<String, Integer> f2 = x -> x.length(); // EXAM: lambda equivalent for Function

		System.out.println(f1.apply("😂")); // EXAM: Function SAM is apply(T) — emoji is 2 chars in UTF-16 (length() returns 2)

		Function<Integer, Integer> before = x -> x + 1;
		Function<Integer, Integer> after = Integer::reverse; // EXAM: static method reference used as Function<Integer,Integer>

		Function<Integer, Integer> combined = before.andThen(after); // EXAM: Function.andThen(f) — applies 'before' first, pipes result into 'after'; compose() does the reverse order

		System.out.println(combined.apply(5));

		BiFunction<String, String, Integer> bf1 = (x, y) -> new String(x + y).length(); // EXAM: BiFunction<T,U,R> SAM is apply(T,U); two inputs, one output of a different type

		System.out.println(bf1.apply("abc", "123"));

		// Operator
		UnaryOperator<String> o1 = String::toUpperCase; // EXAM: UnaryOperator<T> extends Function<T,T> — input and output are the same type; SAM is apply(T)

		System.out.println(o1.apply("upper-case✅"));

		BinaryOperator<String> bo1 = String::concat; // EXAM: BinaryOperator<T> extends BiFunction<T,T,T> — both inputs and output share the same type; instance-on-type ref

		System.out.println(bo1.apply("first-", "second"));

	}

	// EXAM: static method — eligible for static method reference: Main::toUpper (ClassName::staticMethod)
	public static String toUpper(String s) {
		return s.toUpperCase();
	}

	// EXAM: instance method — eligible for instance-on-instance method reference: mainInstance::addExclamation (obj::instanceMethod)
	public String addExclamation(String s) {
		return s + "!!!";
	}

	// EXAM: two-parameter instance method — when used as mainInstance::startsWith it maps to StringTwoParameterCheck (two-param SAM); mainInstance is bound
	public boolean startsWith(String a, String b) {
		return a.startsWith(b);
	}
}
