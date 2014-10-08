package acm_club._51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1066 {

	private static String inputStr;
	private static ArrayList<String> result = new ArrayList<String>();
	private static char[] tempArray;
	private static int[] book;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			print(pailiezuhe(sc.nextLine()));
			System.out.println();
		}
		sc.close();
	}

	public static ArrayList<String> pailiezuhe(String input) {
		result = new ArrayList<String>();
		inputStr = input;
		book = new int[input.length()];
		tempArray = new char[input.length()];
		dfs(0);
		Collections.sort(result);
		return result;
	}

	private static void dfs(int step) {
		int bound = inputStr.length();
		if (step == bound) {
			result.add(String.valueOf(tempArray));
			return;
		}
		for (int i = 0; i < inputStr.length(); i++) {
			if (book[i] == 0) {
				tempArray[step] = inputStr.charAt(i);
				book[i] = 1;
				dfs(step + 1);
				book[i] = 0;
			}
		}
	}

	private static void print(ArrayList<String> pailiezuhe) {
		for (String str : pailiezuhe) {
			System.out.println(str);
		}

	}

}
