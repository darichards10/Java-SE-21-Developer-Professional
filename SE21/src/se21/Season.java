package se21;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Enums
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Basic enum declaration: constants are implicitly public static final instances of the enum type
 * - Season.values(): returns a Season[] of all constants in declaration order; useful for iteration
 * - Season.valueOf(String): returns the constant whose name matches the string exactly; throws IllegalArgumentException if not found
 * - Enum.ordinal(): returns the zero-based position of a constant (SPRING=0, SUMMER=1, FALL=2, WINTER=3)
 * - Enum.name(): returns the constant's declared name as a String; same result as toString() by default
 * - Enums implicitly extend java.lang.Enum and cannot extend any other class; they may implement interfaces
 */
public enum Season {
	SPRING, SUMMER, FALL, WINTER // EXAM: declaration order determines ordinal() values (SPRING=0 ... WINTER=3) and the order of values() array
}
