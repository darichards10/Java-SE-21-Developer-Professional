package se21.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAM TOPIC: Generics — Wildcards and Bounded Type Parameters
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Unbounded wildcard &lt;?&gt;: accepts any type; list is effectively read-only (only null can be added)
 * - Upper-bounded wildcard &lt;? extends Type&gt;: read-safe (can get Type); cannot add (compiler doesn't know exact subtype)
 * - Lower-bounded wildcard &lt;? super Type&gt;: write-safe (can add Type or subtype); reads come back as Object
 * - PECS mnemonic: Producer Extends, Consumer Super
 * - Generic method declaration: &lt;T&gt; before return type; explicit type witness Main.&lt;String&gt;method()
 * - Type erasure: generics exist only at compile time; at runtime all type params become Object (or bound)
 * - Diamond operator &lt;&gt;: compiler infers type argument from context (Java 7+)
 * - Generic types are invariant: List&lt;String&gt; is NOT a subtype of List&lt;Object&gt;
 */
public class Main {

	public static void main(String[] args) {
		Container<String> container = new Container<>(); // EXAM: diamond operator <>; compiler infers <String> from declared type
		container.putContents("Im generic");
		System.out.println(container.getContents());

		ContainerSizeLimit<String, Integer> confinedContainer = new ContainerSizeLimit<>("contents", 5); // EXAM: multiple type parameters instantiated with concrete types
		System.out.println(confinedContainer.getContents());
		System.out.println(confinedContainer.remove());
		System.out.println(confinedContainer.getContents()); // EXAM: returns null after remove() — illustrates null erasure of contents

		prepare(new Container<StringBuilder>(new StringBuilder("Built"))); // EXAM: type inference — compiler infers T=Container<StringBuilder>
		Main.<String>prepare("new"); // EXAM: explicit type witness — forces T=String; rarely needed but valid syntax

		Container<StringBuilder> sbCont = new Container<StringBuilder>(new StringBuilder("Built"));
		ContainerRecord<Container<StringBuilder>> sbContRec = new ContainerRecord<>(sbCont); // EXAM: nested generic types; T=Container<StringBuilder>

		ContainerRecord<String> normalRec = new ContainerRecord<>("normal");

		// unbound wildcard
		List<?> a = new ArrayList<String>(); // EXAM: unbounded wildcard; can hold any List<X>; cannot add elements (except null)

		List<? extends Exception> b = new ArrayList<RuntimeException>(); // EXAM: upper-bounded wildcard; can read as Exception; cannot add (unknown exact subtype)

		List<? super Exception> c = new ArrayList<Object>(); // EXAM: lower-bounded wildcard; can add Exception or subtype; reads return Object
	}

	public static <T> void prepare(T t) { // EXAM: generic method; <T> declared before return type; T inferred from argument
		System.out.println("Preparing " + t);
	}

	public static <T> Container<T> ship(T t) { // EXAM: generic method returning a parameterized type Container<T>
		System.out.println("Shipping " + t);
		return new Container<T>(); // EXAM: type parameter T passed through to Container constructor
	}

	public static void printList(List<?> list) { // EXAM: unbounded wildcard parameter; accepts List of any type; elements read as Object
		for (Object x : list)
			System.out.println(x);
	}

	<T> T first(List<? extends T> list) { // EXAM: upper-bounded wildcard with type param T; list produces T — classic PECS Producer Extends pattern
		return list.get(0);
	}

	void logExceptions(List<? extends Exception> errors) { // EXAM: upper-bounded wildcard; accepts List<Exception>, List<RuntimeException>, etc.; read-only safe
		for (Exception e : errors) {
			System.err.println(e.getMessage());
		}
	}

	void printAll(List<?> list) { // EXAM: unbounded wildcard; most flexible — accepts any List; elements only accessible as Object
		for (Object item : list) {
			System.out.println(item);
		}
	}

	void collectProblems(List<? super Exception> sink) { // EXAM: lower-bounded wildcard; accepts List<Exception>, List<Throwable>, List<Object>; PECS Consumer Super
	    sink.add(new NullPointerException("oops")); // EXAM: can add Exception or any subtype; compiler allows this with <? super Exception>
	    sink.add(new IllegalArgumentException("bad input"));
	    // ...
	}
}
