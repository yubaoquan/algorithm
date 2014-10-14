package acm_club._1051;

import java.util.Scanner;

/**
 * 
 * @author	yubaoquan
 * @Date	2014年10月9日
 * @Description	AC
 *
 */
public class P1072_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		while (true) {
			boolean terminate = true;
			for (int i = 0; i < 5; i++) {
				array[i] = sc.nextInt();
				if (array[i] != 0) {
					terminate = false;
				}
			}
			if (terminate) {
				sc.close();
				return;
			}

			boolean dengcha = true;
			int cha = array[1] - array[0];
			for (int i = 2; i < 5; i++) {
				if (array[i] - array[i - 1] != cha) {
					dengcha = false;
					break;
				}
			}
			if (dengcha) {
				for (int i = 5; i < array.length; i++) {
					array[i] = array[0] + cha * i;
				}
				System.out.println("" + (array[0] + cha * 5) + " " + (array[0] + cha * 6)
						+ " " + (array[0] + cha * 7) + " " + (array[0] + cha * 8) + " "
						+ (array[0] + cha * 9));
				continue;
			}

			boolean dengbi = true;
			double shang = 1.0 * array[1] / array[0];
			for (int i = 2; i < 5; i++) {
				if (1.0 * array[i] / array[i - 1] != shang) {
					dengbi = false;
					break;
				}
			}
			if (dengbi) {
				for (int i = 5; i < array.length; i++) {
					array[i] = (int) (array[0] * Math.pow(shang, i));
				}
				System.out.println("" + (array[5]) + " " + (array[6]) + " " + (array[7])
						+ " " + (array[8]) + " " + (array[9]));
				continue;
			} else {
				for (int i = 5; i < array.length; i++) {
					array[i] = array[i - 1] + array[i - 2];
				}
				System.out.println("" + (array[5]) + " " + (array[6]) + " " + (array[7])
						+ " " + (array[8]) + " " + (array[9]));
			}
		}
	}
}
