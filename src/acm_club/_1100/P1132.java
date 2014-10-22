package acm_club._1100;

import java.util.Arrays;
import java.util.Scanner;

public class P1132 {

	private static int[][] book;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] input = sc.nextLine().split(" +");
			book = new int[input[0].length()][input[1].length()];
			for (int i = 0; i < input[0].length(); i++) {
				Arrays.fill(book[i], -1);
			}
			System.out.println(longestCommonSubsequence(input[0], input[1],
					input[0].length() - 1, input[1].length() - 1));
		}
		sc.close();
	}

	private static int longestCommonSubsequence(String string1, String string2,
			int index1, int index2) {
		int result = 0;
		if (index1 == 0 && index2 == 0) {
			if (string1.charAt(index1) == string2.charAt(index2)) {
				return 1;
			}
			return 0;
		} else if(index1 == 0) {
			while (index2!=-1) {
				if (string1.charAt(index1) == string2.charAt(index2)) {
					return 1;
				} else {
					index2--;
					if (index2 == -1) {
						return 0;
					}
				}
			}
		}else if (index2 == 0) {
			while (index1!=-1) {
				if (string1.charAt(index1) == string2.charAt(index2)) {
					return 1;
				} else {
					index1--;
					if (index1==-1) {
						return 0;
					}
				}
			}
		}
		if (string1.charAt(index1) == string2.charAt(index2)) {
			int a = book[index1 - 1][index2 - 1];
			if (a == -1) {
				a = longestCommonSubsequence(string1, string2, index1 - 1,
						index2 - 1);
				book[index1 - 1][index2 - 1] = a;
			}
			result = 1 + a;

		} else {
			int a = book[index1 - 1][index2];
			int b = book[index1][index2 - 1];
			if (a == -1) {
				a = longestCommonSubsequence(string1, string2, index1 - 1,
						index2);
				book[index1 - 1][index2] = a;
			}
			if (b == -1) {
				b = longestCommonSubsequence(string1, string2, index1,
						index2 - 1);
				book[index1][index2 - 1] = b;
			}
			result = Math.max(a, b);
		}
		return result;
	}


}
