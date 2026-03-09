package se21.collections;

/**
 * EXAM TOPIC: Working with Arrays and Collections
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - record as a concise data carrier (Java 16+, tested on exam)
 * - Implementing Comparable&lt;T&gt; to define natural ordering
 * - compareTo() contract: negative/zero/positive return values
 * - Natural ordering is used by TreeSet, TreeMap, and Collections.sort() without a Comparator
 * - Records auto-generate equals(), hashCode(), toString(), and accessors
 */
public record Dog(String breed, int age) implements Comparable<Dog> { // EXAM: record implicitly final; components become private fields with public accessors

	@Override
	public int compareTo(Dog o) { // EXAM: defines natural ordering; must be consistent with equals() for sorted collections
		return breed.compareTo(o.breed); // EXAM: delegates to String.compareTo() for lexicographic natural order by breed
	}

}
