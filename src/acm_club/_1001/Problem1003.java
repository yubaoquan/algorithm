package acm_club._1001;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1003 {

	private static ArrayList<Integer> result = new ArrayList<Integer>();

	private static int[] parseArray(String input) {
		String[] stringArray = input.split(" ");
		int[] result = new int[Integer.parseInt(stringArray[0])];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(stringArray[i + 1]);
		}
		return result;
	}

	private static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		result.add(sum);
		return sum;
	}

	private static void printResult() {
		for (Integer i : result) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.charAt(0) == '0') {
				break;
			}
			sum(parseArray(str));
		}
		printResult();
		sc.close();
	}

}
