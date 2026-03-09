package se21.functional;

/**
 * EXAM TOPIC: Generics
 * Oracle Java SE 21 Developer Professional (1Z0-830) — included in OOP/Functional domain
 *
 * Covers:
 * - Generic interface declaration: interface Name<T>
 * - Type parameter T flows through to method signatures in the interface
 * - Implementing classes must either supply a concrete type or propagate T
 * - A class implementing a raw generic interface suppresses compile-time type checking
 * - Contrast: Removable<String> (concrete) vs class Foo<T> implements Removable<T> (propagated)
 */
public interface Removable<T> { // EXAM: generic interface; T is the type parameter that implementing classes must resolve

	T remove(); // EXAM: method returns T; the return type is determined by the implementing class's type argument
}
