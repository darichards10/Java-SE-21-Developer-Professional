package se21.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAM TOPIC: Java Object-Oriented Approach
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - final class: prevents subclassing; compiler enforces this at compile time
 * - final instance fields: must be assigned exactly once, either at declaration or in constructor
 * - Mutable vs immutable collections: ArrayList is mutable; List.of() produces an unmodifiable list
 * - Instance initializer blocks: run after super() but before the rest of the constructor body
 */
public final class Animal { // EXAM: final class cannot be extended; any attempt to subclass causes a compile error
	private final List<String> favoriteFoods; // EXAM: final field — must be initialized in every constructor path

	public Animal() {
		this.favoriteFoods = new ArrayList<String>(); // EXAM: ArrayList is mutable; contrast with List.of() which throws UnsupportedOperationException on modification
		this.favoriteFoods.add("Apples");
	}

	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}

	public String getFavoriteFoodsItem(int index) {
		return favoriteFoods.get(index);
	}
}
