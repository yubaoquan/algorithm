package acm_club._1;

import java.util.Scanner;

public class Problem1055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(foo(sc.nextLine(), sc.nextLine()));
		}
		sc.close();
	}

	private static int foo(String a, String b) {
		int count = 0;
		if (b.length() == 1) {
			return appearInA(a, b);
		}
		String rotatedStr[] = new String[b.length()];
		rotatedStr[0] = b;
		for (int i = 1; i < b.length(); i++) {
			rotatedStr[i] = b.substring(i) + b.substring(0, i);
		}
		for (int i = rotatedStr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (rotatedStr[i].equals(rotatedStr[j])) {
					rotatedStr[i] = "";
					break;
				}
			}
		}
		for (int i = 0; i < rotatedStr.length; i++) {
			if (rotatedStr[i].length() == 0) {
				continue;
			}
			count += appearInA(a, rotatedStr[i]);
		}
		return count;
	}

	private static int appearInA(String a, String rotatedB) {
		if (a.indexOf(rotatedB) == -1) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.indexOf(rotatedB, i) == i) {
				count++;
			}
		}
		return count;
	}
}
