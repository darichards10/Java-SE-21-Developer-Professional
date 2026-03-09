package se21.collections;

import java.util.*;

/**
 * SELF-TEST: Working with Arrays and Collections
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~12% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is printed?
	//   var list1 = List.of(1, 2, 3);
	//   var list2 = List.of(3, 2, 1);
	//   System.out.println(list1.equals(list2));
	// a) true   b) false   c) compile error   d) runtime exception
	// ANSWER: ___

	// Q2: What happens when you call list.add("x") on a List.of() list?
	// a) UnsupportedOperationException   b) IllegalStateException
	// c) The element is added            d) compile error
	// ANSWER: ___

	// Q3: Which collection guarantees insertion order?
	// a) HashSet   b) TreeSet   c) LinkedHashSet   d) HashMap
	// ANSWER: ___

	// Q4: What is the output?
	//   var set1 = Set.of(1, 2, 3);
	//   var set2 = Set.of(3, 1, 2);
	//   System.out.println(set1.equals(set2));
	// a) true   b) false   c) compile error   d) depends on JVM
	// ANSWER: ___

	// Q5: What is the difference between poll() and remove() on a Queue?
	// a) No difference   b) poll() returns null if empty; remove() throws NoSuchElementException
	// c) remove() returns null if empty; poll() throws exception
	// d) poll() removes from head; remove() from tail
	// ANSWER: ___

	// Q6: What is printed?
	//   ArrayList<Integer> list = new ArrayList<>();
	//   list.add(null);
	//   System.out.println(list.get(0) + 1);
	// a) 1   b) null   c) NullPointerException   d) compile error
	// ANSWER: ___

	// Q7: What is the output of TreeSet<Integer> set = new TreeSet<>(Set.of(5,3,1,4,2)); System.out.println(set);?
	// a) [5, 3, 1, 4, 2]   b) [1, 2, 3, 4, 5]   c) order undefined   d) compile error
	// ANSWER: ___

	// Q8: What does Collections.unmodifiableList() return?
	// a) A new empty list   b) A view that throws on mutation; backed by the original list
	// c) A deep copy of the list   d) A sorted view of the list
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1: false — List equality is order-sensitive
		var list1 = List.of(1, 2, 3);
		var list2 = List.of(3, 2, 1);
		System.out.println("Q1: " + list1.equals(list2)); // false

		// Q2: UnsupportedOperationException
		try {
			List.of("a").add("b");
		} catch (UnsupportedOperationException e) {
			System.out.println("Q2: UnsupportedOperationException");
		}

		// Q3: c) LinkedHashSet — preserves insertion order
		System.out.println("Q3: c) LinkedHashSet");

		// Q4: true — Set equality is order-insensitive (same elements = equal)
		var set1 = Set.of(1, 2, 3);
		var set2 = Set.of(3, 1, 2);
		System.out.println("Q4: " + set1.equals(set2)); // true

		// Q5: b) poll() returns null; remove() throws NoSuchElementException if empty
		Queue<Integer> q = new LinkedList<>();
		System.out.println("Q5: poll on empty = " + q.poll()); // null
		try { q.remove(); } catch (NoSuchElementException e) { System.out.println("Q5: remove throws NoSuchElementException"); }

		// Q6: NullPointerException — unboxing null Integer to int fails
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(null);
		try {
			System.out.println(list3.get(0) + 1); // unboxing null → NullPointerException
		} catch (NullPointerException e) {
			System.out.println("Q6: NullPointerException (unboxing null)");
		}

		// Q7: [1, 2, 3, 4, 5] — TreeSet maintains natural sorted order
		TreeSet<Integer> set = new TreeSet<>(Set.of(5, 3, 1, 4, 2));
		System.out.println("Q7: " + set); // [1, 2, 3, 4, 5]

		// Q8: b) unmodifiable view backed by original
		System.out.println("Q8: b) unmodifiable view backed by original list");
	}
}
