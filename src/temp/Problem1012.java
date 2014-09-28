package temp;

import java.util.Scanner;

public class Problem1012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		double biggestExchangeRate = 0.0;
		for (int i = 0; i < 12; i++) {
			double rate = sc.nextDouble();
			if (rate > biggestExchangeRate) {
				biggestExchangeRate = rate;
			}
		}
		String result = String.format("%.2f", money * biggestExchangeRate);
		System.out.println(result);
	}
}
