package acm_club._51;

import java.util.Scanner;

public class P1064 {

	private static int[] result = new int[20];
	static {
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i < result.length; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(result[sc.nextInt()]);
		}
		sc.close();
	}

}
