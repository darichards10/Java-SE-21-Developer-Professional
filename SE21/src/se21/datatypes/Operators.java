package se21.datatypes;

/**
 * EXAM TOPIC: Handling Date, Time, Text, Numeric and Boolean Values — Operators
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - Operator precedence: *, /, % before +, -; ^ (XOR) after arithmetic; parentheses override
 * - Bitwise XOR ^ vs boolean XOR ^: same operator, different operand types
 * - Ternary operator: condition ? valueIfTrue : valueIfFalse
 * - Compound assignment operators: +=, -=, *=, /=, ^= (implicit cast on narrowing)
 * - Integer promotion: byte, short, char promoted to int in arithmetic expressions
 */
public class Operators {
	int a = 5;
	int b = 2;
	int c = 3;

	int op1 = a + b * c;     // EXAM: * before + → 5 + 6 = 11
	int op2 = (a + b) * c;   // EXAM: parentheses first → 7 * 3 = 21
	int op3 = a + b - c;     // EXAM: left-to-right → 7 - 3 = 4
	int op4 = a * b + c;     // EXAM: * before + → 10 + 3 = 13
	int op5 = a / b * c;     // EXAM: left-to-right (/ then *) → 2 * 3 = 6 (integer division: 5/2=2)
	int op6 = a * (b + c);   // EXAM: parentheses first → 5 * 5 = 25

	int bitwiseXor1 = a ^ b; // EXAM: bitwise XOR on int: 5^2 = 7 (0101 ^ 0010 = 0111)

	boolean t = true;
	boolean f = false;
	boolean booleanXor1 = t ^ f; // EXAM: boolean XOR: true ^ false = true (not equal = true)
	boolean booleanXor2 = t ^ t; // EXAM: boolean XOR: true ^ true = false (equal = false)

	int combined = a + b * c ^ (a - b); // EXAM: * first (6), then + (11), then ^ (11^3 = 8)

	int ternaryResult = (a > b) ? a : b; // EXAM: ternary; condition is true (5>2), so result = a = 5
}
