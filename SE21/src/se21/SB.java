package se21;

public class SB {

	static void objectExample() {
		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a.append("de");
		b = b.append("f").append("g");
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}

	static void commonMethods() {
		var sb = new StringBuilder("animals");
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
		int len = sb.length();
		char ch = sb.charAt(6);
		System.out.println(sub + " " + len + " " + ch);
	}

	static void append() {
		var sb = new StringBuilder().appendCodePoint(87).append(',').append((char) 87).append(',').append(87)
				.append(',').appendCodePoint(8217);
		System.out.println(sb);
	}

	static void equality() {
		var one = new StringBuilder();
		var two = new StringBuilder();
		var three = one.append("a");
		System.out.println(one == two); // false
		System.out.println(one == three); // true
	}

	static void compilationEquality() {
		var first = "rat" + 1;
		var second = "r" + "a" + "t" + "1";
		var third = "r" + "a" + "t" + new String("1");
		System.out.println(first == second);
		System.out.println(first == second.intern());
		System.out.println(first == third);
		System.out.println(first == third.intern());
	}
}
