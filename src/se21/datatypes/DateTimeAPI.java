package se21.datatypes;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * EXAM TOPIC: Handling Date, Time, Text, Numeric and Boolean Values — Date/Time API
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime — all immutable
 * - Creation: now(), of(year, month, day, ...), from()
 * - Month enum: Month.JANUARY (1) through Month.DECEMBER (12)
 * - ZoneId: ZoneId.of("US/Eastern"), ZoneId.systemDefault()
 * - Manipulation: plusDays(), minusMonths(), withYear() — all return new instances (immutable)
 * - DateTimeFormatter: ofPattern(), ISO_LOCAL_DATE, ISO_DATE_TIME
 * - Period vs Duration: Period = date-based (years/months/days); Duration = time-based (hours/minutes/seconds)
 * - ChronoUnit: for measuring time between two temporal objects
 */
public class DateTimeAPI {

	public static void examples() {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
	}

	static void localExamples() {
		var time1 = LocalTime.of(6, 15);         // hour and minute
		var time2 = LocalTime.of(6, 15, 30);     // + seconds
		var time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
		System.out.println(time1 + "\n" + time2 + "\n" + time3);
	}

	static void zonedExamples() {
		var date1 = LocalDate.of(2025, Month.JANUARY, 20);

		var time1 = LocalTime.of(6, 15);
		var time2 = LocalTime.of(6, 15, 30);

		var dateTime1 = LocalDateTime.of(2025, Month.JANUARY, 20, 6, 15, 30);

		var zone = ZoneId.of("US/Eastern");
		var zoned1 = ZonedDateTime.of(2025, 1, 20, 6, 15, 30, 200, zone);
		var zoned2 = ZonedDateTime.of(date1, time1, zone);
		var zoned3 = ZonedDateTime.of(dateTime1, zone);

		System.out.println(zoned1 + "\n" + zoned2 + "\n" + zoned3);
	}

	static void formattingExamples() {
		LocalDate date = LocalDate.of(2025, Month.MARCH, 15);
		// EXAM: DateTimeFormatter is immutable; format() returns a String
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(date.format(formatter)); // 03/15/2025

		// EXAM: parse() creates a LocalDate from a String using the same formatter
		LocalDate parsed = LocalDate.parse("03/15/2025", formatter);
		System.out.println(parsed); // 2025-03-15
	}

	static void periodAndDuration() {
		// EXAM: Period is date-based (years, months, days)
		Period twoWeeks = Period.ofWeeks(2);
		LocalDate start = LocalDate.of(2025, 1, 1);
		System.out.println(start.plus(twoWeeks)); // 2025-01-15

		// EXAM: Duration is time-based (hours, minutes, seconds, nanos)
		Duration twoHours = Duration.ofHours(2);
		LocalTime time = LocalTime.of(10, 0);
		System.out.println(time.plus(twoHours)); // 12:00
	}
}
