package acm_club._1051;

import java.util.Scanner;

public class Problem1060 {

	private static int[] array = new int[21];
	static {
		array[1] = 3;
		array[2] = 7;
		for (int i = 3; i < array.length; i++) {
			array[i] = array[i - 1] * 2 + array[i - 2];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(array[sc.nextInt()]);
		}
		sc.close();
	}
}
