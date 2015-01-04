package acm_club._1100;

import java.util.Scanner;

public class P1113 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 1;
		while (true) {
			int r = sc.nextInt();
			if (r == 0) {
				break;
			}
			int w = sc.nextInt();
			int l = sc.nextInt();
			
			int duijiaoxianPow = (w * w + l * l);
			if ((2*r * 2*r)>= duijiaoxianPow) {
				System.out.format("Pizza %d fits on the table.\n", index);
			} else {
				System.out.format("Pizza %d does not fit on the table.\n", index);
			}
			index ++;
		}

	}

}
