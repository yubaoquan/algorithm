package acm_club._1001;

import java.util.Scanner;

public class Problem1017 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int row = sc.nextInt();
		for (int i = 0;i < row;i ++) {
			int studentNumber = sc.nextInt();
			int xiaomingNumber = sc.nextInt();
			int[] scores = new int[studentNumber];
			for (int j = 0;j < studentNumber; j ++) {
				scores[j] = sc.nextInt();
			}
			int result = 0;
			for (int k = 0;k < studentNumber;k ++) {
				if (scores[k] > scores[xiaomingNumber - 1]) {
					result ++;
				}
			}
			sb.append(result);
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
