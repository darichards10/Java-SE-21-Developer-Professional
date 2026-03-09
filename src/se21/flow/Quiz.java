package se21.flow;

/**
 * SELF-TEST: Controlling Program Flow
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~9% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is printed?
	//   int i = 0;
	//   do { i++; } while (i < 0);
	//   System.out.println(i);
	// a) 0   b) 1   c) infinite loop   d) compile error
	// ANSWER: ___

	// Q2: What is the output?
	//   int fish = 2;
	//   String result = switch (fish) {
	//       case 1 -> "Goldfish";
	//       case 2 -> { yield "Trout"; }
	//       default -> "Unknown";
	//   };
	//   System.out.println(result);
	// a) "Goldfish"   b) "Trout"   c) "Unknown"   d) compile error
	// ANSWER: ___

	// Q3: Pattern matching for switch — what prints for getTrainer(5)?
	//   switch (height) {
	//       case Integer i when i > 10 -> "Joseph";
	//       case Integer i -> "Daniel";
	//       default -> "Ralph";
	//   }
	// a) "Joseph"   b) "Daniel"   c) "Ralph"   d) compile error
	// ANSWER: ___

	// Q4: What is printed?
	//   OUTER: for (int i=0; i<3; i++) {
	//       for (int j=0; j<3; j++) {
	//           if (j==1) continue OUTER;
	//           System.out.print(i + "" + j + " ");
	//       }
	//   }
	// a) 00 10 20   b) 00 01 02 10 20   c) 00 11 22   d) nothing
	// ANSWER: ___

	// Q5: Which switch expression DOES NOT compile?
	// a) switch (x) { case 1 -> "a"; default -> "b"; }
	// b) switch (x) { case 1: yield "a"; default: yield "b"; }
	// c) switch (x) { case 1: return "a"; default: return "b"; }
	// d) switch (x) { case null -> "n"; default -> "b"; }  (where x is String)
	// ANSWER: ___

	// Q6: What is printed?
	//   Number n = 7;
	//   if (n instanceof Integer i && i > 5) System.out.println("big int");
	//   else System.out.println("other");
	// a) "big int"   b) "other"   c) compile error   d) runtime exception
	// ANSWER: ___

	// Q7: What happens when you use a traditional switch with fall-through?
	//   int x = 1;
	//   switch (x) { case 1: case 2: System.out.print("A"); break; case 3: System.out.print("B"); }
	// a) "A"   b) "AB"   c) "B"   d) nothing
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1
		int i = 0;
		do { i++; } while (i < 0); // body runs once before condition checked
		System.out.println("Q1: " + i); // 1

		// Q2
		int fish = 2;
		String result = switch (fish) {
			case 1 -> "Goldfish";
			case 2 -> { yield "Trout"; } // yield returns value from block
			default -> "Unknown";
		};
		System.out.println("Q2: " + result); // Trout

		// Q3: getTrainer(5) — 5 is Integer, and 5 <= 10, so falls to "case Integer i -> Daniel"
		System.out.println("Q3: Daniel (5 is Integer but not > 10)");

		// Q4
		System.out.print("Q4: ");
		OUTER: for (int r = 0; r < 3; r++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1) {
					continue OUTER; // skip to next outer iteration
				}
				System.out.print(r + "" + j + " ");
			}
		}
		System.out.println(); // 00 10 20

		// Q5: c) — 'return' inside a switch expression is not valid; yield or -> must be used
		System.out.println("Q5: c) return inside switch expression does not compile");

		// Q6
		Number n = 7;
		if (n instanceof Integer val && val > 5) {
			System.out.println("Q6: big int");
		} else {
			System.out.println("Q6: other");
		}

		// Q7
		int x = 1;
		System.out.print("Q7: ");
		switch (x) { case 1: case 2: System.out.print("A"); break; case 3: System.out.print("B"); }
		System.out.println(); // A — fall-through from case 1 to case 2 body
	}
}
