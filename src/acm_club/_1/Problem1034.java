package acm_club._1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1034 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();
			System.out.print(draw(num));
		}

	}

	private static String draw(int num) {
		StringBuffer sb = new StringBuffer();
		char[][] array = new char[num * 2 - 1][];
		for (int i = 0; i < num; i++) {
			array[num - 1 + i] = new char[num * 2 - 1 - i];
			array[num - 1 - i] = new char[num * 2 - 1 - i];
			Arrays.fill(array[num - 1 + i], ' ');
			Arrays.fill(array[num - 1 - i], ' ');
			for (int j = 0; j < num - i; j++) {
				array[num - 1 + i][num - 1 + j] = (char) (num - i - j + '0');
				array[num - 1 + i][num - 1 - j] = (char) (num - i - j + '0');
				array[num - 1 - i][num - 1 + j] = (char) (num - i - j + '0');
				array[num - 1 - i][num - 1 - j] = (char) (num - i - j + '0');
			}
		}
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			sb.append("\n");
		}
		return sb.toString();
	}

}
