package se21;

import java.util.List;

public class Concurrency {

	public static void printListWithParallelStream() {
		List<String> list = List.of("A", "B", "C", "D");
		list.parallelStream().forEach(System.out::print);
		System.out.println();
	}
	
	public static void printListWithStream() {
		List<String> list = List.of("A", "B", "C", "D");
		list.stream().forEach(System.out::print);
		System.out.println();
	}
}
