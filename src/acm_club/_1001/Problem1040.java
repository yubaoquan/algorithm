package acm_club._1001;

import java.util.Scanner;

public class Problem1040 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		sc.nextLine();
		for (int i = 0;i < row;i ++) {
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			int middle = str1.length() / 2;
			System.out.println(str1.substring(0, middle) + str2 + str1.substring(middle, str1.length()));
		}
		sc.close();
	}

}
