package se21.concurrency;

/**
 * SELF-TEST: Managing Concurrent Code Execution
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~11% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is the output of parallelStream().forEach(System.out::print) on List.of("A","B","C")?
	// a) Always ABC   b) Always CBA   c) Order is non-deterministic   d) compile error
	// ANSWER: ___

	// Q2: What is the difference between Runnable and Callable?
	// a) No difference   b) Callable returns a value and can throw checked exceptions; Runnable cannot
	// c) Runnable is for threads; Callable is for processes
	// d) Callable was removed in Java 21
	// ANSWER: ___

	// Q3: Which class ensures thread-safe increment of a counter without synchronized?
	// a) Integer   b) AtomicInteger   c) volatile int   d) synchronized int
	// ANSWER: ___

	// Q4: What is a virtual thread? (Java 21)
	// a) A thread running on a GPU   b) A lightweight thread managed by the JVM, not the OS
	// c) A thread pool   d) A thread that exists only in memory
	// ANSWER: ___

	// Q5: If lock.lock() is called in a try block and lock.unlock() is in finally, what happens if an exception occurs in the try block?
	// a) The lock is never released   b) The lock is always released (finally runs)
	// c) The exception swallows the lock   d) Depends on the exception type
	// ANSWER: ___

	// Q6: What is a race condition?
	// a) Two threads competing to start first
	// b) Non-atomic read-modify-write on shared state by multiple threads without synchronization
	// c) A deadlock between two threads
	// d) A thread that runs faster than expected
	// ANSWER: ___

	// Q7: What is the output?
	//   AtomicInteger counter = new AtomicInteger(5);
	//   System.out.println(counter.incrementAndGet());
	// a) 5   b) 6   c) 4   d) compile error
	// ANSWER: ___

	public static void main(String[] args) throws Exception {
		// Q1: c) non-deterministic — parallel stream can process elements in any order
		System.out.println("Q1: c) non-deterministic order");

		// Q2: b) Callable returns Future<V> result and throws checked exceptions
		System.out.println("Q2: b) Callable returns value, throws checked exceptions");

		// Q3: b) AtomicInteger
		System.out.println("Q3: b) AtomicInteger");

		// Q4: b) Virtual thread — lightweight, JVM-managed (Project Loom, Java 21)
		System.out.println("Q4: b) Lightweight JVM-managed thread");

		// Q5: b) finally always runs — lock is released
		System.out.println("Q5: b) finally always runs; lock is released");

		// Q6: b) non-atomic read-modify-write on shared state
		System.out.println("Q6: b) Non-atomic read-modify-write on shared state");

		// Q7 verification
		java.util.concurrent.atomic.AtomicInteger counter = new java.util.concurrent.atomic.AtomicInteger(5);
		System.out.println("Q7: " + counter.incrementAndGet()); // 6 — increments to 6 and returns 6
	}
}
