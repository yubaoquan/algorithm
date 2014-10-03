package acm_club._51;

import java.util.Scanner;

public class Problem1077 {

	private static int[] beautifulNumbers =  new int[100001];
	static {
		int index = 1;
		int t = 1;
		while (index < beautifulNumbers.length) {
			if (t % 3 == 0 || t % 5 == 0) {
				beautifulNumbers[index] = t;
				index++;
			}
			t ++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(beautifulNumbers[n]);
		}
	}
}
