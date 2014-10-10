package acm_club._51;

import java.util.Scanner;

public class P1078 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = 1;
		while (true) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (m + n == 0) {
				break;
			}
			System.out.format("Case %d: %d\n", time, foo(m, n));
			time++;
		}
		sc.close();
	}

	private static int foo(int m, int n) {
		int result = 0;
		for (int b = 1; b < n; b++) {
			for (int a = 1; a < b; a++) {
				if ((a * a + b * b + m) % (a * b) == 0) {
					result++;
				}
			}
		}

		return result;
	}

}
