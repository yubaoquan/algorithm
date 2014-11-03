package acm_club._1100;

import java.util.Arrays;
import java.util.Scanner;

public class P1130 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] people = new int[n];
			for (int i = 0; i < n; i++) {
				people[i] = sc.nextInt();
			}
			System.out.println(foo(people));
		}
		sc.close();

	}

	private static String foo(int[] people) {
		int a = 0;
		int aCount = 0;
		int b = 0;
		int bCount = 0;
		Arrays.sort(people);
		for (int i = people.length - 1; i >= 0; i--) {
			if (a >= b&&bCount - aCount < 1) {
				b += people[i];
				bCount ++;
			} else if (a <=b && aCount - bCount < 1){
				a += people[i];
				aCount++;
			} else if(bCount - aCount < 1) {
				b += people[i];
				bCount ++;
			} else if (aCount - bCount < 1) {
				a += people[i];
				aCount++;
			} else {
				System.out.println("wtf");
			}
		}
		if (a < b) {
			return a + " " + b;
		}
		return b + " " + a;
	}

}
