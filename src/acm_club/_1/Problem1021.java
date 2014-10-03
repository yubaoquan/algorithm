package acm_club._1;

import java.util.Scanner;

public class Problem1021 {

	private static int jokExponential(String input) {
		int result = 0;
		int pos = 0;
		while (true) {
			if (input.charAt(pos) == 'B') {
				return result;
			}
			if (input.charAt(pos) == '(') {
				result += 1;
			}
			if (input.charAt(pos) == ')') {
				result -= 1;
			}
			pos ++;
		}
	}
	public static void main(String[] args) {
		int[] result = new int[100];
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while (sc.hasNext()){
			String input = sc.nextLine();
			result[index ++] = jokExponential(input);
		}
		for (int i = 0;i < index;i ++) {
			System.out.println(result[i]);
		}
	}

}
