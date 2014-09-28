package acm_club;

import java.util.Scanner;

public class Problem1009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0.0;
		for (int i = 0; i < 12; i ++) {
			sum += sc.nextDouble();
		}
		double result = sum / 12.0;
		String resultStr = String.format("￥%.2f", result);
		System.out.println(resultStr);
	}
}
