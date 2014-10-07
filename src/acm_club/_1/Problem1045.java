package acm_club._1;

import java.util.Scanner;

public class Problem1045 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0;i < row;i++) {
			System.out.println(foo(sc.nextLine()));
		}
		sc.close();
	}

	private static char foo(String input) {
		String number = input.substring(0,input.length() - 2);
		int pos = Integer.parseInt(input.substring(input.length() - 1));
		int dot = number.indexOf('.');
		if (dot + pos >= number.length()) {
			return '0';
		}
		return number.charAt(dot + pos);
	}

}
