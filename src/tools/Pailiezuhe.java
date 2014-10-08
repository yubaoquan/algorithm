package tools;

import java.util.HashSet;

public class Pailiezuhe {

	private static String inputStr;
	private static HashSet<String> result = new HashSet<>();
	private static char[] tempArray ;
	private static int[] book ;
	
	public static HashSet<String> pailiezuhe(String input) {
		inputStr = input;
		book = new int[input.length()];
		tempArray = new char[input.length()];
		dfs(0);
		return result;
	}
	
	private static void dfs(int step) {
		int bound = inputStr.length();
		if (step == bound) {
			result.add(String.valueOf(tempArray));
			return ;
		}
		for (int i = 0;i < inputStr.length();i ++) {
			if (book[i] == 0) {
				tempArray[step] = inputStr.charAt(i);
				book[i] = 1;
				dfs(step + 1);
				book[i] = 0;
			}
		}
	}
}
