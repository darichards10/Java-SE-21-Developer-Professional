package se21.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * EXAM TOPIC: Managing Concurrent Code Execution
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~11% of exam
 *
 * Covers:
 * - parallelStream() vs stream(): parallel execution with no guaranteed order
 * - ExecutorService: submit() for Callable/Runnable, shutdown(), awaitTermination()
 * - Thread safety: synchronized blocks, Lock/ReentrantLock, AtomicInteger
 * - Concurrent collections: CopyOnWriteArrayList, ConcurrentHashMap
 * - Virtual Threads (Java 21): Thread.ofVirtual(), Executors.newVirtualThreadPerTaskExecutor()
 * - Race condition: non-atomic read-modify-write on shared variables is unsafe
 * - Deadlock: two threads each waiting for locks held by the other
 * - Callable vs Runnable: Callable returns a value and can throw checked exceptions
 */
public class Concurrency {

	public static void main(String[] args) {
		printListWithParallelStream();
		printListWithStream();
	}

	public static void printListWithParallelStream() {
		List<String> list = List.of("A", "B", "C", "D");
		// EXAM: parallelStream() may execute in any order; output order is non-deterministic
		list.parallelStream().forEach(System.out::print);
		System.out.println();
	}

	public static void printListWithStream() {
		List<String> list = List.of("A", "B", "C", "D");
		// EXAM: sequential stream; forEach preserves encounter order
		list.stream().forEach(System.out::print);
		System.out.println();
	}

	public static void executorServiceExample() throws Exception {
		// EXAM: ExecutorService manages thread pools; always shut down to prevent resource leak
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<Integer> result = pool.submit(() -> 42); // EXAM: Callable returns a Future
		System.out.println(result.get()); // EXAM: get() blocks until result available
		pool.shutdown();
	}

	public static void atomicExample() {
		// EXAM: AtomicInteger ensures thread-safe increment without synchronized
		AtomicInteger counter = new AtomicInteger(0);
		counter.incrementAndGet(); // atomic: read, increment, write as one unit
		System.out.println(counter.get());
	}

	public static void lockExample() {
		// EXAM: ReentrantLock provides explicit lock/unlock; try-finally ensures unlock
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println("critical section");
		} finally {
			lock.unlock(); // EXAM: always unlock in finally to prevent deadlock if exception thrown
		}
	}

	public static void virtualThreadExample() throws Exception {
		// EXAM: Java 21 virtual threads — lightweight threads managed by JVM, not OS
		Thread vt = Thread.ofVirtual().start(() -> System.out.println("virtual thread"));
		vt.join();

		// EXAM: newVirtualThreadPerTaskExecutor creates a new virtual thread per task
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			executor.submit(() -> System.out.println("from virtual executor"));
		}
	}
}
