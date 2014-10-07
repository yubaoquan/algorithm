package acm_club._51;

import java.util.Scanner;

public class Problem1070 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			int length = sc.nextInt();
			int[] array = new int[length];
			for (int j = 0; j < length; j++) {
				array[j] = sc.nextInt();
			}
			insertSort(array);
			
			boolean found = false;
			for (int k = 1; k < array.length; k++) {
				if (array[k] != array[0]) {
					System.out.println(array[k]);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("NO");
			}
		}
	}

	private static int[] insertSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					int index = j - 1;
					while (index >= 0 && array[index] > temp) {
						array[index + 1] = array[index];
						index--;
					}
					index++;
					array[index] = temp;
				}
			}
		}
		return array;
	}
}
