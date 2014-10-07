package acm_club._1;

import java.util.Scanner;

public class Problem1027 {

	static String[] charMaps = { 
		    " _     _  _     _  _  _  _  _ ",
			"| |  | _| _||_||_ |_   ||_||_|", 
			"|_|  ||_  _|  | _||_|  ||_| _|" };

	private static String drawPartOfNumbers(int number, int row) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < 3; j++) {
			sb.append(charMaps[row].charAt(number * 3 + j));
		}
		return sb.toString();
	}

	private static String drawAllNumbers(String numbers) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < numbers.length(); i++) {
				sb.append(drawPartOfNumbers(numbers.charAt(i) - '0', j));
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String number = sc.nextLine();
			number = number.replace(" ",	 "");
			System.out.print(drawAllNumbers(number));
		}
		sc.close();
	}
}
