package se21;

import java.util.List;
import static java.util.Arrays.asList;

public class Kangaroo {
	
	public static void main(String[] args) {
		List<String> list = asList("one", "two");
	}
	
	class Joey {
		static int numJoeys = 0;
		final static int sumJoeyAges;
		final int sumJoeyLegs;

		static {
			sumJoeyAges = 0;
		}

		{
			sumJoeyLegs = 0;
		}
	}

	void hop() {
		interface Hopper {
		}
		enum Size {
			SMALL, MEDIUM, LARGE
		}

	}
}