package acm_club._1051;

import java.util.Scanner;

public class P1071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(foo(sc.nextInt()));
		}
		sc.close();
	}

	private static String foo(int input) {
		StringBuffer sb = new StringBuffer();
		while (input != 1) {
			if (input % 2 != 0) {
				sb.append(input);
				sb.append(" ");
				input *= 3;
				input++;
			} else {
				input /= 2;
			}
		}
		if (sb.length() == 0) {
			return "No number can be output !";
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
