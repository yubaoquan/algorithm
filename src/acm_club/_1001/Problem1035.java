package acm_club._1001;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1035 {

	private static String drawX(int size) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			char[] line = new char[size];
			Arrays.fill(line, ' ');
			line[i] = 'X';
			line[size - 1 - i] = 'X';
			for (int j = line.length - 1; line[j] != 'X'; j--) {
				line[j] = '=';
			}
			sb.append(new String(line).replace("=", ""));
			sb.append('\n');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			int size = sc.nextInt();
			System.out.println(drawX(size));
		}
	}
}
