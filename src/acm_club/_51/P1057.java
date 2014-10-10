package acm_club._51;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P1057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(foo(sc.nextLine()));
		}
		sc.close();
//		System.out.println(isHuiWen("".toCharArray()));
//		System.out.println(isHuiWen("1".toCharArray()));
//		System.out.println(isHuiWen("12".toCharArray()));
//		System.out.println(isHuiWen("123".toCharArray()));
//		System.out.println(isHuiWen("12321".toCharArray()));
//		System.out.println(isHuiWen("1231321".toCharArray()));
	}

	private static char[] foo(String input) {
		char[] array = new char[input.length() + 1];
		array[0] = '0';
		for (int i = 1;i < array.length;i++) {
			array[i] = input.charAt(i);
		}
		while (true) {
			if (isHuiWen(array)) {
				return array;
			}
			increase(array);
		}
	}

	private static boolean isHuiWen(char[] array) {
		for (int i = 0;i < array.length / 2;i++) {
			if (array[i] != array[array.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	private static void increase(char[] array) {
		// TODO Auto-generated method stub
		
	}
	
	private static boolean isHuiWen(String input) {
		char[] array = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			array[i] = input.charAt(input.length() - i - 1);
		}
		if (new String(array).equals(input)) {
			return true;
		}
		return false;
	}
}
