package acm_club._51;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author	yubaoquan
 * @Date	2014年10月11日
 * @Description	超时
 *
 */
public class P1057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(findHuiWen(sc.nextLine()));
		}
		sc.close();
	}

	private static char[] findHuiWen(String input) {
		boolean everyNumberIsNine = true;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '9') {
				everyNumberIsNine = false;
				break;
			}
		}
		if (everyNumberIsNine) {
			char[] result = new char[input.length() + 1];
			Arrays.fill(result, '0');
			result[0] = '1';
			result[result.length - 1] = '1';
			return result;
		}
		char[] array = input.toCharArray();
		while (true) {
			increase(array);
			if (isHuiWen(array)) {
				return array;
			}
		}
	}

	private static boolean isHuiWen(char[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	private static void increase(char[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == '9') {
				array[i] = '0';
			} else {
				array[i]++;
				return;
			}
		}
	}

}
