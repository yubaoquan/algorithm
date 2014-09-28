package algorithm;

import java.text.DecimalFormat;
import java.util.Scanner;

class LA3708 {
	public static void main(String[] args) {
		Scanner sc = new Scanner((System.in));
		double ans = 0.0;
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			for (int i = 1; i < n; i++) {
				double pos = (double) i / n * (m + n);
				ans += Math.abs(Math.floor(pos + 0.5) - pos) / (n + m);
			}
		}
		DecimalFormat df = new DecimalFormat("####.0000");
		String result = df.format(ans * 10000.0);
		result = result.replace(".0000", ".0");
		System.out.println(result);
	}
}
