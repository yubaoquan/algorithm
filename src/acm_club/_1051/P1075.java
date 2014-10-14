package acm_club._1051;

import java.util.Scanner;

public class P1075 {

	private static int[] distance = new int[100000];

	static {
		int speed = 1;
		for (int time = 1; time < distance.length; time++) {
			distance[time] += distance[time - 1] + speed;
			distance[time] %= 10000;
			speed += 2;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			System.out.println(distance[sc.nextInt()]);
		}
		sc.close();
	}

}
