package acm_club._51;

import java.util.Scanner;

public class Problem1080 {

	private static int[] array = new int[1000001];
	static {
		array[0] = 1;
		for (int i = 1;i < array.length;i++) {
			int index1 =(int) (i - Math.sqrt(i));
			int index2 = (int) Math.log(i);
			double sin = Math.sin(i);
			double pow = sin * sin;
			int index3 = (int) (i * pow);
			array[i] = (array[index1] + array[index2] + array[index3]) % 1000000;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == -1) {
				break;
			}
			System.out.println(find(n));
		}
	}

	private static int find(int n) {
		return array[n];
	}
}
