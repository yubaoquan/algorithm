package acm_club._51;

import java.util.Scanner;

public class P1052 {

	private static int[] array = new int[100];
	static {
		array['H'] = 1;
		array['C'] = 12;
		array['N'] = 14;
		array['O'] = 16;
		array['F'] = 19;
		array['P'] = 31;
		array['S'] = 32;
		array['K'] = 39;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(relativeMolecularMass(sc.nextLine()));
		}
		sc.close();
	}

	private static int relativeMolecularMass(String input) {
		int result = 0;
		for (int i = 0; i < input.length();) {
			int element = input.charAt(i);
			i++;
			if (i == input.length()) {
				return result + array[element];
			}
			int number = 0;
			int c = input.charAt(i);
			while (c >= '0' && c <= '9') {
				number *= 10;
				number += c - '0';
				i++;
				if (i == input.length()) {
					break;
				}
				c = input.charAt(i);
			}
			if (number == 0) {
				number = 1;
			}
			result += array[element] * number;
		}
		return result;
	}

}
