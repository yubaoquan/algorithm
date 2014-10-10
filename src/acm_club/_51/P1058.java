package acm_club._51;

import java.util.Scanner;

public class P1058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int[] array = new int[n];
			for (int i = 0;i < n;i++) {
				array[i] = sc.nextInt();
			}
			for (int i = 0;i < n;) {
				boolean find = true;
				for (int j = i+ 1;j < n;j++) {
					if (array[i] == array[j]) {
						find = false;
						swap(array,i + 1,j);
						i += 2;
						break;
					}
				}
				if (find) {
					System.out.println(array[i]);
					break;
				}
			}
		}
		sc.close();
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
