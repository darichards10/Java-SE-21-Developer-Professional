package se21.generics;

/**
 * EXAM TOPIC: Generics — Generic Records
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Generic record declaration: record Name&lt;T&gt;(T component) — type parameter on a record
 * - Record components are implicitly private final; accessor method is auto-generated
 * - Overriding a record's auto-generated accessor to add validation logic
 * - Implementing a generic interface (raw here — exam may test raw vs parameterized)
 * - Type parameter T flows through record component and accessor return type
 * - Records are implicitly final and cannot be extended
 */
public record ContainerRecord<T>(T contents) implements Removable { // EXAM: generic record; T applied to record component; Removable used raw (no <T>) — causes unchecked warning

	public T contents() { // EXAM: compact accessor override; adds null-check guard — records allow this pattern
		if (contents == null)
			throw new IllegalStateException(); // EXAM: overriding auto-generated accessor to enforce invariants
		return contents;
	}

	@Override
	public Object remove() { // EXAM: raw Removable forces Object return type; parameterizing as Removable<T> would allow return T
		// TODO Auto-generated method stub
		return null;
	}
}
