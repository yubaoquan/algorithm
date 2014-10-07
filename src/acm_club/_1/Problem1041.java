package acm_club._1;

import java.util.Scanner;

public class Problem1041 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(exchange(sc.nextLine()));
		}
		sc.close();
	}

	private static char[] exchange(String nextLine) {
		char[] result = nextLine.toCharArray();
		for (int i = 0; i < result.length - 1; i += 2) {
			char t = result[i];
			result[i] = result[i + 1];
			result[i + 1] = t;
		}
		return result;
	}

}
