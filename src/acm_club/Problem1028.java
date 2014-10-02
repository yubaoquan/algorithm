package acm_club;

import java.util.Scanner;

public class Problem1028 {

	private static double getPeriod(String oldTime, String newTime) {
		String[] old_hhmmss = oldTime.split(":");
		String[] new_hhmmss = newTime.split(":");
		int[] result = new int[3];
		for (int i = 0;i < 3;i ++) {
			result[i] = Integer.parseInt(new_hhmmss[i]) - Integer.parseInt(old_hhmmss[i]);
		}
		return result[0] + result[1] / 60.0 + result[2] / 3600.0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double speed = 0.0;
		double distance = 0;
		String previousTimeStr = "00:00:00";
		while (sc.hasNext()) {
			String input = sc.nextLine();
			String timeStr = input.substring(0, 8);
			double period = getPeriod(previousTimeStr, timeStr);
			previousTimeStr = timeStr;
			distance += speed * period;
			
			if (input.length() == 8) {
				System.out.format("%s %.2f km\n", timeStr, distance);
			} else {
				int newSpeed = Integer.parseInt(input.substring(9));
				speed = newSpeed;
			}
		}
	}
}
