package poj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem1002 {

	private static final char[] DICTIONARY = new char[500];
	static {
		DICTIONARY['0'] = '0';
		DICTIONARY['1'] = '1';
		DICTIONARY['2'] = '2';
		DICTIONARY['3'] = '3';
		DICTIONARY['4'] = '4';
		DICTIONARY['5'] = '5';
		DICTIONARY['6'] = '6';
		DICTIONARY['7'] = '7';
		DICTIONARY['8'] = '8';
		DICTIONARY['9'] = '9';
		DICTIONARY['A'] = '2';
		DICTIONARY['B'] = '2';
		DICTIONARY['C'] = '2';
		DICTIONARY['D'] = '3';
		DICTIONARY['E'] = '3';
		DICTIONARY['F'] = '3';
		DICTIONARY['G'] = '4';
		DICTIONARY['H'] = '4';
		DICTIONARY['I'] = '4';
		DICTIONARY['J'] = '5';
		DICTIONARY['K'] = '5';
		DICTIONARY['L'] = '5';
		DICTIONARY['M'] = '6';
		DICTIONARY['N'] = '6';
		DICTIONARY['O'] = '6';
		DICTIONARY['P'] = '7';
		DICTIONARY['R'] = '7';
		DICTIONARY['S'] = '7';
		DICTIONARY['T'] = '8';
		DICTIONARY['U'] = '8';
		DICTIONARY['V'] = '8';
		DICTIONARY['W'] = '9';
		DICTIONARY['X'] = '9';
		DICTIONARY['Y'] = '9';
	}

	private static HashMap<String, Integer> numberCounter = new HashMap<String, Integer>();

	private static void printStringArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static String convertWord2Number(String word) {
		char[] number = new char[8];
		number[3] = '-';
		for (int i = 0; i < number.length;) {
			for (int j = 0; j < word.length(); j++) {
				if (i == number.length) break;
				if (word.charAt(j) != '-') {
					number[i++] = DICTIONARY[word.charAt(j)];
				}
				if (i == 3) {
					i++;
				}
			}
		}
		return new String(number);
	}

	private static void testConvert() {
		String[] words = { "4873279", "ITS-EASY", "888-4567", "3-10-10-10",
				"888-GLOP", "TUT-GLOP", "967-11-11", "310-GINO", "F101010",
				"888-1200", "-4-8-7-3-2-7-9-", "487-3279","111111-1", };
		for (int i = 0; i < words.length; i++) {
			System.out.println(convertWord2Number(words[i]));
		}
//		printStringArray(getNumbers());
	}

	private static void problem1002() {
		numberCounter.clear();
		Scanner sc = new Scanner(System.in);
		int rows = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < rows; i++) {
			String word = sc.nextLine();
			String number = convertWord2Number(word);
			saveNumber(number);
		}
		printStringArray(getNumbers());
	}

	private static void saveNumber(String number) {
		Integer count = numberCounter.get(number);
		if (count == null) {
			numberCounter.put(number, 1);
		} else {
			numberCounter.put(number, count + 1);
		}
	}

	private static String[] getNumbers() {
		String[] numbers = new String[numberCounter.size()];
		int index = 0;
		for (String number : numberCounter.keySet()) {
			int count = numberCounter.get(number);
			if (count > 1) {
				String result = number + " " + numberCounter.get(number);
				numbers[index++] = result;
			}
		}
		if (index == 0) {
			return new String[]{"No duplicates. "};
		}
		String[] resultArray = Arrays.copyOfRange(numbers, 0, index);
		Arrays.sort(resultArray);
		return resultArray;
	}

	public static void main(String[] args) {
			problem1002();
	}
}
