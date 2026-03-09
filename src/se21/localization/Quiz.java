package se21.localization;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * SELF-TEST: Implementing Localization
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~8% of exam
 *
 * Directions: Read each question, write your answer in the ANSWER field,
 * then run main() to verify. Cover the answers before looking!
 */
public class Quiz {

	// Q1: What is the ResourceBundle lookup order for Locale("en", "US") with base name "msg"?
	// a) msg_en_US → msg_en → msg   b) msg → msg_en → msg_en_US
	// c) msg_en_US only             d) msg_US → msg_en → msg
	// ANSWER: ___

	// Q2: What does NumberFormat.getCurrencyInstance(Locale.US).format(1234.5) output?
	// a) "1234.50"   b) "$1,234.50"   c) "USD 1234.50"   d) "1,234.50 USD"
	// ANSWER: ___

	// Q3: What is Locale.getDefault() based on?
	// a) The database locale   b) The JVM or OS locale   c) Always Locale.US   d) The first locale created
	// ANSWER: ___

	// Q4: How do you create a Locale for French (France)?
	// a) new Locale("france")           b) Locale.of("fr", "FR") or new Locale("fr", "FR")
	// c) Locale.FRENCH                  d) Locale.FRANCE only
	// ANSWER: ___

	// Q5: What is the purpose of ResourceBundle?
	// a) Packaging Java modules   b) Externalizing locale-specific strings/data for internationalization
	// c) Converting between charsets   d) Formatting numbers and dates
	// ANSWER: ___

	// Q6: What format style gives the shortest date output in DateTimeFormatter.ofLocalizedDate()?
	// a) FULL   b) LONG   c) MEDIUM   d) SHORT
	// ANSWER: ___

	// Q7: What does Locale.FRANCE.getLanguage() return?
	// a) "FRANCE"   b) "fr"   c) "FR"   d) "french"
	// ANSWER: ___

	public static void main(String[] args) throws Exception {
		// Q1: a) most-specific first: msg_en_US.properties → msg_en.properties → msg.properties
		System.out.println("Q1: a) msg_en_US → msg_en → msg (most specific first)");

		// Q2: b) "$1,234.50"
		System.out.println("Q2: " + NumberFormat.getCurrencyInstance(Locale.US).format(1234.5)); // $1,234.50

		// Q3: b) JVM/OS locale — set at JVM startup; can change with Locale.setDefault()
		System.out.println("Q3: b) JVM/OS locale: " + Locale.getDefault());

		// Q4: b) both Locale.of("fr","FR") and new Locale("fr","FR") work; Locale.FRANCE is a constant
		System.out.println("Q4: b) Locale.of(\"fr\",\"FR\") or new Locale(\"fr\",\"FR\") or Locale.FRANCE");

		// Q5: b) Externalizing locale-specific strings for i18n/l10n
		System.out.println("Q5: b) Externalizes locale-specific strings");

		// Q6: d) SHORT gives briefest format, e.g. 3/15/25
		System.out.println("Q6: d) SHORT — briefest format");

		// Q7: b) "fr" — getLanguage() returns the ISO 639 two-letter language code
		System.out.println("Q7: " + Locale.FRANCE.getLanguage()); // fr
	}
}
