package acm_club._1001;

import java.util.Scanner;

public class Problem1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			String[] birthday = sc.nextLine().split("-");
			int year = Integer.parseInt(birthday[0]);
			int month = Integer.parseInt(birthday[1]);
			int day = Integer.parseInt(birthday[2]);

			System.out.println(daysPassed(year, month, day));
		}

	}

	private static int daysPassed(int year, int month, int day) {
		int result = 0;
		if (month == 2 && day == 29) {
			if (!isLeapYear(year + 18)) {
				return -1;
			} else {
				for (int i = 1; i <= 18; i++) {
					result += 365;
					if (isLeapYear(year + i)) {
						result += 1;
					}
				}
			}
		} else {
			if (month <= 2) {
				for (int i = 0; i < 18; i++) {
					result += 365;
					if (isLeapYear(year + i)) {
						result += 1;
					}
				}
			} else {
				for (int i = 1; i <= 18; i++) {
					result += 365;
					if (isLeapYear(year + i)) {
						result += 1;
					}
				}
			}

		}
		return result;
	}

	private static boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			return year % 400 == 0;
		}
		return year % 4 == 0;
	}

}
