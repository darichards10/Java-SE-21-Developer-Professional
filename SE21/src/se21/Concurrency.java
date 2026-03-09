package se21;

import java.util.List;

/**
 * EXAM TOPIC: Concurrency
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - parallelStream() vs sequential stream() for processing collections
 * - Non-deterministic ordering with parallelStream().forEach()
 * - Thread safety considerations when using parallel streams
 * - Method references as stream terminal operations
 */
public class Concurrency {

	public static void printListWithParallelStream() {
		List<String> list = List.of("A", "B", "C", "D");
		list.parallelStream().forEach(System.out::print); // EXAM: parallelStream() splits work across multiple threads; output ORDER IS NOT GUARANTEED — a common exam trap
		System.out.println();
	}

	public static void printListWithStream() {
		List<String> list = List.of("A", "B", "C", "D");
		list.stream().forEach(System.out::print); // EXAM: sequential stream processes elements in encounter order; output is predictable (A, B, C, D)
		System.out.println();
	}
}
