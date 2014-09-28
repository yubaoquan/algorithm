package acm_club;

import java.util.Scanner;

public class Problem1006 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer result = new StringBuffer();
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			result.append(a + b);
			result.append("\n\n");
		}
		System.out.println(result);

	}

}
