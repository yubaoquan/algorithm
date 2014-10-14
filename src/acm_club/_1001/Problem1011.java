package acm_club._1001;

import java.util.Scanner;

public class Problem1011 {

	private static int compare(String version1, String version2) {
		if (version1.equals(version2)) {
			return 0;
		}
		String[] version1Array = version1.split(" ");
		String[] version2Array = version2.split(" ");
		for (int i = 0; i < version1Array.length; i++) {
			int v1 = Integer.parseInt(version1Array[i]);
			int v2 = Integer.parseInt(version2Array[i]);
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return 2;
			} else {
				continue;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer result = new StringBuffer();
		String[] compareResult = { "Same", "First", "Second" };
		int dataGroup = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < dataGroup; i++) {
			String version1 = sc.nextLine();
			String version2 = sc.nextLine();
			result.append(compareResult[compare(version1, version2)]);
			result.append("\n");
		}
		System.out.print(result);
	}

}
