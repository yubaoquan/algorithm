package acm_club._1100;

import java.util.Scanner;

public class P1132 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] input = sc.nextLine().split(" ");
			System.out.println(longestCommonSubsequence(input[0], input[1], input, 0));
		}
		sc.close();
	}

	private static int longestCommonSubsequence(String string1, String string2,
			int shortIndex, int longIndex) {
		// TODO Auto-generated method stub
		int result = 0;
		String shortStr = (string1.length() < string2.length()) ? string1 : string2;
		String longStr = (string1.length() >= string2.length()) ? string1 : string2;
		int i = shortIndex ;
		int j = longIndex ;
		if (i + j== 0) {
			return 0;
		}
		if (i == 1) {
			if (longStr.contains(shortStr.subSequence(0, 1))) {
				return 1;
			}
			return 0;
		}
		
		for (; i > 0 && j > 0;) {
			if (shortStr.charAt(i) == longStr.charAt(j)) {
				i--;
				result++;
			}
			j--;
			result += longestCommonSubsequence(string1, string2, i, j);
		}
		return result;
	}

}
