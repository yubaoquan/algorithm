package acm_club._1;

import java.util.Scanner;

public class Problem1022 {

	private static int costTime(int total, int each) {
		int result = 0;
		int times = 1;
		while (total > 0) {
			for (int i = 0; i < times; i++) {
				total -= each;
				result += 1;
				if (total <= 0) {
					return result;
				}
			}
			result += 1;
			times++;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[100000];
		int index = 0;
		while (sc.hasNext()) {
			int total = sc.nextInt();
			int each = sc.nextInt();
			result[index++] = costTime(total, each);
		}
		for (int i = 0; i < index; i++) {
			System.out.println(result[i]);
		}
	}
}
