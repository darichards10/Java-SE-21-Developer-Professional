package se21;

import java.math.BigInteger;

/**
 * EXAM TOPIC: Handling date, time, text, numeric and boolean values
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - BigInteger and BigDecimal immutability: operations return new instances
 * - Method chaining on BigInteger/BigDecimal because each method returns a new object
 * - Arbitrary precision arithmetic: no overflow unlike int/long
 * - Static factory methods: BigInteger.valueOf(), BigInteger.TEN, etc.
 */
public class MathAPI {

	public static void bigIntOperations() {
		var bigInt = BigInteger.valueOf(199) // EXAM: BigInteger.valueOf() is the preferred factory method; avoids new BigInteger() with string parsing for small values
				.add(BigInteger.valueOf(1))   // EXAM: BigInteger is immutable — add() does NOT modify the original; it returns a NEW BigInteger
				.divide(BigInteger.TEN)       // EXAM: BigInteger.TEN is a predefined constant; others include ZERO, ONE, TWO
				.max(BigInteger.valueOf(6));  // EXAM: method chaining works because each operation returns a new BigInteger instance
		System.out.println(bigInt); // 20    // EXAM: result is 20; (199+1)/10 = 20, max(20, 6) = 20 — note integer division truncates
	}
}
