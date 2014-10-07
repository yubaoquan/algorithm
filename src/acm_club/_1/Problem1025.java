package acm_club._1;

import java.util.Scanner;

public class Problem1025 {

	/**
	 * 
	 * @author yubaoquan
	 * @Description
	 * @param n
	 *            number of coins
	 * @param m
	 *            how much of these coins
	 * @return
	 */
	private static int kind(int n, int m) {
		int count = 0;
		int remain;
		for (int i = 0; i <= n; i++) {
			if (5 * i > m) {
				break;
			}
			remain = m - 5 * i;
			for (int j = 0; j <= n - i; j++) {
				if (2 * j > remain) {
					break;
				}
				int k = remain - 2 * j;
				if (i + j + k == n) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int[] result = new int[row];
		for (int i = 0; i < row; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			result[i] = kind(n, m);
		}

		for (int i = 0; i < row; i++) {
			System.out.println(result[i]);
		}
		sc.close();
	}
}
