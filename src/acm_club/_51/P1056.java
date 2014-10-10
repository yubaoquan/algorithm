package acm_club._51;

import java.util.Scanner;

public class P1056 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0;i < row;i++) {
			System.out.println(foo(sc.nextLine()));
		}

	}

	private static int foo(String input) {
		String[] array = new String[input.length()];
		for (int i = 0; i < input.length();i++) {
			array[i] = input.substring(i, input.length()) + input.substring(0,i);
		}
//		Arrays.s
		return 0;
	}

}
