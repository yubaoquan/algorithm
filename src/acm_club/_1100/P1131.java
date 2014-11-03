package acm_club._1100;

import java.util.Scanner;

public class P1131 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(foo(m, n));
		}
		sc.close();
	}

	private static int foo(int m, int n) {
		if (m <= 1 || n <= 1) {
			return 1;
		}
		if (m < n) {
			return foo(m, m);
		}
		return foo(m, n - 1) + foo(m - n, n);
	}

}
