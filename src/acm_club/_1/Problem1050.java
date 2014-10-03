package acm_club._1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1050 {

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

	private static int[] convertString2IntArrayAndSort(String input) {
		input = input.replace("5", " ");
		String[] numberStrings = input.split(" ");
		int[] result = new int[numberStrings.length];
		int index = 0;
		for (int i = 0; i < numberStrings.length; i++) {
			String t = numberStrings[i].trim();
			if (t.length() == 0) {
				continue;
			}
			result[index ++] = Integer.parseInt(numberStrings[i].trim());
		}
		return insertSort(Arrays.copyOfRange(result, 0, index));
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			System.out.format("%d ", array[i]);
		}
		System.out.println(array[array.length - 1]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.nextLine();
			printArray(convertString2IntArrayAndSort(input));
		}
		sc.close();
	}

}
