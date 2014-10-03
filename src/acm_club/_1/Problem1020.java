package acm_club._1;

import java.util.Scanner;

public class Problem1020 {

	private static final int UP = 6;
	private static final int DOWN = 4;
	private static final int STAY = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] result = new String[10000];
		int index = 0;
		while (sc.hasNext()) {
			int currentFloor = 0;
			int floors = sc.nextInt();
			if (floors == 0) {
				break;
			}
			int time = 0;
			for (int i = 0; i < floors; i++) {
				int floor = sc.nextInt();
				if (floor > currentFloor) {
					time += UP * (floor - currentFloor);
				} else {
					time += DOWN * (currentFloor - floor);
				}
				currentFloor = floor;
			}
			time += floors * STAY;
			result[index ++] = String.valueOf(time);
		}
		for (int i = 0;i < index;i ++) {
			System.out.println(result[i]);
		}
	}

}
