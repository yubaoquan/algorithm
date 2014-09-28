package temp;

import java.util.Scanner;

public class Problem1013 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer resultSB = new StringBuffer();
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int sum = 0;
			int[] blocks = new int[n];
			for (int i = 0; i < n; i++) {
				blocks[i] = sc.nextInt();
				sum += blocks[i];
			}
			int averageHeight = sum / n;
			int result = 0;

			for (int i = 0; i < n; i++) {
				if (blocks[i] > averageHeight) {
					result += blocks[i] - averageHeight;
				}
			}
			resultSB.append(result);
			resultSB.append("\n\n");
		}
		System.out.println(resultSB);
	}

}
