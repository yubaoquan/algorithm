package acm_club;

import java.util.Scanner;

public class Problem1031 {

	private static final int ANGLE_PER_HOUR = 30;
	private static final int ANGLE_PER_MINUTE = 6;

	private static int passedTimes(int oldHour, int oldMinute, int newHour,
			int newMinute) {
		double oldHourAngle = oldHour * ANGLE_PER_HOUR + oldMinute / 2.0;
		double newHourAngle = newHour * ANGLE_PER_HOUR + newMinute / 2.0;
		oldHourAngle = oldHourAngle < 360 ? oldHourAngle : oldHourAngle - 360;
		newHourAngle = newHourAngle < 360 ? newHourAngle : newHourAngle - 360;

		int oldMinuteAngle = oldMinute * ANGLE_PER_MINUTE;
		int newMinuteAngle = newMinute * ANGLE_PER_MINUTE;

		if (oldHour == newHour) {
			if (oldMinute < newMinute) {
				if (oldMinuteAngle < oldHourAngle
						&& newMinuteAngle > newHourAngle) {
					return 1;
				} else {
					return 0;
				}
			} else if (oldMinute > newMinute) {
				return 11 - passedTimes(oldHour, newMinute, oldHour, oldMinute);
			} else {
				return 0;
			}
		}

		int result = newHour - oldHour;
		result = result > 0 ? result : result + 11;
		return -passedTimes(oldHour, 0, oldHour, oldMinute) + result
				+ passedTimes(newHour, 0, newHour, newMinute);
	}

	private static String makeTimeString(int hour, int minute) {
		String hourPart = String.valueOf(hour) + ":";
		if (hour < 10) {
			hourPart = "0" + hourPart;
		}
		String minutePart = String.valueOf(minute);
		if (minute < 10) {
			minutePart = "0" + minutePart;
		}
		return hourPart + minutePart;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Initial time  Final time  Passes");
		while (sc.hasNext()) {
			int oldHour = sc.nextInt();
			int oldMinute = sc.nextInt();
			int newHour = sc.nextInt();
			int newMinute = sc.nextInt();
			int passedTimes = passedTimes(oldHour, oldMinute, newHour,
					newMinute);
			System.out.format("       %s       %s%8d\n",
					makeTimeString(oldHour, oldMinute),
					makeTimeString(newHour, newMinute), passedTimes);
		}
	}
}
