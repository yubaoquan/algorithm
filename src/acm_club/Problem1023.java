package acm_club;

import java.util.Scanner;

public class Problem1023 {

	private static int[] drinks = {150, 200, 350};
	private static int calculate(int input) {
		if (input < drinks[0]) {
			return input;
		}
		int[] modResult = new int[drinks.length];
		while (true) {
			for (int i = 0;i < drinks.length ;i ++) {
				modResult[i] = input % drinks[i];
				if (modResult[i] == 0) {
					return 0;
				}
			}
			int smallestModIndex = drinks.length -1;
			for (int i = 0;i < modResult.length;i ++) {
				if (modResult[i] < modResult[smallestModIndex] && input != modResult[i]) {
					smallestModIndex = i;
				}
			}
			input -= drinks[smallestModIndex];
			if (input < drinks[0]) {
				return input;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[10000];
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			int data = sc.nextInt();
			result[i] = calculate(data);
		}
		for (int i = 0;i < row;i ++) {
			System.out.println(result[i]);
		}
	}

}
