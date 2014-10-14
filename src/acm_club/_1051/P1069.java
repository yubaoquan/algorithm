package acm_club._1051;

import java.util.Scanner;

public class P1069 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(foo(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();

	}

	private static String foo(int a, int b, int c) {
		if (a == b || b == c || a == c) {
			return "perfect";
		}
		int t = a;
		if (b > a) {
			a = b;
			b = t;
		}
		if (c > a) {
			t = a;
			a = c;
			c = t;
		}
		int a2 = a * a;
		int b2 = b * b;
		int c2 = c * c;
		if (a2 == b2 + c2) {
			return "good";
		}
		return "just a triangle";
	}
}
