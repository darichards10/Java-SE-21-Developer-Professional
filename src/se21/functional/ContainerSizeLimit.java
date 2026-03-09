package se21.functional;

/**
 * EXAM TOPIC: Generics — Bounded Type Parameters
 * Oracle Java SE 21 Developer Professional (1Z0-830) — included in OOP/Functional domain
 *
 * Covers:
 * - Multiple type parameters: class Name<T, S> — each is independent
 * - Implementing a generic interface with a concrete type parameter: implements Removable<T>
 * - Each type parameter can be independently bounded, e.g. <T extends Comparable<T>, S extends Number>
 * - Type parameters are erased at runtime (type erasure); no instanceof checks on T
 * - Generic class fields, constructors, and methods using multiple type parameters
 * - Contrast with wildcards: type parameters bind a name; wildcards (<?>) do not
 */
public class ContainerSizeLimit<T, S> implements Removable<T> { // EXAM: two independent type parameters; T propagated to Removable<T>

	private T contents; // EXAM: field typed to first parameter T
	private S size; // EXAM: field typed to second parameter S; independent from T

	public ContainerSizeLimit(T contents, S size) { // EXAM: constructor receives both type parameters; compiler enforces types at call site
		this.contents = contents;
		this.size = size;
	}

	public T getContents() { // EXAM: returns T — first type parameter
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}

	public S getSize() { // EXAM: returns S — second type parameter; independently typed from T
		return size;
	}

	@Override
	public T remove() { // EXAM: satisfies Removable<T> contract; return type matches the type argument passed to the interface
		T temp = this.contents;
		this.contents = null; // EXAM: null is always assignable to any reference type T; valid at runtime after erasure
		return temp;
	}
}
