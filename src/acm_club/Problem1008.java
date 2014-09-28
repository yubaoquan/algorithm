package acm_club;

import java.util.Scanner;

public class Problem1008 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int charNumber = sc.nextInt();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < charNumber; i ++) {
			char ch = (char) sc.nextInt();
			result.append(ch);
		}
		System.out.println(result);

	}

}
