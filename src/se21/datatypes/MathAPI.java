package se21.datatypes;

import java.math.BigInteger;

/**
 * EXAM TOPIC: Handling Date, Time, Text, Numeric and Boolean Values — Math API
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - BigInteger: immutable arbitrary-precision integer; all operations return new instances
 * - BigDecimal: immutable arbitrary-precision decimal (not shown here, but exam-tested)
 * - Method chaining: BigInteger methods return new BigInteger — chain operations
 * - Key methods: add(), subtract(), multiply(), divide(), remainder(), max(), min(), pow()
 * - BigInteger.TEN, ZERO, ONE are predefined constants
 * - Math class: abs(), min(), max(), round(), floor(), ceil(), sqrt(), pow()
 */
public class MathAPI {

	public static void bigIntOperations() {
		// EXAM: BigInteger is immutable; each operation returns a new object
		var bigInt = BigInteger.valueOf(199)
				.add(BigInteger.valueOf(1))    // 200
				.divide(BigInteger.TEN)        // 20
				.max(BigInteger.valueOf(6));   // max(20, 6) = 20
		System.out.println(bigInt); // 20
	}

	public static void mathMethods() {
		System.out.println(Math.abs(-5));         // 5
		System.out.println(Math.max(3, 7));       // 7
		System.out.println(Math.min(3, 7));       // 3
		System.out.println(Math.round(2.5));      // EXAM: round(2.5) = 3 (rounds up at .5)
		System.out.println(Math.floor(2.9));      // 2.0 — largest integer ≤ value
		System.out.println(Math.ceil(2.1));       // 3.0 — smallest integer ≥ value
		System.out.println(Math.pow(2, 10));      // 1024.0
		System.out.println(Math.sqrt(16));        // 4.0
	}
}
