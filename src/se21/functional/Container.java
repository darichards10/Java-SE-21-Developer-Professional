package se21.functional;

/**
 * EXAM TOPIC: Generics
 * Oracle Java SE 21 Developer Professional (1Z0-830) — included in OOP/Functional domain
 *
 * Covers:
 * - Generic class declaration: class Name<T> — T is the formal type parameter
 * - Type parameter T is replaced at compile time (type erasure at runtime)
 * - Generic fields, constructors, and methods using the type parameter
 * - Diamond operator <> allows type inference on the right-hand side (Java 7+)
 * - Benefits: compile-time type safety, eliminates casts, enables reuse
 */
public class Container<T> { // EXAM: <T> declares a type parameter; T is a placeholder for any reference type

	private T contents; // EXAM: field typed to T; type is determined when Container is instantiated

	public Container() { // EXAM: no-arg constructor; contents defaults to null (type-safe)
	}

	public Container(T contents) { // EXAM: constructor accepting T; type enforced at compile time
		this.contents = contents;
	}

	public T getContents() { // EXAM: return type T — caller receives the correct type without casting
		return contents;
	}

	public void putContents(T contents) { // EXAM: parameter type T — compiler prevents passing wrong type
		this.contents = contents;
	}
}
