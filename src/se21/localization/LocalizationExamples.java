package se21.localization;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * EXAM TOPIC: Implementing Localization
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Covers:
 * - Locale: represents a specific geographical/political/cultural region
 *     Creation: Locale.US, Locale.FRANCE, new Locale("en", "US"), Locale.of("fr", "FR") (Java 19+)
 * - ResourceBundle: externalized strings; loaded by locale; falls back to default locale
 *     ResourceBundle.getBundle("messages") — looks for messages_en_US.properties, messages_en.properties, messages.properties
 * - NumberFormat: currency, percent, number formatting by locale
 *     NumberFormat.getCurrencyInstance(Locale.US), NumberFormat.getPercentInstance()
 * - DateTimeFormatter with locale: DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE)
 * - String.format() vs formatted(): locale-aware number formatting with %,d or %f
 * - Charset / encoding: StandardCharsets.UTF_8, InputStreamReader with charset
 * - MessageFormat: parameterized messages with placeholders {0}, {1}
 *
 * TODO: Add your own runnable examples as you study this topic.
 *       The exam tests: ResourceBundle fallback order, Locale creation,
 *       NumberFormat/DateTimeFormatter with locale, property file naming.
 */
public class LocalizationExamples {

	public static void main(String[] args) {
		localeCreation();
		numberFormatting();
		dateFormatting();
		resourceBundleExample();
	}

	static void localeCreation() {
		// EXAM: common Locale constants
		System.out.println(Locale.US);      // en_US
		System.out.println(Locale.FRANCE);  // fr_FR
		System.out.println(Locale.getDefault()); // JVM default locale

		// EXAM: programmatic creation
		Locale usLocale = new Locale("en", "US");      // deprecated in Java 19, still tested
		Locale frLocale = Locale.of("fr", "FR");        // Java 19+ factory method
		System.out.println(usLocale.getLanguage());     // en
		System.out.println(frLocale.getCountry());      // FR
	}

	static void numberFormatting() {
		double amount = 1234567.89;

		// EXAM: currency formatting varies by locale
		NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat euCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println(usCurrency.format(amount));   // $1,234,567.89
		System.out.println(euCurrency.format(amount));   // 1 234 567,89 €

		// EXAM: percent formatting
		NumberFormat percent = NumberFormat.getPercentInstance(Locale.US);
		System.out.println(percent.format(0.5));  // 50%

		// EXAM: parse() converts a formatted String back to a Number
		try {
			Number parsed = usCurrency.parse("$1,234.00");
			System.out.println(parsed); // 1234.0
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	static void dateFormatting() {
		LocalDate date = LocalDate.of(2025, 3, 15);

		// EXAM: locale-aware date formatting with FormatStyle
		DateTimeFormatter fullUs = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
		DateTimeFormatter shortFr = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.FRANCE);

		System.out.println(date.format(fullUs));   // Saturday, March 15, 2025
		System.out.println(date.format(shortFr));  // 15/03/2025
	}

	static void resourceBundleExample() {
		// EXAM: ResourceBundle.getBundle looks for: messages_en_US.properties → messages_en.properties → messages.properties
		// For this to run, create src/messages.properties with key=value pairs
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.US);
			// System.out.println(bundle.getString("greeting")); // value from properties file
		} catch (java.util.MissingResourceException e) {
			System.out.println("Resource bundle not found: " + e.getMessage());
			// TODO: Create src/messages.properties with: greeting=Hello
		}
	}
}
