package aha_chanllenge;

import static java.lang.System.*;

import java.util.Scanner;

public class ChallengePage2 {

	/**
	 * get the huiwen corresponds to the input
	 * 
	 * @param input
	 * @return
	 */
	private static int getHuiWen(int input) {
		int result = 0;
		char[] charArray = String.valueOf(input).toCharArray();

		StringBuffer sb = new StringBuffer();
		for (int i = charArray.length; i > 0; i--) {
			sb.append(charArray[i - 1]);
		}
		try {
			result = Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			out.println(sb + " is two long");
			result = 0;
		}
		return result;
	}

	/**
	 * check whether a number is a huiwen 
	 * @param input
	 * @return
	 */
	private static boolean isHuiWen(int input) {
		boolean result = false;
		if (getHuiWen(input) == input) {
			result = true;
		}
		return result;
	}

	/**
	 * calculate how many steps is needed to make a number become huiwen
	 * @param input
	 * @return
	 */
	private static int stepLengthToBecomeHuiWen(int input) {
		int result = 0;
		while(!isHuiWen(input)) {
			int hui = getHuiWen(input);
			out.print(input + " + " + hui + " ");
			input += hui;
			result ++;
			if (result >= 100) {
				out.println("it seems that this number cannot become a huiwen");
				break;
			}
		}
		out.println(" = " + input);
		return result;
	}
	
	/**
	 * find the longest steps to get make a target number become huiwen;
	 * target numbers are from 1 to 100 (excluded);
	 */
	private static void huiWen() {
		int longestStepLength = 0;
		int tempStepLength = 0;
		int target = 0;
		for (int i = 1; i < 100; i ++) {
			//89 and 98 need more than 100 steps to become huiwen.
			//it is not clear that whether these two numbers can become huiwen
			if (i == 89 || i == 98) {
				continue;
			}
			tempStepLength = stepLengthToBecomeHuiWen(i);
			if (tempStepLength > longestStepLength) {
				longestStepLength = tempStepLength;
				target = i;
			}
		}
		out.println(target + " uses " + longestStepLength + " to become a huiwen.");
	}
	private static void testIsHuiWen(int a) {
		out.println(a + " is huiwen : " + isHuiWen(a));
	}

	public static void main(String[] args) {
		//huiWen();
		Scanner sc = new Scanner(in);
		String str1, str2, str3;
		str1 = sc.next();
		str2 = sc.next();
		str3 = sc.next();
		
		out.println(str1);
		out.println(str2);
/*		out.println(1<<n);
		out.println(m>>1);*/
	}

}
