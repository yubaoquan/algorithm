package acm_club._1001;

import java.util.Scanner;

public class Problem1042 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(change(sc.nextLine()));
		}
		sc.close();
	}

	private static char[] change(String input) {
		char[] result = input.toLowerCase().toCharArray();
		for (int i = 0; i < result.length; i++) {
			if (isAEIOU(result[i])) {
				result[i] -= 32;
			}
		}
		return result;
	}

	private static boolean isAEIOU(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
