package acm_club._1;

import java.util.Scanner;

public class Problem1043 {

	private static String makeRectangle(int size) {
		String baseUnit = "ACM";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size * 3; i++) {
			for (int j = 0; j < size; j++) {
				sb.append(baseUnit);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int row = sc.nextInt();
			for (int i = 0; i < row; i++) {
				int size = sc.nextInt();
				System.out.print(makeRectangle(size));
			}
		}

	}

}
