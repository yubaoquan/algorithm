package acm_club._1001;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1036 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			char basicUnit = line.charAt(0);
			if (basicUnit == '@') {
				break;
			}
			int n = Integer.parseInt(line.substring(2));
			System.out.println(draw(n,basicUnit));
			
		}
	}

	private static String draw(int n, char basicUnit) {
		StringBuffer sb = new StringBuffer();
		char[][] result = new char[n][];
		for (int i = 0;i < n - 1;i++) {
			result[i] = new char[i + n];
			Arrays.fill(result[i], ' ');
			result[i][n - 1 + i] = basicUnit;
			result[i][n - 1 - i] = basicUnit;
			sb.append(result[i]);
			sb.append("\n");
		}
		result[n - 1] = new char[2 * n - 1];
		Arrays.fill(result[n - 1], basicUnit);
		sb.append(result[n - 1]).append("\n");
		return sb.toString();
	}
}
