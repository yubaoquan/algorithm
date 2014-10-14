package acm_club._1001;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem1044 {

	private static DecimalFormat df = new DecimalFormat("0.00000");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(probability(sc.nextLine()));
		}

	}

	private static String probability(String input) {
		input = input.toLowerCase();
		char c = input.charAt(0);
		String word = input.substring(2);
		double count = 0.0;
		for (int i = 0;i < word.length();i++) {
			if (c==word.charAt(i)) {
				count++;
			}
		}
		return df.format(count / word.length());
	}

}
