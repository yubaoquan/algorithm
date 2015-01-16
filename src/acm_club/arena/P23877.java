package acm_club.arena;

import java.util.Arrays;
import java.util.Scanner;

public class P23877 {

	private static int[] array;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(foo(x, y));
		}
		sc.close();
	}

	private static int foo(int x, int y) {
		int[] tempArray = Arrays.copyOfRange(array, x - 1, y);
		return xianduanshu(tempArray);
	}

	private static int xianduanshu(int[] tempArray) {
		int maxSum = tempArray[0];
		int currentSum;
		for (int i = 0; i < tempArray.length; i++) {
			currentSum = 0;
			for (int j = 0; j <= tempArray.length - i - 1; j++) {
				currentSum += tempArray[i + j];
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}

}
