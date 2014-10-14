package acm_club._1051;

import java.util.Scanner;

public class P1053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equals(".")) {
				break;
			}
			System.out.println(foo(input));
		}
		sc.close();
	}

	private static int foo(String input) {
		for (int i = 1; i <= input.length(); i++) {
			if (input.length() % i == 0) {
				String unit = input.substring(0, i);
				boolean find = true;
				for (int j = 0; j < input.length(); j += i) {
					String temp = input.substring(j, j + unit.length());
					if (!temp.equals(unit)) {
						find = false;
						break;
					}
				}
				if (find) {
					return input.length() / unit.length();
				}
			}
		}
		return 1;
	}

}
