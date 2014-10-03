package acm_club._1;

import java.util.Scanner;

public class Problem1030 {

	private static final String YEAR_TITLE_TEMPLATE = "                              XXXX                              ";
	private static final String[] MONTH_TITLE = {
			"      January               February               March        ",
			"       April                  May                   June        ",
			"        July                 August              September      ",
			"      October               November              December      "
	};
	private static final String WEEK_TITLE = "Su Mo Tu We Th Fr Sa  Su Mo Tu We Th Fr Sa  Su Mo Tu We Th Fr Sa";
	private static final int MONTH_PER_YEAR = 12;
	private static final int DAYS_PER_WEEK = 7;
	private static final int LINE_PER_MONTH = 6;
	private static int[] daysPerMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
			31, 30, 31 };
	private static final int WEEK_DAY_OF_18000101 = 3;

	private static String[][][] calendar = new String[MONTH_PER_YEAR][LINE_PER_MONTH][DAYS_PER_WEEK];

	private static void reFreshCalendar() {
		for (int month = 0; month < MONTH_PER_YEAR; month++) {
			for (int line = 0; line < LINE_PER_MONTH; line++) {
				for (int day = 0; day < DAYS_PER_WEEK; day++) {
					calendar[month][line][day] = "  ";
				}
			}
		}
	}

	private static boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			return year % 400 == 0;
		}
		return year % 4 == 0;
	}

	private static void makeCalendar(int beginDate, boolean isLeakYear) {
		reFreshCalendar();
		if (isLeakYear) {
			daysPerMonth[1] = 29;
		} else {
			daysPerMonth[1] = 28;
		}
		for (int month = 0; month < MONTH_PER_YEAR; month++) {
			boolean monthIncrease = false;
			for (int line = 0; !monthIncrease && line < LINE_PER_MONTH; line++) {
				for (int day = 0; day < DAYS_PER_WEEK; day++) {
					int number = day + 7 * line - beginDate;
					if (number < 0) {
						continue;
					}
					if (number >= daysPerMonth[month]) {
						beginDate = day;
						monthIncrease = true;
						break;
					} else {
						calendar[month][line][day] = String.format("%2d",
								number + 1);
					}
				}
			}
		}
	}

	private static void makeCalendar(int year) {
		int beginDate = 0;
		boolean leak = isLeapYear(year);
		int daysPast = 0;
		for (int i = 1800; i < year; i++) {
			daysPast += 365;
			if (isLeapYear(i)) {
				daysPast += 1;
			}
		}
		beginDate = (WEEK_DAY_OF_18000101 + daysPast) % 7;
		makeCalendar(beginDate, leak);
	}

	private static String showCalendar(int year) {
		StringBuffer sb = new StringBuffer();
		makeCalendar(year);
		String yearTitle = YEAR_TITLE_TEMPLATE.replace("XXXX",
				String.valueOf(year));
		sb.append(yearTitle);
		sb.append("\n\n");

		for (int i = 0; i < 4; i++) {
			sb.append(MONTH_TITLE[i]).append("\n");
			sb.append(WEEK_TITLE).append("\n");
			for (int line = 0; line < LINE_PER_MONTH; line++) {
				for (int col = 0; col < 3; col++) {
					for (int day = 0; day < DAYS_PER_WEEK; day++) {
						sb.append(calendar[i * 3 + col][line][day]);
						if (day != 6) {
							sb.append(" ");
						}
					}
					if (col != 2) {
						sb.append("  ");
					}
				}
				sb.append("\n");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int year = sc.nextInt();
			System.out.println(showCalendar(year));
		}
	}
}
