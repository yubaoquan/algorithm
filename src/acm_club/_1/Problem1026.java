package acm_club._1;

import java.util.Scanner;

public class Problem1026 {

	private static int point(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				return i + 1;
			}
		}
		return -1;
	}

	private static int allEven(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				result++;
			}
		}
		return result;
	}

	private static String check(int[][] matrix) {
		int size = matrix[0].length;
		int[] row = new int[size];
		int[] col = new int[size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				row[r] += matrix[r][c];
				col[c] += matrix[r][c];
			}
		}
		if (allEven(row) + allEven(col) == 0) {
			return "OK";
		}
		if (allEven(row) == 1 && allEven(col) == 1) {
			return String.format("Change bit (%d,%d)", point(row), point(col));
		}
		return "Corrupt";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		while (true) {
			int size = sc.nextInt();
			if (size == 0) {
				break;
			}
			int[][] matrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			sb.append(check(matrix));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
