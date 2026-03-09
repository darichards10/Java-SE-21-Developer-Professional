package se21.functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * SELF-TEST: Working with Streams and Lambda Expressions
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is the output?
	//   Predicate<String> p = s -> s.length() > 3;
	//   System.out.println(p.test("hi"));
	// a) true   b) false   c) compile error   d) runtime exception
	// ANSWER: ___

	// Q2: Which functional interface takes two parameters and returns void?
	// a) BiFunction<T,U,R>   b) BiConsumer<T,U>   c) BiPredicate<T,U>   d) BinaryOperator<T>
	// ANSWER: ___

	// Q3: What is the output?
	//   Stream.of("a","b","c").filter(s -> s.equals("b")).count();
	//   // No terminal operation that prints — what happens?
	// a) 1   b) nothing (no println)   c) compile error   d) runtime exception
	// ANSWER: ___

	// Q4: What is the output?
	//   Stream.of(1,2,3).reduce(0, Integer::sum)
	//   System.out.println(result);
	// a) Optional[6]   b) 6   c) 0   d) compile error
	// ANSWER: ___

	// Q5: Which method flattens a Stream<List<String>> into a Stream<String>?
	// a) map()   b) filter()   c) flatMap()   d) reduce()
	// ANSWER: ___

	// Q6: What is printed?
	//   var result = Stream.of("a","b","c").collect(Collectors.joining(", "));
	//   System.out.println(result);
	// a) "a b c"   b) "a, b, c"   c) "[a, b, c]"   d) compile error
	// ANSWER: ___

	// Q7: What is the difference between Collectors.toList() and Stream.toList()?
	// a) No difference   b) toList() (Java 16) returns immutable list; Collectors.toList() returns mutable
	// c) Collectors.toList() is faster   d) Stream.toList() was removed in Java 17
	// ANSWER: ___

	// Q8: partitioningBy() always returns Map<Boolean, List<V>> — is this true?
	// a) False — it can return any Map type
	// b) True — always Boolean keys with both true and false entries present
	// c) True — but only if elements match the predicate
	// d) False — it returns Map<Object, List<V>>
	// ANSWER: ___

	// Q9: What is the result of Interface Sprint with methods: sprint(int), equals(Object), hashCode()?
	// a) Compile error — 3 abstract methods   b) Valid @FunctionalInterface (only sprint is SAM)
	// c) Valid but cannot use @FunctionalInterface   d) Depends on Java version
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1: false — "hi".length() = 2, not > 3
		Predicate<String> p = s -> s.length() > 3;
		System.out.println("Q1: " + p.test("hi")); // false

		// Q2: b) BiConsumer<T,U> — takes two params, returns void; SAM is accept(T, U)
		System.out.println("Q2: b) BiConsumer<T,U>");

		// Q3: The stream pipeline runs lazily; count() is a terminal op that triggers execution
		//     but there's no println, so nothing is printed
		long count = Stream.of("a","b","c").filter(s -> s.equals("b")).count();
		// count=1 but without println nothing prints; stored in 'count'
		System.out.println("Q3: count=" + count + " (no output if no println)");

		// Q4: b) 6 — 2-arg reduce with identity returns T, not Optional<T>
		int result = Stream.of(1, 2, 3).reduce(0, Integer::sum);
		System.out.println("Q4: " + result); // 6

		// Q5: c) flatMap()
		System.out.println("Q5: c) flatMap()");

		// Q6: b) "a, b, c"
		var joined = Stream.of("a","b","c").collect(Collectors.joining(", "));
		System.out.println("Q6: " + joined); // a, b, c

		// Q7: b) Stream.toList() (Java 16+) returns unmodifiable list
		System.out.println("Q7: b) Stream.toList() returns unmodifiable; Collectors.toList() returns mutable");

		// Q8: b) partitioningBy always has both true and false keys, even if one is empty
		Map<Boolean, List<Integer>> partition = Stream.of(1,2,3,4,5)
				.collect(Collectors.partitioningBy(n -> n > 10));
		System.out.println("Q8: both keys present: " + partition.containsKey(true) + " and " + partition.containsKey(false)); // true true

		// Q9: b) equals(Object) and hashCode() are Object method declarations; don't count as SAM
		System.out.println("Q9: b) Valid @FunctionalInterface — Object method redeclarations excluded from SAM count");
	}
}
