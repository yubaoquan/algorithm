package acm_club._1100;

import java.util.Scanner;

public class P1105 {

	private static int groupNo = 1;
	private static int n;
	private static int[] a;
	private static int[] v;

	private static boolean isPrime(int n) {
		int sqrtN = (int) Math.sqrt((double) n);
		for (int i = 2; i <= sqrtN; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			n = sc.nextInt();
			v = new int[21];
			a = new int[20];
			for (int i = 0; i < v.length; i++) {
				v[i] = 0;
			}
			a[0] = v[1] = 1;
			System.out.format("Case %d:\n", groupNo);
			dfs(1);
			System.out.println();
			groupNo++;
		}
		sc.close();
	}

	private static void dfs(int r) {
		int i, j;
		if (r == n) {
			if (isPrime(a[r - 1] + 1)) {
				for (j = 0; j < n; j++)
					System.out.format(j == n - 1 ? "%d\n" : "%d ", a[j]);
			}
			return;
		}
		for (i = 2; i <= n; i++) {
			if (0 == v[i] && isPrime(a[r - 1] + i)) {
				v[i] = 1;
				a[r] = i;
				dfs(r + 1);
				v[i] = 0;
			}
		}

	}

}
