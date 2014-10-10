package acm_club._51;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * @author yubaoquan
 * @Date 2014年10月9日
 * @Description 未完成
 *
 */
public class P1067 {

	private static DecimalFormat df = new DecimalFormat("0.00");

	private static double find(int n) {
		double sum = n;
		for (int i = 2; i <= n; i++) {
			sum += 1.0 * (n - i + 1) * 2 / i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			System.out.println(df.format(find(n)));
		}
		sc.close();
	}

}
