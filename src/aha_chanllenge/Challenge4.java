package aha_chanllenge;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import tools.Tools;

public class Challenge4 {
	private static final int ADD = 0;
	private static final int MULTI = 1;

	private static class ThreeNumber implements Comparable<ThreeNumber> {
		public int a;
		public int b;
		public int c;

		ThreeNumber(String input) {
			int[] array = devideStringForChallenge14(input);
			a = array[0];
			b = array[1];
			c = array[2];
		}

		@Override
		public int compareTo(ThreeNumber tn) {
			if (c == tn.c) {
				if (a == tn.a || a == tn.b) {
					return 0;
				} else {
					return a - tn.a;
				}
			} else {
				return c - tn.c;
			}
		}

		@Override
		public boolean equals(Object obj) {
			return compareTo((ThreeNumber) obj) == 0;
		}

		public String toString() {
			return a + " " + b + " " + c;
		}

		public int hashCode() {
			int min = Math.min(a, b);
			return c * 1000 + min;
		}
	}

	@SuppressWarnings("unused")
	private static void testEquals() {
		ThreeNumber t1 = new ThreeNumber("176283459");
		ThreeNumber t2 = new ThreeNumber("283176459");
		out.println(t1.equals(t2));
	}

	@SuppressWarnings("unused")
	private static void challenge14() {
		HashSet<String> origin = new HashSet<String>();
		HashSet<ThreeNumber> result = new HashSet<>();
		origin = challenge14Step1(origin);
		origin = challenge14Step2(origin);
		for (String str : origin) {
			// out.println(str);
			result.add(new ThreeNumber(str));
		}
		out.println("result size: " + result.size());
	}

	private static HashSet<String> challenge14Step2(HashSet<String> origin) {
		HashSet<String> temp = new HashSet<String>();
		for (String str : origin) {
			int[] tempArray = devideStringForChallenge14(str);
			if (tempArray[0] + tempArray[1] == tempArray[2]) {
				temp.add(str);
			}
		}
		origin.clear();
		origin.addAll(temp);
		return origin;
	}

	private static void testSetAdd() {
		ThreeNumber t1 = new ThreeNumber("176283459");
		ThreeNumber t2 = new ThreeNumber("283176459");
		HashSet<ThreeNumber> result2 = new HashSet<>();
		out.println("t1 equals t2: " + t1.equals(t2));
		out.println(result2.add(t1));
		out.println(result2.add(t2));
		out.println(result2.size());

		HashSet<String> hs = new HashSet<>();
		hs.add("hello");
		hs.add("hello");
		out.println("hs: " + hs.size());
	}

	private static HashSet<String> challenge14Step1(HashSet<String> origin) {
		HashSet<String> temp = new HashSet<String>();
		origin = Tools.pailiezuhe("123456789");
		for (String str : origin) {
			// 9xx + xxx or xxx + 9xx is more than 1000
			if (str.startsWith("9") || str.charAt(3) == '9') {
				temp.add(str);
			}
		}
		origin.removeAll(temp);
		return origin;
	}

	/**
	 * 把一个九位数分解成三个三位数 ex. 123456789 分解成 123, 456, 789
	 * 
	 * @param input
	 * @return
	 */
	private static int[] devideStringForChallenge14(String input) {
		if (input == null || input.length() != 9) {
			return null;
		}
		int[] result = new int[3];
		result[0] = Integer.parseInt(input.substring(0, 3));
		result[1] = Integer.parseInt(input.substring(3, 6));
		result[2] = Integer.parseInt(input.substring(6));
		return result;
	}

	/**
	 * 把一个九位数分解成三个数 ex. 123456789 分解成 12, 345, 6789
	 * 
	 * @param input
	 * @return
	 */
	private static int[] devideStringForChallenge15(String input) {
		if (input == null || input.length() != 9) {
			return null;
		}
		int[] result = new int[3];
		result[0] = Integer.parseInt(input.substring(0, 2));
		result[1] = Integer.parseInt(input.substring(2, 5));
		result[2] = Integer.parseInt(input.substring(5));
		return result;
	}

	private static void testDevideStringForChallenge14() {
		int[] result = devideStringForChallenge14("741852963");
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
	}

	private static void testDevideStringForChallenge15() {
		int[] result = devideStringForChallenge15("741852963");
		for (int i = 0; i < result.length; i++) {
			out.println(result[i]);
		}
	}

	private static void challenge15() {
		int result = 0;
		HashSet<String> results = Tools.pailiezuhe("123456789");
		for (String tempStr : results) {
			int[] array = devideStringForChallenge15(tempStr);
			if (array[0] * array[1] == array[2]) {
				result++;
			}
		}
		out.println("totally " + result);
	}

	/**
	 * 获取除了(1, input - 1)，(1,input)以外， 所有符合表达式 a + b = input 或者 a*b=input 的a，b * @param input
	 * 
	 * @return result[a] == b
	 */
	private static int[] getTwoFactors(int input, int operationType) {
		int[] results = new int[input];
		int loopTime = getLoopTime(input);
		for (int i = 2; i < loopTime; i++) {
			getTwoFactorsInner(input, operationType, results, i);
		}
		return results;
	}

	private static int getLoopTime(int input) {
		if (input % 2 == 0) {
			return input / 2;
		} else {
			return input / 2 + 1;
		}
	}

	private static void getTwoFactorsInner(int input, int operationType, int[] results, int i) {
		switch (operationType) {
			case ADD:
				results[i] = input - i;
				results[input - i] = i;
				break;
			case MULTI:
				if (input % i == 0) {
					results[i] = input / i;
					results[input / i] = i;
					break;
				} else {
					return;
				}
		}
	}

	private static void challenge17() {
		for (int i = 2; i <= 99; i++) {
			// int[] addArray =
		}
	}

	private static void addEqualsMuti() {
		int[][] array = new int[99 * 99][2];
		for (int i = 2; i < 99; i++) {
			for (int j = i + 1; j <= 99; j++) {
				// out.println(i + ", " + j);
				array[i + j][0]++;
				array[i * j][1]++;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] > 1 && array[i][1] > 1) {
				out.println(i);
			}
		}

	}

	public static void main(String[] args) {
		// testEquals();
		// testSetAdd();
		addEqualsMuti();
	}
}
