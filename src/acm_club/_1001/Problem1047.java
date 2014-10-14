package acm_club._1001;

import java.util.Scanner;

public class Problem1047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equals("#")) {
				break;
			}
			String left = input.substring(0, input.length() - 1);
			char flag = input.charAt(input.length() - 1);
			if (flag == 'e') {
				if (isEven(left)) {
					System.out.println(left + "0");
				} else {
					System.out.println(left + "1");
				}
			} else if (flag == 'o') {
				if (isEven(left)) {
					System.out.println(left + "1");
				} else {
					System.out.println(left + "0");
				}
			}
		}
	}

	private static boolean isEven(String left) {
		boolean result = true;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) == '1') {
				result = !result;
			}
		}
		return result;
	}

}
