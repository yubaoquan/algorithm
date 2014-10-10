package acm_club._51;

import java.util.Scanner;

public class P1073 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.format("2^%s mod %s = 1\n", foo(n), n);
		}
		sc.close();
	}

	private static String foo(int input) {
		if (input % 2 == 0 || input == 1) {
			return "?";
		}
		for (int x = 1; x < Integer.MAX_VALUE; x++) {
			if (Math.pow(2, x) % input == 1) {
				return String.valueOf(x);
			}
		}
		return "?";
	}

}
