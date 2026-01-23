package se21;

public class Operators {
	int a = 5;
	int b = 2;
	int c = 3;

	int op1 = a + b * c;
	int op2 = (a + b) * c;
	int op3 = a + b - c;
	int op4 = a * b + c;
	int op5 = a / b * c;
	int op6 = a * (b + c);

	int bitwiseXor1 = a ^ b;

	boolean t = true;
	boolean f = false;
	boolean booleanXor1 = t ^ f;
	boolean booleanXor2 = t ^ t;

	int combined = a + b * c ^ (a - b);

	int ternaryResult = (a > b) ? a : b;

}
