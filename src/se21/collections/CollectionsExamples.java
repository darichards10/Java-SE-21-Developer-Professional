package se21.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * EXAM TOPIC: Working with Arrays and Collections
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~12% of exam
 *
 * Covers:
 * - List: ArrayList (mutable), List.of() (immutable/fixed-size), add/remove/get
 * - Set: HashSet (no order), LinkedHashSet (insertion order), TreeSet (sorted natural order)
 * - Set.of() produces an immutable set; element order is not guaranteed
 * - Map: HashMap, LinkedHashMap, TreeMap, Map.of() (immutable), merge(), putIfAbsent(), getOrDefault()
 * - Queue: FIFO via LinkedList; offer/poll/peek (no exceptions) vs add/remove/element (throw)
 * - Deque: double-ended queue; push/pop (stack), offer/poll from both ends
 * - Comparator: naturalOrder(), reverseOrder(), comparing(), thenComparing() for multi-field sort
 * - Comparable vs Comparator: Comparable = natural order; Comparator = external/custom order
 * - Collections utility: sort(), min(), max(), frequency(), unmodifiableList/Set/Map
 * - List equality is order-sensitive; Set equality is order-insensitive
 * - SequencedCollection / SequencedMap: Java 21 additions with defined encounter order
 */
public class CollectionsExamples {
	List<String> list = new ArrayList<String>(); // EXAM: instance field using mutable ArrayList; contrast with List.of()

	public static void main(String[] args) {
		// List
		Collection<String> list = new ArrayList<String>(); // EXAM: program to Collection interface; ArrayList allows nulls and duplicates
		list.add("first");

		Predicate<String> pred = String::isEmpty;
		list.removeIf(i -> i.isEmpty()); // EXAM: removeIf() takes a Predicate; available on all Collection types
		list.removeIf(pred); // EXAM: method reference as Predicate — same behavior as lambda above

		// Set
		Collection<String> set = new HashSet<>(); // EXAM: HashSet — no guaranteed order, O(1) add/contains
		set.add("first");
		set.add("second");
		set.isEmpty();
		set.forEach(System.out::println); // EXAM: forEach with method reference; available on Iterable

		// Equality
		var list1 = List.of(1, 2); // EXAM: List.of() is immutable; throws UnsupportedOperationException on mutation
		var list2 = List.of(2, 1);
		var set1 = Set.of(1, 2); // EXAM: Set.of() is immutable and unordered; no null elements allowed
		var set2 = Set.of(2, 1);

		System.out.println(list1.equals(list2)); // false // EXAM: List equality is order-sensitive
		System.out.println(set1.equals(set2)); // true  // EXAM: Set equality is order-insensitive (same elements = equal)
		System.out.println(list1.equals(set1)); // false // EXAM: List and Set are never equal even with same elements

		var heights = new ArrayList<Integer>();
		heights.add(null); // EXAM: ArrayList allows null; unboxing null to int throws NullPointerException
//		int h = heights.get(0);  // EXAM: unboxing null causes NullPointerException — common exam trap

		List<String> strList = List.of("k", "y", "l", "o");
		StringBuilder result = strList.stream().collect(StringBuilder::new, // EXAM: constructor ref as Supplier
				StringBuilder::append, // EXAM: instance method ref as BiConsumer (accumulator)
				StringBuilder::append); // EXAM: combiner — used in parallel streams to merge partial results
		System.out.println(result);

		Set<Integer> treeSet = new TreeSet<>(); // EXAM: TreeSet maintains natural (sorted) order; elements must be Comparable or Comparator supplied
		treeSet.add(2);
		treeSet.add(5);
		treeSet.add(4);
		treeSet.add(8);
		System.out.println(treeSet); // prints [2, 4, 5, 8]

		Set<Integer> linkedSet = new LinkedHashSet<>(); // EXAM: LinkedHashSet preserves insertion order; no duplicates
		linkedSet.add(2);
		linkedSet.add(5);
		linkedSet.add(4);
		linkedSet.add(3);
		System.out.println(linkedSet); // prints [2, 5, 4, 3]

		// Queue/Stack
		Queue<Integer> q = new LinkedList<>(); // EXAM: LinkedList implements both Queue and Deque; FIFO by default
		q.addAll(List.of(1, 2, 4, 3, 5, 8, 0));
		System.out.println(q);

		Deque<Integer> dq = new LinkedList<>(); // EXAM: Deque allows add/remove from both ends; can be used as stack or queue
		dq.addAll(List.of(1, 2, 4, 3, 5, 8, 0));
		System.out.println(dq);

		// Map
		Map<String, String> map1 = Map.of("key", "value"); // EXAM: Map.of() is immutable; no null keys/values; unordered
		LinkedHashMap<String, String> map2 = new LinkedHashMap<>(); // EXAM: preserves insertion order
		HashMap<String, String> map3 = new HashMap<>(); // EXAM: no guaranteed order; fastest for get/put
		TreeMap<String, String> map4 = new TreeMap<>(); // EXAM: sorted by key natural order; NavigableMap

		List<Map> maps = List.of(map1, map2, map3, map4);

		BiFunction<String, String, String> merger = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

		map2.merge("key2", "value2", merger); // EXAM: merge() — if key absent, puts value; if present, applies BiFunction to old+new values
		map2.merge("key2", "value3", merger); // EXAM: second merge call applies BiFunction: "value2".length > "value3".length? keeps "value2"

		maps.forEach(System.out::println);

		Dog kylo = new Dog("german shepard", 1);
		Dog lebron = new Dog("border collie", 3);

		var dogs = new ArrayList<Dog>();
		dogs.add(kylo);
		dogs.add(lebron);

		System.out.println(dogs);
		Collections.sort(dogs); // EXAM: Collections.sort() requires elements to implement Comparable; uses natural order from compareTo()
		System.out.println(dogs);

		Comparator<Dog> byAge = new Comparator<>() { // EXAM: anonymous class implementing Comparator — functional interface
			public int compare(Dog d1, Dog d2) {
				return d1.age() - d2.age(); // EXAM: subtraction trick for int comparison; beware overflow with large negative values
			}
		};

		Comparator<Dog> byAgeByMR = (d1, d2) -> d1.age() - d2.age(); // EXAM: lambda as Comparator — more concise than anonymous class
		Collections.sort(dogs, byAgeByMR); // EXAM: Collections.sort() with explicit Comparator overrides natural ordering
		System.out.println(dogs);

		Comparator<Dog> byMultiFields = Comparator.comparing(Dog::breed).thenComparingLong(Dog::age); // EXAM: Comparator chaining with thenComparing() for multi-field sort

		Collections.sort(dogs, byMultiFields);

		Set<Dog> orderedDogs = new TreeSet<>((d1, d2) -> d1.age() - d2.age()); // EXAM: TreeSet with Comparator; overrides natural order from Comparable
		orderedDogs.add(kylo);
		orderedDogs.add(lebron);

		// Sequenced Collections — Java 21 addition
		SequencedCollection<Dog> seqDogs = new ArrayList<>(); // EXAM: SequencedCollection (Java 21) guarantees defined encounter order; adds getFirst/getLast/reversed
		seqDogs.add(kylo);
		seqDogs.add(lebron);

		SequencedMap<String, Dog> dogMap = new TreeMap<String, Dog>(); // EXAM: SequencedMap (Java 21); TreeMap implements it; supports pollFirstEntry/pollLastEntry
		dogMap.put("kylo", kylo);

		dogMap.pollFirstEntry(); // EXAM: pollFirstEntry() retrieves and removes the first (lowest key) entry
		dogMap.pollFirstEntry();

		Collection<String> collUnmod = Collections.unmodifiableCollection(List.of("brown")); // EXAM: unmodifiable view — mutation throws UnsupportedOperationException
		List<String> listUnmod = Collections.unmodifiableList(List.of("orange")); // EXAM: unmodifiableList wraps an existing list; differs from List.of() which is directly immutable
		Set<String> setUnmod = Collections.unmodifiableSet(Set.of("green")); // EXAM: unmodifiable wrapper around a set
		Map<String, Integer> mapUnmod = Collections.unmodifiableMap(Map.of("red", 1)); // EXAM: unmodifiable wrapper around a map
	}
}
