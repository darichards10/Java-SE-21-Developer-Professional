package se21;

import java.time.*;

public class DateTimeAPI {

	static void examples() {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
	}

	static void localExamples() {
		var time1 = LocalTime.of(6, 15); // hour and minute
		var time2 = LocalTime.of(6, 15, 30); // + seconds
		var time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
		System.out.println(time1 + "\n" + time2 + "\n" + time3);
	}

	static void zonedExamples() {
		var date1 = LocalDate.of(2025, Month.JANUARY, 20);

		var time1 = LocalTime.of(6, 15); // hour and minute
		var time2 = LocalTime.of(6, 15, 30); // + seconds

		var dateTime1 = LocalDateTime.of(2025, Month.JANUARY, 20, 6, 15, 30);

		var zone = ZoneId.of("US/Eastern");
		var zoned1 = ZonedDateTime.of(2025, 1, 20, 6, 15, 30, 200, zone);
		var zoned2 = ZonedDateTime.of(date1, time1, zone);
		var zoned3 = ZonedDateTime.of(dateTime1, zone);

		System.out.println(zoned1 + "\n" + zoned2 + "\n" + zoned3);
	}
	
}
