package se21;

import java.time.*;

/**
 * EXAM TOPIC: Working with Java Date/Time API
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - LocalDate, LocalTime, LocalDateTime: no timezone information
 * - ZonedDateTime: includes timezone offset and zone ID
 * - Immutability of all java.time objects (operations return new instances)
 * - Factory methods: now() and of() — constructors are not public
 * - ZoneId.of() for specifying time zones by region name
 * - Multiple overloads of of() for building date/time with varying precision
 */
public class DateTimeAPI {

	static void examples() {
		System.out.println(LocalDate.now()); // EXAM: LocalDate has date only (year, month, day) — no time, no timezone
		System.out.println(LocalTime.now()); // EXAM: LocalTime has time only — no date, no timezone
		System.out.println(LocalDateTime.now()); // EXAM: LocalDateTime combines date + time — still no timezone
		System.out.println(ZonedDateTime.now()); // EXAM: ZonedDateTime adds timezone info; use when timezone matters
	}

	static void localExamples() {
		var time1 = LocalTime.of(6, 15); // hour and minute // EXAM: all java.time types use static factory methods (of/now), not new
		var time2 = LocalTime.of(6, 15, 30); // + seconds    // EXAM: of() is overloaded; extra precision is optional
		var time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds // EXAM: finest granularity is nanoseconds
		System.out.println(time1 + "\n" + time2 + "\n" + time3);
	}

	static void zonedExamples() {
		var date1 = LocalDate.of(2025, Month.JANUARY, 20); // EXAM: can use Month enum or int (1-12) for month parameter

		var time1 = LocalTime.of(6, 15); // hour and minute
		var time2 = LocalTime.of(6, 15, 30); // + seconds

		var dateTime1 = LocalDateTime.of(2025, Month.JANUARY, 20, 6, 15, 30); // EXAM: LocalDateTime.of() combines date and time components inline

		var zone = ZoneId.of("US/Eastern"); // EXAM: ZoneId.of() accepts region-based IDs like "US/Eastern" or "America/New_York"
		var zoned1 = ZonedDateTime.of(2025, 1, 20, 6, 15, 30, 200, zone); // EXAM: ZonedDateTime.of() has multiple overloads; zone is always the last argument
		var zoned2 = ZonedDateTime.of(date1, time1, zone); // EXAM: can compose from existing LocalDate + LocalTime + ZoneId
		var zoned3 = ZonedDateTime.of(dateTime1, zone); // EXAM: can compose from existing LocalDateTime + ZoneId

		System.out.println(zoned1 + "\n" + zoned2 + "\n" + zoned3);
	}

}
