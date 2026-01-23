package se21;

import java.math.BigInteger;

public class MathAPI {

	public static void bigIntOperations() {
		var bigInt = BigInteger.valueOf(199).add(BigInteger.valueOf(1)).divide(BigInteger.TEN)
				.max(BigInteger.valueOf(6));
		System.out.println(bigInt); // 20
	}
}
