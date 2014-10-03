package acm_club._1;

import java.util.Scanner;

public class Problem1010 {

	private static String analyzeString(String input) {
		String[] array = input.split(" ");
		double sum = 0.0;
		for (int i = 0; i < array.length; i++) {
			char ch = array[i].charAt(0);
			switch (ch) {
				case 'A':
					sum += 4;
					break;
				case 'B':
					sum += 3;
					break;
				case 'C':
					sum += 2;
					break;
				case 'D':
					sum += 1;
					break;
				case 'F':
					sum += 0;
					break;
				default:
					return "Unknown";
			}
			
		}
		double result = sum / array.length;
		return String.format("%.2f", result);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer result = new StringBuffer();
		while (sc.hasNext()) {
			String input = sc.nextLine();
			result.append(analyzeString(input));
			result.append("\n");
		}
		System.out.println(result);
	}

}
