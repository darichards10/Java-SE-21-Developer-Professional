package se21.streams;

/**
 * EXAM TOPIC: Streams API — Supporting Classes
 * Oracle Java SE 21 Developer Professional (1Z0-830)
 *
 * Covers:
 * - Plain class used as a stream data source (element type in Stream&lt;Person&gt;)
 * - Getter methods enable method references (Person::getAddress) in stream pipelines
 * - Null-safe chaining via Optional.ofNullable(person).map(Person::getAddress)
 * - Demonstrates the pattern of chained Optional.map() calls for deep field access
 */
public class Person {

	public Address getAddress() { // EXAM: getter enables method reference Person::getAddress inside Optional.map() or stream().map()
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	Address address; // EXAM: field may be null — models real-world Optional.ofNullable() use case for null-safe stream chaining

}
