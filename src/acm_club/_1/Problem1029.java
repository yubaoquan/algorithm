package acm_club._1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem1029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		double minutes = 0;
		while (sc.hasNext()) {
			String[] data = sc.nextLine().split(" ");

			int x1 = Integer.parseInt(data[0]);
			int y1 = Integer.parseInt(data[1]);
			int x2 = Integer.parseInt(data[2]);
			int y2 = Integer.parseInt(data[3]);
			double distance = Math.sqrt(Math.pow((x2 - x1), 2)
					+ Math.pow((y2 - y1), 2)) / 1000;
			minutes += distance * 2 / 20.0 * 60;
		}
		double hour = Math.floor(minutes / 60.0);
		minutes = Math.round(minutes - hour * 60);
		DecimalFormat df = new DecimalFormat("00");
		System.out.println(df.format(hour) + ":" + df.format(minutes));
		sc.close();
	}

}
