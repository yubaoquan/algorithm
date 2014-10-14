package acm_club._1051;

import java.util.Scanner;

public class P1074 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(cNM(sc.nextInt(), sc.nextInt()));
		}
		sc.close();
	}

	private static long cNM(int n, int m) {
		if (n < m) {
			return 0;
		}
		long devisor = 1;
		long devidend = 1;
		int loopTime = Math.min(n - m, m);
		for (int i = 0; i < loopTime; i++) {
			devidend *= n - i;
			devisor *= i + 1;
		}
		return devidend / devisor;
	}
}
