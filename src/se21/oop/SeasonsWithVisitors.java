package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Enums
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - enum implementing an interface: the enum (or each constant) must provide the required method body
 * - Each enum constant can be thought of as a singleton instance of the enum class
 * - Enum constructor is always private (implicit or explicit); cannot use public/protected
 * - Enum fields: private final instance fields initialized via the constructor for each constant
 * - public static final field in an enum: accessible as SeasonsWithVisitors.DESCRIPTION
 * - Constructor execution order: each constant's constructor runs at class load time in declaration order
 */
public enum SeasonsWithVisitors implements Visitors { // EXAM: enum implementing interface — the enum type satisfies the Visitors contract
	WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium"); // EXAM: each constant calls the private constructor; constructors run in this order at class load

	private final String visitors; // EXAM: per-instance field — each constant stores its own value assigned via the constructor
	public static final String DESCRIPTION = "Weather Enum"; // EXAM: static field on an enum — shared across all constants; accessed as SeasonsWithVisitors.DESCRIPTION

	private SeasonsWithVisitors(String visitors) { // EXAM: enum constructor — always private (compiler enforces this); cannot be called outside the enum declaration
		System.out.print("constructing,");
		this.visitors = visitors;
	}

	@Override
	public void printVistors() { // EXAM: fulfills the Visitors interface contract; every constant shares this single implementation
		System.out.println(visitors);
	}
}
