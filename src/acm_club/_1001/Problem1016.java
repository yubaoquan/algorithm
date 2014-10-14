package acm_club._1001;

import java.util.Scanner;

public class Problem1016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0;i < row; i ++ ) {
			double principle = sc.nextDouble();
			int savedDays = sc.nextInt();
			double currentInterestRate = sc.nextDouble();
			double regularRate = sc.nextDouble();
			double newRegularRate = sc.nextDouble();
			double result1 = principle * (1 + currentInterestRate / 100 * savedDays /365) * (1 + newRegularRate / 100);
			double result2 = principle * (1 + regularRate / 100 * ( savedDays + 365) / 365);
			sb.append(String.format("%.1f\n", result1));
			sb.append(String.format("%.1f\n", result2));
		}
		System.out.println(sb);
	}

}
