package acm_club._1;

import java.util.Scanner;

public class Problem1038 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(findNthLeapYear(sc.nextInt(), sc.nextInt()));
		}

	}

	private static int findNthLeapYear(int year, int n) {
		int result = 0;
		while (!isLeapYear(year)) {
			year += 4 - (year % 4);
		}
		for (int i = 1; i < n;i++) {
			do {
				year += 4;
			} while (!isLeapYear(year));
			
		}
		return year;
	}

	private static boolean isLeapYear(int year) {
		if (year % 100 != 0) {
			return year % 4 == 0;
		} else {
			return year % 400 == 0;
		}
	}

}
