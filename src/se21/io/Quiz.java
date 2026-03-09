package se21.io;

/**
 * SELF-TEST: Using Java I/O API
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~12% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What does Files.readAllLines() return?
	// a) Stream<String>   b) List<String>   c) String[]   d) byte[]
	// ANSWER: ___

	// Q2: What does Path.of("/a/b/../c").normalize() return?
	// a) /a/b/../c   b) /a/c   c) /c   d) /a/b/c
	// ANSWER: ___

	// Q3: What is the difference between InputStream and Reader?
	// a) No difference   b) InputStream reads bytes; Reader reads characters
	// c) Reader reads bytes; InputStream reads characters   d) InputStream reads files; Reader reads network
	// ANSWER: ___

	// Q4: In try-with-resources, in what order are multiple resources closed?
	// a) Declaration order (first declared, first closed)
	// b) Reverse declaration order (last declared, first closed)
	// c) Alphabetical order by variable name
	// d) Order is undefined
	// ANSWER: ___

	// Q5: What keyword excludes a field from Java serialization?
	// a) static   b) volatile   c) transient   d) native
	// ANSWER: ___

	// Q6: What does Files.walk() return?
	// a) List<Path>   b) Stream<Path>   c) Iterator<Path>   d) Path[]
	// ANSWER: ___

	// Q7: What is the output of Path.of("a/b/c.txt").getFileName()?
	// a) Path("a/b")   b) Path("c.txt")   c) Path("a/b/c.txt")   d) null
	// ANSWER: ___

	public static void main(String[] args) throws Exception {
		// Q1: b) List<String>
		System.out.println("Q1: b) List<String>");

		// Q2: b) /a/c — normalize() removes ".." components
		java.nio.file.Path normalized = java.nio.file.Path.of("/a/b/../c").normalize();
		System.out.println("Q2: " + normalized); // /a/c

		// Q3: b) InputStream = bytes; Reader = characters
		System.out.println("Q3: b) InputStream reads bytes; Reader reads characters (decoded chars)");

		// Q4: b) Reverse declaration order — last declared resource is closed first
		System.out.println("Q4: b) Reverse declaration order");

		// Q5: c) transient — excluded from serialization
		System.out.println("Q5: c) transient");

		// Q6: b) Stream<Path> — lazily evaluated; must be closed (use try-with-resources)
		System.out.println("Q6: b) Stream<Path>");

		// Q7: b) Path("c.txt") — getFileName() returns last component
		java.nio.file.Path p = java.nio.file.Path.of("a/b/c.txt");
		System.out.println("Q7: " + p.getFileName()); // c.txt
	}
}
