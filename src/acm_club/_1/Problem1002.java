package acm_club._1;

import java.util.Scanner;

public class Problem1002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer result = new StringBuffer();
		for (;;) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a ==0 && b == 0) break;
			result.append(String.valueOf(a + b)); 
			result.append("\n");
		}
		System.out.println(result);

	}

}
