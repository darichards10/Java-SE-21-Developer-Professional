package se21.functional;

/**
 * EXAM TOPIC: Streams API — Supporting Classes
 * Oracle Java SE 21 Developer Professional (1Z0-830) — ~17% of exam
 *
 * Covers:
 * - Nested object used to demonstrate chained Optional.map() calls
 * - Getter enables method reference Address::getCity inside Optional.map()
 * - Models the pattern: Optional.ofNullable(person)
 *     .map(Person::getAddress)   — Optional<Address>
 *     .map(Address::getCity)     — Optional<String>
 *     .map(String::toUpperCase)  — Optional<String>
 * - Each map() call safely short-circuits if the Optional is empty
 */
public class Address {

	String city; // EXAM: field accessed via getter; may be null — each chained Optional.map() guards against NPE

	public String getCity() { // EXAM: getter enables method reference Address::getCity in Optional.map() chain
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
