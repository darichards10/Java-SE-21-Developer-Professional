package se21;

public class Methods {
	final int age = 10;
	final int fishEaten;
	final String name;

	{
		fishEaten = 10;
	}

	public Methods() {
		name = "Robert";
		int num = 1;
		newNumber(3);
		String txt = """
				nums = %d
				""".formatted(num);
		
		System.out.println(txt);
	}

	public void bike1() {
	}

	public final void bike2() {
	}

	public static final void bike3() {
	}

	public final static void bike4() {
	}

	final public void bike7() {
	}

	native void example();

	public void Jog_$() {
	}

	static void zooAnimalCheckup(boolean isWeekend) {
		final int rest;
		if (isWeekend)
			rest = 5;
		else
			rest = 20;
		System.out.println(rest);
	}

	static void walk(int step, int... steps) {
		System.out.println(steps.length);
	}
	

	static void newNumber(int num) {
		num = 2;
	}
	
	
	static String glide(String s) {
		return "1";
	}
	
	static String glide(String... s) {
		return "2";
	}
	
	static String glide(String s, String t) {
		return "3";
	}
	
	static String glide(Object s) {
		return "4";
	}
}
