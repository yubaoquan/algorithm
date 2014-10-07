package acm_club._1;

import java.util.Scanner;

public class Problem1001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = Integer.parseInt(sc.nextLine());
		int[] result = new int[rows];
		for (int i = 0;i < rows;i ++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			result[i] = a + b;
		}
		for (int i = 0; i < rows;i ++) {
			System.out.println(result[i]);
		}
		sc.close();
	}

}
