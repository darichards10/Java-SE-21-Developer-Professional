package se21.functional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * EXAM TOPIC: Streams API
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Covers:
 * - Stream creation: Stream.of(), Stream.generate(), Stream.iterate(), list.stream(), parallelStream()
 * - Stream.iterate() with predicate (3-arg): bounded infinite stream (Java 9+)
 * - Optional: of(), empty(), ofNullable(), ifPresent(), orElse(), map(), filter(), stream()
 * - Terminal operations: findAny(), anyMatch(), allMatch(), noneMatch(), reduce(), collect(), forEach(), count()
 * - Intermediate operations: filter(), map(), flatMap(), sorted(), limit(), distinct() — lazy, not executed until terminal
 * - reduce(): identity + BinaryOperator (2-arg), BinaryOperator only returns Optional (1-arg), 3-arg for parallel
 * - collect() with Collector: toList(), toSet(), toCollection(), joining(), toMap(), groupingBy(), partitioningBy(), mapping(), minBy()
 * - Collectors.toList() returns mutable list; stream.toList() returns immutable list (Java 16+)
 * - Collectors.toMap() with merge function handles duplicate keys
 * - groupingBy() groups into Map<K, List<V>>; accepts downstream Collector
 * - partitioningBy() always returns Map<Boolean, List<V>> with both true and false keys present
 * - Spliterator: trySplit() for parallelism, tryAdvance() for one element, forEachRemaining() for all
 * - Supplier<Stream<T>> pattern: allows reuse of stream pipeline (streams can only be consumed once)
 * - parallelStream() basics; 3-arg reduce combiner merges partial results
 * - Streams are lazy: intermediate operations do not execute until a terminal operation is invoked
 */
public class StreamsExamples {

	public static void main(String[] args) {
		System.out.println(average()); // Optional.empty
		System.out.println(average(10, 20));
		System.out.println(average(25, 25, 50));

		Optional<Double> op = average(50, 75);
		op.ifPresent(System.out::println); // EXAM: ifPresent() — safe way to consume Optional value; no action if empty
		op = average();
		System.out.println(op.orElse(Double.NEGATIVE_INFINITY)); // EXAM: orElse() returns the value or a default if empty

		var nums = List.of(1, 2, 3, 4, 5, 6);
		Stream<Integer> stream = nums.parallelStream(); // EXAM: parallelStream() splits work across threads; order not guaranteed

		Stream<Integer> oddNumunder100 = Stream.iterate(1, n -> n < 100, n -> n + 2); // EXAM: 3-arg iterate (Java 9+): seed, hasNext predicate, next function
		oddNumunder100.forEach(System.out::print); // EXAM: forEach is a terminal operation; consumes the stream
		System.out.println();

		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo"); // EXAM: Stream.of() creates a finite stream from varargs
		Stream<String> infinite = Stream.generate(() -> "chimp"); // EXAM: Stream.generate() creates an infinite stream via Supplier; must be limited

		s.findAny().ifPresent(System.out::println); // EXAM: findAny() — terminal; returns Optional; on sequential streams usually first element
		infinite.findAny().ifPresent(System.out::println); // EXAM: works on infinite stream because it terminates after finding one element

		var list = List.of("monkey", "2", "chimp");
		Stream<String> infinite2 = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

		System.out.println(list.stream().anyMatch(pred)); // true  // EXAM: anyMatch() — short-circuit terminal
		System.out.println(list.stream().allMatch(pred)); // false // EXAM: allMatch() — returns false at first non-match
		System.out.println(list.stream().noneMatch(pred)); // false // EXAM: noneMatch() — true only if NO elements match
		System.out.println(infinite2.anyMatch(pred)); // true // EXAM: anyMatch on infinite stream — safe because it short-circuits

		// Reduce
		Stream<String> streamWolf = Stream.of("w", "o", "l", "f");
		String word = streamWolf.reduce("", String::concat); // EXAM: 2-arg reduce: identity + BinaryOperator; identity returned if stream empty
		System.out.println(word); // wolf

		Stream<Integer> streamMult = Stream.of(3, 5, 6);
		Integer multi = streamMult.reduce(1, (x1, x2) -> x1 * x2); // EXAM: identity=1 (neutral for multiplication); 3*5*6=90
		System.out.println(multi);

		BinaryOperator<Integer> opp = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);
		var streams = List.of(empty, oneElement, threeElements);
		streams.forEach(streamer -> streamer.reduce(opp).ifPresent(System.out::println)); // EXAM: 1-arg reduce returns Optional<T>; empty Optional if stream empty

		// Collect
		Stream<String> streamTree = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = streamTree.collect(TreeSet::new, TreeSet::add, TreeSet::addAll); // EXAM: collect into TreeSet manually

		Stream<String> sFilter = Stream.of("monkey", "gorilla", "bonobo");
		sFilter.filter(x -> x.startsWith("m")).forEach(System.out::print); // EXAM: filter() is intermediate (lazy); forEach is terminal

		sFilter = Stream.of("monkey", "gorilla", "bonobo"); // EXAM: streams cannot be reused after terminal op; must create new stream
		sFilter.map(String::length).forEach(System.out::print); // EXAM: map() transforms each element

		List<String> zero = List.of();
		var one = List.of("Bonobo");
		var two = List.of("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(m -> m.stream()).sorted().forEach(System.out::println); // EXAM: flatMap() flattens Stream<List<T>> into Stream<T>

		Stream.generate(() -> "Elsa").filter(n -> n.length() == 4).limit(2).sorted().forEach(System.out::println); // EXAM: limit() makes infinite stream finite; sorted() buffers all elements

		// Optional pipeline
		Optional<Integer> dub = Optional.of(2); // EXAM: Optional.of() wraps a non-null value; throws NullPointerException if null
		dub.map(d -> d).filter(n -> n > 1).ifPresent(System.out::println);

		Person person = new Person();
		Address add = new Address();
		add.setCity("port st lucie");
		person.setAddress(add);
		Optional.ofNullable(person).map(Person::getAddress).map(Address::getCity).map(String::toUpperCase).stream()
				.forEach(System.out::println); // EXAM: ofNullable() handles null safely; each map() short-circuits if Optional empty

		Supplier<Stream<String>> streamSupplier = () -> Stream.of("lions", "tigers", "bears", "dogs", "cats"); // EXAM: Supplier<Stream<T>> pattern — call .get() for fresh stream

		String result3 = streamSupplier.get().collect(Collectors.joining(", ")); // EXAM: Collectors.joining() concatenates with delimiter
		System.out.println(result3);

		TreeSet<String> result4 = streamSupplier.get().filter(t -> t.startsWith("l"))
				.collect(Collectors.toCollection(TreeSet::new)); // EXAM: toCollection() with constructor ref

		List<String> mutableList = streamSupplier.get().collect(Collectors.toList()); // EXAM: Collectors.toList() — returns a mutable List
		List<String> immutableList = streamSupplier.get().toList(); // EXAM: Stream.toList() (Java 16+) — returns an unmodifiable List

		Map<String, Integer> mappedStream = streamSupplier.get().collect(Collectors.toMap(str -> str, String::length)); // EXAM: toMap(keyMapper, valueMapper); throws IllegalStateException on duplicate keys
		Map<Integer, String> map = streamSupplier.get()
				.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2)); // EXAM: toMap with merge function — resolves duplicate keys
		Map<Integer, List<String>> mapOfList = streamSupplier.get().collect(Collectors.groupingBy(String::length)); // EXAM: groupingBy() groups elements into Map<K, List<V>>
		Map<Integer, Set<String>> mapOfSet = streamSupplier.get()
				.collect(Collectors.groupingBy(String::length, Collectors.toSet())); // EXAM: groupingBy() with downstream Collector
		TreeMap<Integer, Set<String>> mapOfTreeSet = streamSupplier.get()
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet())); // EXAM: groupingBy() with map factory

		Map<Boolean, List<String>> partitionMap = streamSupplier.get()
				.collect(Collectors.partitioningBy(xy -> xy.length() < 7)); // EXAM: partitioningBy() always returns Map<Boolean, List<V>> with both true and false keys

		Map<Boolean, Set<String>> partitionSet = streamSupplier.get()
				.collect(Collectors.partitioningBy(xy1 -> xy1.length() < 3, Collectors.toSet())); // EXAM: partitioningBy() with downstream Collector

		Map<Integer, Optional<Character>> mapMap = streamSupplier.get().collect(Collectors.groupingBy(String::length,
				Collectors.mapping(chr -> chr.charAt(0), Collectors.minBy((a, b) -> a - b)))); // EXAM: mapping() transforms before downstream; minBy() returns Optional<T>

		// Spliterator
		Supplier<Spliterator<String>> spliteratorSupplier = () -> streamSupplier.get().spliterator();
		Spliterator<String> original = spliteratorSupplier.get();
		Spliterator<String> extra = original.trySplit(); // EXAM: trySplit() splits off a portion for parallel processing
		extra.forEachRemaining(System.out::println); // EXAM: forEachRemaining() processes all remaining elements
		System.out.println("-----------");
		Spliterator<String> nextExtra = original.trySplit();
		nextExtra.tryAdvance(System.out::println); // EXAM: tryAdvance() processes exactly one element; returns false if none remain
		System.out.println("-----------");
		nextExtra.forEachRemaining(System.out::println);
		original.forEachRemaining(System.out::println);
	}

	public static Optional<Double> average(int... scores) { // EXAM: returning Optional<T> instead of null is the preferred modern pattern
		if (scores.length == 0) {
			return Optional.empty(); // EXAM: Optional.empty() — represents absence of a value
		}
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		return Optional.of((double) sum / scores.length); // EXAM: Optional.of() wraps a non-null result; use ofNullable() if result could be null
	}
}
