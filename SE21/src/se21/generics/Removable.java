package se21.generics;

/**
 * EXAM TOPIC: Generics
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Generic interface declaration: interface Name&lt;T&gt;
 * - Type parameter T flows through to method signatures in the interface
 * - Implementing classes must either supply a concrete type or propagate T
 * - A class implementing a raw generic interface suppresses compile-time type checking
 * - Contrast: Removable&lt;String&gt; (concrete) vs class Foo&lt;T&gt; implements Removable&lt;T&gt; (propagated)
 */
public interface Removable<T> { // EXAM: generic interface; T is the type parameter that implementing classes must resolve

	T remove(); // EXAM: method returns T; the return type is determined by the implementing class's type argument
}
