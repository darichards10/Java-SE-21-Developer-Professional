package se21.oop;

public class Lemur extends Primate implements HasTail { // EXAM: Lemur satisfies both superclass (Primate) and interface (HasTail) contracts
	int age = 10;

	@Override
	public boolean isTailStriped() { // EXAM: overrides the interface's abstract method; must be public (cannot reduce visibility from interface's implicit public)
		return false;
	}
}
