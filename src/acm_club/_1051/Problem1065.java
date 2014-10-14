package acm_club._1051;

import java.util.Scanner;

public class Problem1065 {

	public static void main(String[] args) {
		int[] result = new int[31];
		result[1] = 1;
		result[2] = 3;
		result[3] = 5;
		for (int i = 4; i < result.length; i++) {
			result[i] = result[i - 1] + 2 * result[i - 2];
		}
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(result[sc.nextInt()]);
		}
		sc.close();
	}
}
