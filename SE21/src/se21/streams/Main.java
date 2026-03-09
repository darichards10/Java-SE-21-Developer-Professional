package se21.streams;

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
 * Oracle Java SE 21 Developer Professional (1Z0-830)
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
 * - groupingBy() groups into Map&lt;K, List&lt;V&gt;&gt;; accepts downstream Collector
 * - partitioningBy() always returns Map&lt;Boolean, List&lt;V&gt;&gt; with both true and false keys present
 * - Spliterator: trySplit() for parallelism, tryAdvance() for one element, forEachRemaining() for all
 * - Supplier&lt;Stream&lt;T&gt;&gt; pattern: allows reuse of stream pipeline (streams can only be consumed once)
 * - parallelStream() / parallelStream() basics; 3-arg reduce combiner merges partial results
 * - Streams are lazy: intermediate operations do not execute until a terminal operation is invoked
 */
public class Main {

	public static void main(String[] args) {
		System.out.println(average()); // EXAM: returns Optional.empty(); prints "Optional.empty"
		System.out.println(average(10, 20));
		System.out.println(average(25, 25, 50));

		Optional<Double> op = average(50, 75);
		op.ifPresent(System.out::println); // EXAM: ifPresent() — safe way to consume Optional value; no action if empty
		op = average();
		System.out.println(op.orElse(Double.NEGATIVE_INFINITY)); // EXAM: orElse() returns the value or a default if empty

		var nums = List.of(1, 2, 3, 4, 5, 6);
		Stream<Integer> stream = nums.parallelStream(); // EXAM: parallelStream() splits work across threads; order not guaranteed; use for CPU-intensive stateless ops

		Stream<Integer> oddNumunder100 = Stream.iterate(1, n -> n < 100, n -> n + 2); // EXAM: 3-arg iterate (Java 9+): seed, hasNext predicate, next function — bounded stream

		oddNumunder100.forEach(System.out::print); // EXAM: forEach is a terminal operation; consumes the stream
		System.out.println();

		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo"); // EXAM: Stream.of() creates a finite stream from varargs
		Stream<String> infinite = Stream.generate(() -> "chimp"); // EXAM: Stream.generate() creates an infinite stream via Supplier; must be limited

		s.findAny().ifPresent(System.out::println); // monkey (usually) // EXAM: findAny() — terminal; returns Optional; on sequential streams usually first element
		infinite.findAny().ifPresent(System.out::println); // chimp // EXAM: findAny() on infinite stream works because it terminates after finding one element

		var list = List.of("monkey", "2", "chimp");
		Stream<String> infinite2 = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

		System.out.println(list.stream().anyMatch(pred)); // true  // EXAM: anyMatch() — short-circuit terminal; returns true if any element matches
		System.out.println(list.stream().allMatch(pred)); // false // EXAM: allMatch() — short-circuit terminal; returns false at first non-match
		System.out.println(list.stream().noneMatch(pred)); // false // EXAM: noneMatch() — true only if NO elements match; complementary to anyMatch
		System.out.println(infinite2.anyMatch(pred)); // true // EXAM: anyMatch on infinite stream — safe because it short-circuits on first match

		// Reduce
		var array = new String[] { "w", "o", "l", "f" };
		var result = "";
		for (var c : array)
			result = result + c;
		System.out.println(result); // wolf

		Stream<String> streamWolf = Stream.of("w", "o", "l", "f");
//		String word = streamWolf.reduce("", (s2, c) -> s2 + c);
		String word = streamWolf.reduce("", String::concat); // EXAM: 2-arg reduce: identity + BinaryOperator; identity returned if stream is empty
		System.out.println(word); // wolf

		Stream<Integer> streamMult = Stream.of(3, 5, 6);
		Integer multi = streamMult.reduce(1, (x1, x2) -> x1 * x2); // EXAM: identity=1 (neutral for multiplication); result = 3*5*6 = 90
		System.out.println(multi);

		BinaryOperator<Integer> opp = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);

		var streams = List.of(empty, oneElement, threeElements);

		streams.forEach(streamer -> streamer.reduce(opp).ifPresent(System.out::println)); // EXAM: 1-arg reduce returns Optional<T>; empty Optional if stream is empty

		Stream<String> streamCount = Stream.of("w", "o", "l", "f!");
		int length = streamCount.reduce(0, (i, s3) -> i + s3.length(), (a, b) -> a + b); // EXAM: 3-arg reduce: identity, accumulator, combiner; combiner merges partial results in parallel streams
		System.out.println(length); // 5

		// Collect
		StringBuilder wordle = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append); // EXAM: collect() with supplier/accumulator/combiner — manual Collector; combiner for parallel merge

		System.out.println(wordle); // wolf

		Stream<String> streamTree = Stream.of("w", "o", "l", "f");

		TreeSet<String> set = streamTree.collect(TreeSet::new, TreeSet::add, TreeSet::addAll); // EXAM: collect into TreeSet manually; TreeSet::addAll is the combiner for parallel

		System.out.println(set);

		Stream<String> sFilter = Stream.of("monkey", "gorilla", "bonobo");

		sFilter.filter(x -> x.startsWith("m")).forEach(System.out::print); // EXAM: filter() is intermediate (lazy); forEach is terminal that triggers execution

		sFilter = Stream.of("monkey", "gorilla", "bonobo"); // EXAM: streams cannot be reused after terminal op; must create new stream
		sFilter.map(String::length).forEach(System.out::print); // EXAM: map() transforms each element; String::length is a method reference

		List<String> zero = List.of();
		var one = List.of("Bonobo");
		var two = List.of("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);

		animals.flatMap(m -> m.stream()).sorted().forEach(System.out::println); // EXAM: flatMap() flattens Stream<List<T>> into Stream<T>; sorted() requires all elements before emitting

		Stream.generate(() -> "Elsa").filter(n -> n.length() == 4).limit(2).sorted().forEach(System.out::println); // EXAM: limit() makes infinite stream finite; sorted() is stateful — buffers all elements

		// advanced Streaming

		Optional<Integer> dub = Optional.of(2); // EXAM: Optional.of() wraps a non-null value; throws NullPointerException if null passed

		dub.map(d -> d).filter(n -> n > 1).ifPresent(System.out::println); // EXAM: Optional pipeline — map/filter/ifPresent chain; each returns Optional

		Person person = new Person();
		Address add = new Address();
		add.setCity("port st lucie");
		person.setAddress(add);
		Optional.ofNullable(person).map(Person::getAddress).map(Address::getCity).map(String::toUpperCase).stream() // EXAM: ofNullable() handles null safely; each map() short-circuits if Optional is empty; .stream() converts Optional to Stream<T>
				.forEach(System.out::println);

		Supplier<Stream<String>> streamSupplier = () -> Stream.of("lions", "tigers", "bears", "dogs", "cats"); // EXAM: Supplier<Stream<T>> pattern — call .get() each time to obtain a fresh stream; solves "stream already consumed" problem
		Supplier<Spliterator<String>> spliteratorSupplier = () -> streamSupplier.get().spliterator();

		String result3 = streamSupplier.get().collect(Collectors.joining(", ")); // EXAM: Collectors.joining() concatenates String elements with delimiter; overloads add prefix/suffix
		System.out.println(result3); // lions, tigers, bears

		TreeSet<String> result4 = streamSupplier.get().filter(t -> t.startsWith("l"))
				.collect(Collectors.toCollection(TreeSet::new)); // EXAM: toCollection() with constructor ref — collect into a specific Collection type

		List<String> mutableList = streamSupplier.get().collect(Collectors.toList()); // EXAM: Collectors.toList() — returns a mutable List (implementation unspecified)
		List<String> immutableList = streamSupplier.get().toList(); // EXAM: Stream.toList() (Java 16+) — returns an unmodifiable List; mutation throws UnsupportedOperationException

		Map<String, Integer> mappedStream = streamSupplier.get().collect(Collectors.toMap(str -> str, String::length)); // EXAM: toMap(keyMapper, valueMapper); throws IllegalStateException on duplicate keys
		Map<Integer, String> map = streamSupplier.get()
				.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2)); // EXAM: toMap with merge function — resolves duplicate keys; (s1, s2) -> s1 keeps first, here concatenates
		Map<Integer, List<String>> mapOfList = streamSupplier.get().collect(Collectors.groupingBy(String::length)); // EXAM: groupingBy() groups elements into Map<K, List<V>> by classifier function
		Map<Integer, Set<String>> mapOfSet = streamSupplier.get()
				.collect(Collectors.groupingBy(String::length, Collectors.toSet())); // EXAM: groupingBy() with downstream Collector — collect grouped values into Set instead of List
		TreeMap<Integer, Set<String>> mapOfTreeSet = streamSupplier.get()
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet())); // EXAM: groupingBy() with map factory — controls the Map implementation (TreeMap = sorted keys)

		Map<Boolean, List<String>> partitionMap = streamSupplier.get()
				.collect(Collectors.partitioningBy(xy -> xy.length() < 7)); // EXAM: partitioningBy() always returns Map<Boolean, List<V>> with both true and false keys; specialized groupingBy

		Map<Boolean, Set<String>> partitionSet = streamSupplier.get()
				.collect(Collectors.partitioningBy(xy1 -> xy1.length() < 3, Collectors.toSet())); // EXAM: partitioningBy() with downstream Collector; collects partitions into Sets

		Map<Integer, Optional<Character>> mapMap = streamSupplier.get().collect(Collectors.groupingBy(String::length,
				Collectors.mapping(chr -> chr.charAt(0), Collectors.minBy((a, b) -> a - b)))); // EXAM: mapping() transforms elements before applying downstream Collector; minBy() returns Optional<T>

		List<Map<?, ?>> maps = List.of(mappedStream, map, mapOfList, mapOfSet, mapOfTreeSet, partitionMap, partitionSet,
				mapMap);
		maps.forEach(System.out::println);

		Spliterator<String> original = spliteratorSupplier.get();
		Spliterator<String> extra = original.trySplit(); // EXAM: trySplit() splits off a portion for parallel processing; returns null if cannot split
		extra.forEachRemaining(System.out::println); // EXAM: forEachRemaining() processes all remaining elements in this Spliterator
		System.out.println("-----------");
		Spliterator<String> nextExtra = original.trySplit();
		nextExtra.tryAdvance(System.out::println); // EXAM: tryAdvance() processes exactly one element; returns false if no elements remain
		System.out.println("-----------");

		nextExtra.forEachRemaining(System.out::println);
		original.forEachRemaining(System.out::println);

		var originalBag = Stream.iterate(1, n -> ++n).spliterator(); // EXAM: spliterator() on a stream; Stream.iterate() produces infinite sequence

		Spliterator<Integer> newBag = originalBag.trySplit(); // EXAM: trySplit() on infinite spliterator; JVM decides how many elements to split off

		newBag.tryAdvance(System.out::print); // 1 // EXAM: tryAdvance() — one element at a time; Consumer receives the element
		newBag.tryAdvance(System.out::print); // 2
		newBag.tryAdvance(System.out::print); // 3

		var streamer = Stream.generate(() -> "generated");
		streamer.anyMatch(String::isEmpty); // EXAM: anyMatch on infinite stream of non-empty strings loops forever — illustrates importance of short-circuit; this call never returns

	}

	public static Optional<Double> average(int... scores) { // EXAM: returning Optional<T> instead of null is the preferred modern pattern; caller must handle empty case
		if (scores.length == 0)
			return Optional.empty(); // EXAM: Optional.empty() — represents absence of a value; preferred over returning null
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length); // EXAM: Optional.of() wraps a non-null result; use ofNullable() if result could be null
	}

}
