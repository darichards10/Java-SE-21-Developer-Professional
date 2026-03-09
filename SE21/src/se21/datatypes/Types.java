package se21.datatypes;

/**
 * EXAM TOPIC: Handling Date, Time, Text, Numeric and Boolean Values
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - Eight primitive types and their ranges/defaults
 * - Wrapper class creation: autoboxing, valueOf(), constructor (deprecated but exam-tested)
 * - Parsing: parseInt(), parseLong(), parseDouble(), parseFloat(), parseBoolean()
 * - Boolean.parseBoolean(): case-insensitive "true" → true; anything else → false
 * - Array defaults: primitives default to 0/false; wrapper objects default to null
 */
public class Types {
	byte pByte = 10;
	short pShort = 20;
	int pInt = 30;
	long pLong = 40L;
	float pFloat = 3.14f;
	double pDouble = 2.718;
	char pChar = 'A';
	boolean pBoolean = true;

	Byte wByte1 = 10;
	Byte wByte2 = Byte.valueOf((byte) 10);
	Byte wByte3 = new Byte((byte) 10);
	Byte wByte4 = Byte.valueOf("10");

	Short wShort1 = 10;
	Short wShort2 = Short.valueOf((short) 10);
	Short wShort3 = new Short((short) 10);
	Short wShort4 = Short.valueOf("10");

	Integer wInt1 = 10;
	Integer wInt2 = Integer.valueOf(10);
	Integer wInt3 = Integer.valueOf("10");
	Integer wInt4 = new Integer(10);

	Long wLong1 = 10L;
	Long wLong2 = Long.valueOf(10);
	Long wLong3 = Long.valueOf("10");
	Long wLong4 = new Long(10);

	Float wFloat1 = 3.14f;
	Float wFloat2 = Float.valueOf(3.14f);
	Float wFloat3 = Float.valueOf("3.14");
	Float wFloat4 = new Float(3.14f);

	Double wDouble1 = 3.14;
	Double wDouble2 = Double.valueOf(3.14);
	Double wDouble3 = Double.valueOf("3.14");
	Double wDouble4 = new Double(3.14);

	Character wChar1 = 'A';
	Character wChar2 = Character.valueOf('A');
	Character wChar3 = new Character('A');

	Boolean wBool1 = true;
	Boolean wBool2 = Boolean.valueOf(true);
	Boolean wBool3 = Boolean.valueOf("true");
	Boolean wBool4 = new Boolean(true);
	Boolean wBool5 = Boolean.valueOf("anything"); // EXAM: anything not "true" (case-insensitive) → false

	int parsedInt = Integer.parseInt("10");
	long parsedLong = Long.parseLong("123");
	double parsedDouble = Double.parseDouble("3.14");
	float parsedFloat = Float.parseFloat("2.5");
	boolean parsedBoolean = Boolean.parseBoolean("TRUE"); // EXAM: case-insensitive; "TRUE" → true

	int[] arrInt = new int[3];           // EXAM: primitive array defaults to 0
	Integer[] arrIntWrap = new Integer[3]; // EXAM: wrapper array defaults to null
	boolean[] arrBool = new boolean[2];   // EXAM: boolean array defaults to false
	Boolean[] arrBoolWrap = new Boolean[2]; // EXAM: Boolean array defaults to null
}
