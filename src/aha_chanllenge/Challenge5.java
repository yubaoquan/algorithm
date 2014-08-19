package aha_chanllenge;

import static java.lang.System.*;

public class Challenge5 {

	private static int numberOfMatches(int n) {
		int result = 0;
		int[] resultArray = {6,2,5,5,4,5,6,3,7,6};
		while (n / 10 != 0) {
			int t = n % 10;
			result += resultArray[t];
			n /= 10;
		}
		result += resultArray[n];
		return result;
	}
	
	private static void challenge22() {
		int matches = 20 - 4;
		int result = 0;
		for (int a = 0; a <= 111; a ++ ) {
			for (int b = 0;b <= 111; b ++) {
				int c = a + b;
				if (numberOfMatches(a) + numberOfMatches(b) + numberOfMatches(c) == matches) {
					result ++;
				}
			}
		}
		out.println("totally " + result + " solutions");
	}
	
	public static void main(String[] args) {
		challenge22();

	}

}
