package acm_club._1051;

import java.util.Scanner;

public class P1059 {

	private static int[] solutions = new int[31];
	static {
		solutions[1] = 1;
		solutions[2] = 3;
		for (int i = 3;i < solutions.length;i++) {
			solutions[i] = solutions[i - 1] + 2 * solutions[i - 2];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0;i < row;i++) {
			System.out.println(solutions[sc.nextInt()]);
		}
		sc.close();
	}

}
