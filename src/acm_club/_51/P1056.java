package acm_club._51;

import java.util.Scanner;

/**
 * 
 * @author	yubaoquan
 * @Date	2014年10月11日
 * @Description	WA
 *
 */
public class P1056 {

	private static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < row; i++) {
			System.out.println(findMinimalIndex(sc.nextLine()));
		}
		sc.close();
	}

	private static int findMinimalIndex(String input) {
		int space = input.indexOf(" ");
		input = input.substring(space + 1);
		for (int i = 0; i < input.length(); i++) {
			compareAndChange(input, i);
		}
		return result;
	}

	private static void compareAndChange(String input, int index) {
		int resultIndex = result;
		for (int i = index; input.charAt(i) <= input.charAt(resultIndex);) {
			if (input.charAt(i) < input.charAt(resultIndex)) {
				result = index;
				return;
			}
			i = (i + 1) % input.length();
			resultIndex = (resultIndex + 1) % input.length();
			if (i == index) {
				return;
			}
		}
	}

}
