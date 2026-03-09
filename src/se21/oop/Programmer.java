package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Records
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - record declaration (Java 16+): components in the header become private final fields with auto-generated accessors
 * - Records are implicitly final — they cannot be extended; they implicitly extend java.lang.Record
 * - Auto-generated methods: accessor methods name() and age() (not getName/getAge), equals(), hashCode(), and toString()
 * - Compact constructor: no parameter list; components are in scope; 'this.field = value' assignments are injected automatically at the end
 * - Canonical constructor (commented out): explicit form with explicit assignments; compact form is preferred for validation
 * - Custom constructors must delegate to the canonical constructor via this(...) as the first statement
 * - Records can implement interfaces but cannot extend classes other than java.lang.Record
 */
public record Programmer(String name, Integer age) implements CanRun { // EXAM: record — implicitly final; components name and age become private final fields with public accessors

//	public Programmer(String name, Integer age) { // EXAM: this is the canonical constructor form — explicit assignments required; compact form below is preferred
//		if (age < 0)
//			throw new IllegalArgumentException();
//		this.age = age;
//		this.name = name;
//	}

	public Programmer { // EXAM: compact constructor — no parameter list; validates/transforms components; compiler inserts 'this.name=name; this.age=age;' at the end automatically
		if (age < 0) {
			throw new IllegalArgumentException();
		}
	}

	public Programmer(String firstName, String lastName, Integer age) { // EXAM: custom constructor — must call the canonical constructor via this() as the first statement
		this(firstName + " " + lastName, age);
	}

	@Override
	public Float getSpeed() { // EXAM: record implementing an interface — must provide bodies for all interface abstract methods
		return 3.12f;
	}
}
