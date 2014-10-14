package acm_club._1001;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1014 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer resultSB = new StringBuffer();
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int[] states = new int[n];
			int statesNumberNeeded = 0;
			if (n % 2 == 0) {
				statesNumberNeeded = n / 2 + 1;
			} else {
				statesNumberNeeded = (n + 1) / 2;
			}
			for (int i = 0; i < n; i++) {
				states[i] = sc.nextInt();
			}
			Arrays.sort(states);
			int result = 0;
			for (int i = 0; i < statesNumberNeeded; i++) {
				if (states[i] % 2 == 0) {
					result += states[i] / 2 + 1;
				} else {
					result += (states[i] + 1) / 2;
				}
			}
			resultSB.append(result);
			resultSB.append("\n");
		}
		System.out.println(resultSB);
	}
}
