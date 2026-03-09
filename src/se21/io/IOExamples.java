package se21.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * EXAM TOPIC: Using Java I/O API
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~12% of exam
 *
 * Covers:
 * - java.io streams: InputStream/OutputStream (byte), Reader/Writer (char)
 * - Buffered wrappers: BufferedReader, BufferedWriter — improve performance
 * - java.nio.file.Path: represents a file/directory path; immutable
 * - java.nio.file.Files: utility class with static methods for file operations
 * - Files.readAllLines(), Files.writeString(), Files.copy(), Files.move(), Files.delete()
 * - Files.walk(): recursively traverses a directory tree (returns Stream<Path>)
 * - Files.list(): lists immediate children of a directory
 * - Serialization: Serializable marker interface, ObjectOutputStream, ObjectInputStream
 * - transient keyword: excludes field from serialization
 * - Console class: System.console(); readLine(), readPassword() — for interactive programs
 * - Path.of() vs Paths.get(): both create Path instances; Path.of() preferred (Java 11+)
 * - Absolute vs relative paths; path.resolve(), path.relativize(), path.normalize()
 *
 * TODO: Add your own runnable code examples as you study this topic.
 *       The exam tests: reading/writing files, Path operations, file metadata,
 *       stream vs NIO.2, and serialization gotchas.
 */
public class IOExamples {

	public static void main(String[] args) {
		pathOperations();
	}

	static void pathOperations() {
		// EXAM: Path.of() creates a Path without touching the filesystem
		Path p1 = Path.of("data/file.txt");
		Path p2 = Paths.get("/home/user", "data", "file.txt"); // EXAM: Paths.get() — older API; same result

		System.out.println(p1.getFileName()); // EXAM: last component of the path
		System.out.println(p1.getParent());   // EXAM: all but the last component; null if no parent
		System.out.println(p1.isAbsolute());  // EXAM: false — relative path

		// EXAM: resolve() combines paths; normalize() removes . and .. components
		Path base = Path.of("/home/user");
		Path resolved = base.resolve("docs/readme.txt"); // /home/user/docs/readme.txt
		System.out.println(resolved);
	}

	static void readFileClassic() throws IOException {
		// EXAM: classic I/O with BufferedReader for line-by-line reading
		try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) { // EXAM: readLine() returns null at end of stream
				System.out.println(line);
			}
		} // EXAM: try-with-resources auto-closes BufferedReader (and wrapped FileReader)
	}

	static void readFileNIO() throws IOException {
		// EXAM: NIO.2 Files class — simpler API for common operations
		Path path = Path.of("file.txt");
		List<String> lines = Files.readAllLines(path); // EXAM: reads entire file into memory; not suitable for large files
		lines.forEach(System.out::println);
	}

	static void writeFileNIO() throws IOException {
		Path path = Path.of("output.txt");
		// EXAM: Files.writeString() writes a String to a file; creates if absent
		Files.writeString(path, "Hello, NIO!", StandardOpenOption.CREATE, StandardOpenOption.WRITE);

		// EXAM: StandardOpenOption.APPEND adds to existing content
		Files.writeString(path, "\nSecond line", StandardOpenOption.APPEND);
	}

	static void walkDirectory() throws IOException {
		// EXAM: Files.walk() returns a Stream<Path> for recursive traversal; must be closed
		try (var paths = Files.walk(Path.of("."))) {
			paths.filter(Files::isRegularFile)
				 .filter(p -> p.toString().endsWith(".java"))
				 .forEach(System.out::println);
		}
	}
}
