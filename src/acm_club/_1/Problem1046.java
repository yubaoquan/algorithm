package acm_club._1;

import java.util.Scanner;

public class Problem1046 {

	private static final String[] KITCHENWARES = { "bowl", "knife", "fork",
			"chopsticks" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		while (sc.hasNext()) {
			int a = sc.nextInt();
			for (int i = 0;i < a;i++) {
				String b = sc.next();
				if (isKitchenware(b)) {
					sb.append(b);
					sb.append(" ");
				}
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
	}

	private static boolean isKitchenware(String string) {
		for (int i = 0; i < KITCHENWARES.length; i++) {
			if (string.equals(KITCHENWARES[i])) {
				return true;
			}
		}
		return false;
	}

}
