package acm_club._1;

import java.util.Scanner;

public class Problem1048 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(translate(sc.nextLine()));
		}
	}

	private static String translate(String input) {
		String[] array = input.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(reverse(array[i]));
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private static Object reverse(String string) {
		int length = string.length();
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[length - i - 1] = string.charAt(i);
		}
		return new String(result);
	}
}
