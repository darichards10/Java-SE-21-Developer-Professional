package se21.oop;

/**
 * EXAM TOPIC: Java Object-Oriented Approach / Enums
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~19% of exam
 *
 * Covers:
 * - Abstract methods in enums: when an enum declares an abstract method, EVERY constant must provide a constant-specific class body
 * - Constant-specific class body: the block after a constant name (e.g. WINTER { ... }) acts like an anonymous subclass
 * - Each constant effectively extends the enum type with its own implementation of the abstract method
 * - Enum constructor is always private; no explicit constructor here means the compiler supplies a private no-arg one
 * - An enum with an abstract method cannot be instantiated directly — only its constants (which have bodies) exist
 */
public enum SeasonWithTimes {
	WINTER { // EXAM: constant-specific class body — WINTER is an anonymous subclass of SeasonWithTimes; required because getHours() is abstract
		@Override
		public String getHours() {
			return "10am-3pm";
		}
	},
	SPRING { // EXAM: every constant must override the abstract method; omitting any one causes a compile error
		@Override
		public String getHours() {
			return "9am-5pm";
		}
	},
	SUMMER {
		@Override
		public String getHours() {
			return "9am-7pm";
		}
	},
	FALL {
		@Override
		public String getHours() {
			return "9am-5pm";
		}
	};

	public abstract String getHours(); // EXAM: abstract method in enum — forces each constant to supply its own implementation via a constant-specific class body
}
