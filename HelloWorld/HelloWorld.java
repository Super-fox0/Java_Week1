package javaWork;
public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("Hello World");

		String task1 = "Hello World MK2";
		System.out.println(task1);

		hello("hello world MK3");

		System.out.println(hello2());

		System.out.println(hello3(1, 2));

		System.out.println(hello4(true, 2, 3));
		System.out.println(hello4(false, 3, 3));

		System.out.println(hello5(1, 0));
		System.out.println(hello5(1, 2));

		hello6(2, 2);

		hello7();

		hello8();

		hello9();

		System.out.println(blackjack(2, 22));

		System.out.println(uniqueSum(1, 1, 1));

		System.out.println(tooHot(50, false));
		System.out.println(tooHot(100, false));
		System.out.println(tooHot(50, true));
		System.out.println(tooHot(100, true));
		System.out.println(tooHot(30, true));
		System.out.println(tooHot(20, true));
	}

	public static void hello(String t1) {
		System.out.println(t1);
	}

	public static String hello2() {
		return "hello World MK4";
	}

	public static int hello3(int x, int y) {
		int z = x + y;
		return z;

	}

	public static int hello4(boolean a, int x, int y) {
		if (a == true) {
			int z = x + y;
			return z;
		} else {
			int z = x * y;
			return z;
		}
	}

	public static int hello5(int x, int y) {
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		} else {
			int z = x + y;
			return z;
		}
	}

	public static void hello6(int a, int b)

	{
		int counter = 1;
		for (int x = 0; x < 10; x++) {
			System.out.println(counter + " " + hello5(a, b));
			counter++;
		}
	}

	static int x[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void hello7() {

		for (int i = 0; i < x.length; i++) {
			System.out.println(hello5(x[i], x[i]));
		}
	}

	public static void hello8() {
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}

	public static void hello9() {
		System.out.println("xxx");
		int[] array1 = new int[10];
		String numberlist = "";

		for (int i = 0; i < 10; i++) {
			array1[i] = i;
			numberlist = numberlist + array1[i] + ",";
		}

		System.out.println(numberlist);
		numberlist = "";

		for (int i = 0; i < 10; i++) {
			array1[i] = i * 10;
			numberlist = numberlist + array1[i] + ",";
		}

		System.out.println(numberlist);
	}

	public static int blackjack(int x, int y) {
		if (x > 21 && y <= 21) {
			return y;
		} else if (y > 21 && x <= 21) {
			return x;
		} else if (x > y && x <= 21) {
			return x;
		} else if (y > x && y <= 21) {
			return y;
		} else {
			return 0;
		}
	}

	public static int uniqueSum(int x, int y, int z) {
		int v1 = x;
		int v2 = y;
		int v3 = z;
		if (x == y || x == z) {
			v1 = 0;
		}
		if (y == z || y == x) {
			v2 = 0;
		}
		if (z == x || z == y) {
			v3 = 0;
		}
		return v1 + v2 + v3;
	}

	public static boolean tooHot(int temperature, boolean isSummer) {
		if (temperature <= 90 && temperature >= 30 && isSummer == false) {
			return true;
		} else if (temperature <= 100 && temperature >= 30 && isSummer == true) {
			return true;
		} else {
			return false;
		}

	}

}
