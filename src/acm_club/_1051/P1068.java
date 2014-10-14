package acm_club._1051;

import java.util.Arrays;
import java.util.Scanner;

public class P1068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int lenA = sc.nextInt();
			int lenB = sc.nextInt();

			int[] arrayA = new int[lenA];
			int[] arrayB = new int[lenB];
			for (int i = 0; i < lenA; i++) {
				arrayA[i] = sc.nextInt();
			}
			for (int i = 0; i < lenB; i++) {
				arrayB[i] = sc.nextInt();
			}
			Arrays.sort(arrayA);
			Arrays.sort(arrayB);

			int[] result = new int[lenA + lenB];
			int indexA = 0;
			int indexB = 0;
			int end = result.length;
			for (int i = 0; i < result.length; i++) {
				if (indexA == lenA) {
					while (i < result.length && indexB < lenB) {
						result[i++] = arrayB[indexB++];
					}
				} else if (indexB == lenB) {
					while (i < result.length && indexA < lenA) {
						result[i++] = arrayA[indexA++];
					}
				} else {
					if (arrayA[indexA] == arrayB[indexB]) {
						result[i] = arrayA[indexA];
						indexA++;
						indexB++;
						end--;
					} else if (arrayA[indexA] < arrayB[indexB]) {
						result[i] = arrayA[indexA];
						indexA++;
					} else {
						result[i] = arrayB[indexB];
						indexB++;
					}
				}

			}
			for (int i = 0; i < end - 1; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println(result[end - 1]);
		}
		sc.close();
	}

}
