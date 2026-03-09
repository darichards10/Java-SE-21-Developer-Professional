package se21;

/**
 * EXAM TOPIC: Operators and Expressions
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Operator precedence: * and / before + and -, then bitwise ^, then relational, then ternary
 * - Integer arithmetic: / truncates toward zero (no rounding), * evaluated left to right
 * - XOR (^) operator: works on both integral types (bitwise) and boolean types (logical)
 * - Ternary operator (?:) as a concise conditional expression
 * - Parentheses override default precedence
 */
public class Operators {
	int a = 5;
	int b = 2;
	int c = 3;

	int op1 = a + b * c;   // EXAM: * has higher precedence than +; evaluates as a + (b * c) = 5 + 6 = 11
	int op2 = (a + b) * c; // EXAM: parentheses override precedence; (a + b) is computed first = 7 * 3 = 21
	int op3 = a + b - c;   // EXAM: + and - have equal precedence and are left-associative; = (5+2)-3 = 4
	int op4 = a * b + c;   // EXAM: * before +; = (5*2)+3 = 13
	int op5 = a / b * c;   // EXAM: / and * are equal precedence, left-associative; = (5/2)*3 = 2*3 = 6 (integer division truncates 5/2 to 2)
	int op6 = a * (b + c); // EXAM: parentheses force b+c first; = 5 * 5 = 25

	int bitwiseXor1 = a ^ b; // EXAM: ^ on ints is bitwise XOR; 5 (101) ^ 2 (010) = 7 (111); not exponentiation (use Math.pow() for that)

	boolean t = true;
	boolean f = false;
	boolean booleanXor1 = t ^ f; // EXAM: ^ on booleans is logical XOR; true ^ false = true (different values)
	boolean booleanXor2 = t ^ t; // EXAM: true ^ true = false (same values); XOR is true only when operands differ

	int combined = a + b * c ^ (a - b); // EXAM: precedence chain: * first → b*c=6; then + → a+6=11; then ^ → 11^(a-b)=11^3=8; ^ has lower precedence than arithmetic

	int ternaryResult = (a > b) ? a : b; // EXAM: ternary operator — evaluates condition; returns 'a' if true, 'b' if false; equivalent to Math.max(a,b) here

}
