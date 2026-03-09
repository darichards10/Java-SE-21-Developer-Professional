<<<<<<< HEAD:src/se21/datatypes/Types.java
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
=======
package se21;

/**
 * EXAM TOPIC: Handling date, time, text, numeric and boolean values
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Eight primitive types and their sizes/defaults
 * - Wrapper classes and the three ways to obtain an instance: autoboxing, valueOf(), new (deprecated)
 * - Autoboxing: automatic conversion between primitive and wrapper (e.g., int -> Integer)
 * - Integer.parseInt() vs Integer.valueOf(): parseInt() returns a primitive, valueOf() returns a wrapper
 * - Boolean.parseBoolean(): case-insensitive "true" returns true; anything else returns false
 * - Array declaration: primitive arrays default to 0/false; wrapper arrays default to null
 * - new WrapperType() constructors are deprecated since Java 9
 */
public class Types {
	// EXAM: eight primitive types — know their default values: numeric=0, boolean=false, char='\u0000'
	byte pByte = 10;       // EXAM: byte range: -128 to 127 (8-bit signed)
	short pShort = 20;     // EXAM: short range: -32,768 to 32,767 (16-bit signed)
	int pInt = 30;         // EXAM: int is the default integer type; 32-bit signed
	long pLong = 40L;      // EXAM: 'L' suffix required for long literals; without it, the literal is treated as int (compile error if out of int range)
	float pFloat = 3.14f;  // EXAM: 'f' suffix required for float literals; without it, 3.14 is a double
	double pDouble = 2.718; // EXAM: double is the default floating-point type; 64-bit
	char pChar = 'A';      // EXAM: char is unsigned 16-bit; stores a single Unicode character
	boolean pBoolean = true; // EXAM: boolean only accepts true or false; no numeric equivalent (unlike C)

	// EXAM: autoboxing — the compiler automatically calls Integer.valueOf(10); avoids 'new Integer(10)'
	Byte wByte1 = 10;                    // EXAM: autoboxing from int literal to Byte; narrowing must fit in byte range
	Byte wByte2 = Byte.valueOf((byte) 10); // EXAM: valueOf() uses cache for small values (-128 to 127); preferred over new
	Byte wByte3 = new Byte((byte) 10);   // EXAM: deprecated since Java 9; avoid on exam answers unless recognizing it as deprecated
	Byte wByte4 = Byte.valueOf("10");    // EXAM: valueOf(String) parses and boxes; equivalent to autoboxing from parsed result

	Short wShort1 = 10;
	Short wShort2 = Short.valueOf((short) 10);
	Short wShort3 = new Short((short) 10); // EXAM: deprecated constructor
	Short wShort4 = Short.valueOf("10");

	Integer wInt1 = 10;                  // EXAM: autoboxing; Integer.valueOf() is called; values -128 to 127 are cached
	Integer wInt2 = Integer.valueOf(10); // EXAM: same as autoboxing; explicit; returns cached instance for small values
	Integer wInt3 = Integer.valueOf("10"); // EXAM: valueOf(String) is like parseInt() but returns Integer wrapper, not int primitive
	Integer wInt4 = new Integer(10);     // EXAM: deprecated since Java 9; always creates a new object (bypasses cache)

	Long wLong1 = 10L;
	Long wLong2 = Long.valueOf(10);
	Long wLong3 = Long.valueOf("10");
	Long wLong4 = new Long(10); // EXAM: deprecated constructor

	Float wFloat1 = 3.14f;
	Float wFloat2 = Float.valueOf(3.14f);
	Float wFloat3 = Float.valueOf("3.14");
	Float wFloat4 = new Float(3.14f); // EXAM: deprecated constructor

	Double wDouble1 = 3.14;
	Double wDouble2 = Double.valueOf(3.14);
	Double wDouble3 = Double.valueOf("3.14");
	Double wDouble4 = new Double(3.14); // EXAM: deprecated constructor

	Character wChar1 = 'A';
	Character wChar2 = Character.valueOf('A');
	Character wChar3 = new Character('A'); // EXAM: deprecated constructor

	Boolean wBool1 = true;
	Boolean wBool2 = Boolean.valueOf(true);
	Boolean wBool3 = Boolean.valueOf("true");  // EXAM: case-insensitive "true" string → Boolean.TRUE; any other string → Boolean.FALSE
	Boolean wBool4 = new Boolean(true);        // EXAM: deprecated constructor
	Boolean wBool5 = Boolean.valueOf("anything"); // EXAM: returns FALSE — only "true" (case-insensitive) maps to TRUE; everything else is FALSE

	// EXAM: parseInt/parseLong/etc. return PRIMITIVES; valueOf() returns WRAPPER objects — know the difference
	int parsedInt = Integer.parseInt("10");          // EXAM: returns primitive int; throws NumberFormatException for non-numeric strings
	long parsedLong = Long.parseLong("123");         // EXAM: returns primitive long
	double parsedDouble = Double.parseDouble("3.14"); // EXAM: returns primitive double
	float parsedFloat = Float.parseFloat("2.5");     // EXAM: returns primitive float
	boolean parsedBoolean = Boolean.parseBoolean("TRUE"); // EXAM: returns primitive boolean; "TRUE" → true (case-insensitive)

	// EXAM: primitive arrays are initialized to default values (0 / false); wrapper arrays are initialized to null
	int[] arrInt = new int[3];            // EXAM: elements default to 0
	Integer[] arrIntWrap = new Integer[3]; // EXAM: elements default to null (not 0); unboxing a null Integer causes NullPointerException
	boolean[] arrBool = new boolean[2];   // EXAM: elements default to false
	Boolean[] arrBoolWrap = new Boolean[2]; // EXAM: elements default to null; Boolean array can store null, true, or false
}
>>>>>>> fd67abe4c885af47c3feb1e4a8062213bc890584:SE21/src/se21/Types.java
