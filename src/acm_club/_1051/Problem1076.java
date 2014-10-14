package acm_club._1051;

import java.util.Scanner;

public class Problem1076 {

	private static int getSuitableNumber(int a, int b, int c) {
		for (int i = 1000; i < 10000; i++) {
			if (i % a == 0 && (i + 1) % b == 0 && (i + 2) % c == 0) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int row = sc.nextInt();
			for (int i = 0; i < row; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int result = getSuitableNumber(a, b, c);
				if (result != 0) {
					System.out.println(result);
				} else {
					System.out.println("Impossible");
				}
			}
		}
	}
}
