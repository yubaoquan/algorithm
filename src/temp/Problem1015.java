package temp;

import java.util.Scanner;

public class Problem1015 {

	private static String matrix(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1;i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				sb.append(i * j);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0;i < row;i ++) {
			sb.append(matrix(sc.nextInt()));
		}
		System.out.print(sb);

	}

}
