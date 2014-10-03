package acm_club._1;

import java.util.Scanner;

public class Problem1024 {

	private static int period(int m, int k) {
		int result = m;
		while (m >= k) {
			m -= k;
			m += 1;
			result += 1;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10000];
		int index = 0;
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			if (m == 0 && k == 0) {
				break;
			}
			result[index++] = period(m, k);
		}
		for (int i = 0; i < index; i++) {
			System.out.println(result[i]);
		}

	}

}
