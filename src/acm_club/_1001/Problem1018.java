package acm_club._1001;

import java.util.Scanner;

public class Problem1018 {

	private static int evenSum(String number) {
		int sum = 0;
		for (int i = 0;i < number.length();i ++) {
			int t = number.charAt(i) - '0';
			if (t % 2 == 0) {
				sum += t;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		while (sc.hasNext()) {
			String number = sc.nextLine();
			sb.append(evenSum(number));
			sb.append("\n\n");
		}
		System.out.print(sb);
	}
}
