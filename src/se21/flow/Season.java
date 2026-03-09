package se21.flow;

/**
 * EXAM TOPIC: Controlling Program Flow — Enums in Switch
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~9% of exam
 *
 * Covers:
 * - Enum declaration: implicitly public, static, final constants
 * - Enums can be used in switch statements and switch expressions
 * - Enum.values() returns all constants; Enum.valueOf(String) looks up by name
 * - Enums implicitly extend java.lang.Enum (cannot extend another class)
 * - Enums can implement interfaces
 */
public enum Season {
	SPRING, SUMMER, FALL, WINTER
}
