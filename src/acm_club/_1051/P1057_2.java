package acm_club._1051;

import java.util.Arrays;
import java.util.Scanner;

public class P1057_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, tail, middleRight, flag;
		while (sc.hasNext()) {
			char[] array = sc.nextLine().toCharArray();
			boolean allNine = true;
			for (int index = 0; index < array.length; index++) {
				if (array[index] != '9') {
					allNine = false;
					break;
				}
			}
			if (allNine) {
				char[] result = new char[array.length + 1];
				Arrays.fill(result, '0');
				result[0] = '1';
				result[result.length - 1] = '1';
				System.out.println(result);
				continue;
			}
			tail = array.length - 1;
			middleRight = (tail + 1) >> 1;

			for (i = middleRight - 1, flag = 0; i >= 0 && flag == 0; i--) {
				flag = array[i] == array[tail - i] ? 0 : (array[i] > array[tail - i] ? 1
						: -1);
			}

			if (flag <= 0) {
				array[tail >> 1]++;
				for (i = tail >> 1; i != 0 && array[i] > '9'; i--) {
					array[i] = '0';
					array[i - 1]++;
				}
			}

			for (i = 0; i < middleRight; i++)
				System.out.print(array[i]);
			for (i = middleRight - (tail & 1); i >= 0; i--)
				System.out.print(array[i]);
			System.out.println();
		}
		sc.close();
	}

}
