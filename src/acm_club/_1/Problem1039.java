package acm_club._1;

import java.util.Scanner;

public class Problem1039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(abbreviations(sc.nextLine()));
		}

	}

	private static String abbreviations(String input) {

		String[] array = input.split(" +");
		char[] result = new char[array.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = array[i].toUpperCase().charAt(0);
		}
		return new String(result);
	}

}
