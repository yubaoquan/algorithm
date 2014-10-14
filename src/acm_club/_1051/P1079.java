package acm_club._1051;

import java.util.Scanner;

public class P1079 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		while (row-- != 0) {
			System.out.println(findNewFriends(sc.nextInt()));
		}
		sc.close();
	}

	private static int findNewFriends(int n) {
		int result = n;
		// 类似分解因式的逻辑
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				result = result / i * (i - 1);
				while (n % i == 0) {
					n /= i;
				}
			}
		}
		if (n != 1) {
			result = result / n * (n - 1);
		}
		return result;
	}

}
