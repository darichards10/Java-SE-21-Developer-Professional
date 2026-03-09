package se21.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * EXAM TOPIC: Accessing Databases Using JDBC
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~9% of exam
 *
 * Covers:
 * - JDBC URL format: jdbc:<subprotocol>:<subname> (e.g., jdbc:h2:mem:test, jdbc:mysql://host/db)
 * - DriverManager.getConnection(url, user, password): creates a Connection
 * - Connection: represents a session with the database; must be closed
 * - Statement: executes static SQL; executeQuery() for SELECT, executeUpdate() for DML
 * - PreparedStatement: parameterized SQL (? placeholders); prevents SQL injection; pre-compiled
 * - ResultSet: cursor over query results; next() moves to next row; index starts at 1 (not 0)
 * - ResultSet column access: getString(1) or getString("column_name")
 * - Transactions: setAutoCommit(false), commit(), rollback()
 * - Closing resources: close Connection, Statement, ResultSet; use try-with-resources
 * - CallableStatement: calls stored procedures
 * - DatabaseMetaData: information about the database/driver
 * - JDBC exception hierarchy: SQLException — check getMessage(), getSQLState(), getErrorCode()
 *
 * NOTE: To run these examples, add a JDBC driver (e.g., H2) to the classpath.
 *
 * TODO: Add your own runnable examples as you study this topic.
 *       The exam tests: JDBC lifecycle order, PreparedStatement vs Statement,
 *       ResultSet navigation, and transaction control.
 */
public class JDBCExamples {

	// EXAM: typical JDBC lifecycle — get connection → create statement → execute → process results → close
	public static void main(String[] args) {
		queryExample();
		preparedStatementExample();
		transactionExample();
	}

	static void queryExample() {
		String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"; // EXAM: in-memory H2 database URL
		try (Connection conn = DriverManager.getConnection(url); // EXAM: try-with-resources closes Connection
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT id, name FROM users")) { // EXAM: executeQuery() for SELECT

			while (rs.next()) { // EXAM: next() returns false when no more rows; cursor starts before first row
				int id = rs.getInt(1);           // EXAM: column index starts at 1 (not 0)
				String name = rs.getString("name"); // EXAM: can also use column name
				System.out.println(id + ": " + name);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage()); // EXAM: always handle SQLException — it's checked
		}
	}

	static void preparedStatementExample() {
		String url = "jdbc:h2:mem:testdb";
		String sql = "SELECT * FROM users WHERE name = ?"; // EXAM: ? is a placeholder — prevents SQL injection

		try (Connection conn = DriverManager.getConnection(url);
			 PreparedStatement ps = conn.prepareStatement(sql)) { // EXAM: prepareStatement compiles SQL once; reuse with different params

			ps.setString(1, "Alice"); // EXAM: set parameters by 1-based index; must match ? placeholders in order

			try (ResultSet rs = ps.executeQuery()) { // EXAM: executeQuery() returns ResultSet for SELECT
				while (rs.next()) {
					System.out.println(rs.getString("name"));
				}
			}

			// EXAM: reuse PreparedStatement with different parameter
			ps.setString(1, "Bob");
			// ps.executeQuery() again...

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void transactionExample() {
		String url = "jdbc:h2:mem:testdb";

		try (Connection conn = DriverManager.getConnection(url)) {
			conn.setAutoCommit(false); // EXAM: disable auto-commit to start a transaction

			try (PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?")) {
				ps.setBigDecimal(1, java.math.BigDecimal.valueOf(100));
				ps.setInt(2, 1);
				ps.executeUpdate(); // EXAM: executeUpdate() for INSERT/UPDATE/DELETE; returns rows affected

				// ... second operation ...

				conn.commit(); // EXAM: commit makes all changes permanent
			} catch (SQLException e) {
				conn.rollback(); // EXAM: rollback reverts all changes in this transaction
				throw e;
			} finally {
				conn.setAutoCommit(true); // EXAM: restore auto-commit
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
