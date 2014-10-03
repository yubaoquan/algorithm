package acm_club._51;

import java.util.Scanner;

public class Problem1051 {

	private static String translateWord(String word) {
		String[] numbers = word.split("-");
		char[] result = new char[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = (char) (Integer.parseInt(numbers[i]) + 'A' - 1);
		}
		return new String(result);
	}

	private static String[] extractWords(String input) {
		String[] words = input.split(" +");
		for (int i = 0; i < words.length; i++) {
			words[i] = translateWord(words[i]);
		}
		return words;
	}

	private static String translateWhole(String input) {
		input = input.replace("#", " ");
		String[] words = extractWords(input);
		input = input.replaceAll("\\S+", "=");
		for (int i = 0; i < words.length; i++) {
			input = input.replaceFirst("=", words[i]);
		}
		return input;
	}

	private static String translateWhole2(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '#') {
				sb.append(" ");
			} else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				if (i + 1 < input.length() && input.charAt(i + 1) >= '0'
						&& input.charAt(i + 1) <= '9') {
					sb.append((char) (Integer.parseInt(input
							.substring(i, i + 2)) + 'A' - 1));
					i++;
				} else {
					sb.append((char) (Integer.parseInt(input
							.substring(i, i + 1)) + 'A' - 1));
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(translateWhole(sc.nextLine()));
		}
		sc.close();
	}
}
