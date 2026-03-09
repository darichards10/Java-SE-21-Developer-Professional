package se21.jdbc;

/**
 * SELF-TEST: Accessing Databases Using JDBC
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~9% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is the correct order of JDBC operations?
	// a) Statement → Connection → ResultSet → close
	// b) Connection → Statement → ResultSet → close
	// c) ResultSet → Statement → Connection → close
	// d) DriverManager → Statement → Connection → ResultSet
	// ANSWER: ___

	// Q2: What method is used for SELECT statements?
	// a) executeUpdate()   b) execute()   c) executeQuery()   d) executeSelect()
	// ANSWER: ___

	// Q3: What is the first column index in a ResultSet?
	// a) 0   b) 1   c) -1   d) depends on the database
	// ANSWER: ___

	// Q4: What is the primary benefit of PreparedStatement over Statement?
	// a) Faster compilation   b) Prevents SQL injection and is pre-compiled for reuse
	// c) Works without a database connection   d) Returns ResultSet objects automatically
	// ANSWER: ___

	// Q5: What does ResultSet.next() return when there are no more rows?
	// a) null   b) -1   c) false   d) throws SQLException
	// ANSWER: ___

	// Q6: How do you start a transaction in JDBC?
	// a) connection.beginTransaction()   b) connection.setAutoCommit(false)
	// c) connection.startTransaction()   d) Transactions start automatically
	// ANSWER: ___

	// Q7: If close() throws a SQLException during try-with-resources, what happens?
	// a) It replaces the body exception   b) It is added as a suppressed exception on the body exception
	// c) It is silently ignored   d) The program crashes
	// ANSWER: ___

	// Q8: Which exception do all JDBC exceptions extend?
	// a) RuntimeException   b) IOException   c) SQLException   d) JdbcException
	// ANSWER: ___

	public static void main(String[] args) {
		// Q1: b) Connection → Statement → ResultSet → close
		System.out.println("Q1: b) Connection → Statement → ResultSet → close");

		// Q2: c) executeQuery() returns ResultSet; executeUpdate() returns int (rows affected)
		System.out.println("Q2: c) executeQuery() for SELECT");

		// Q3: b) 1 — JDBC ResultSet columns are 1-indexed (unlike arrays)
		System.out.println("Q3: b) 1 — JDBC columns start at index 1");

		// Q4: b) PreparedStatement prevents SQL injection and is pre-compiled
		System.out.println("Q4: b) Prevents SQL injection; pre-compiled for reuse");

		// Q5: c) false — next() returns boolean; false when no more rows
		System.out.println("Q5: c) false");

		// Q6: b) connection.setAutoCommit(false)
		System.out.println("Q6: b) connection.setAutoCommit(false)");

		// Q7: b) Added as suppressed exception (standard try-with-resources behavior)
		System.out.println("Q7: b) Added as suppressed exception");

		// Q8: c) SQLException — all JDBC exceptions extend SQLException (checked)
		System.out.println("Q8: c) SQLException");
	}
}
