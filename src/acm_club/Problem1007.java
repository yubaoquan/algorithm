package acm_club;

import java.util.Scanner;

public class Problem1007 {


		private static int parseArray(String input) {
			String[] stringArray = input.split(" ");
			int length = Integer.parseInt(stringArray[0]);
			int sum = 0;
			for (int i = 0; i < length; i ++) {
				sum += Integer.parseInt(stringArray[i + 1]);
			}
			return sum;
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int rows = Integer.parseInt(sc.nextLine());
			StringBuffer result = new StringBuffer();
			for (int i = 0;i < rows;i ++) {
				String input = sc.nextLine();
				result.append(parseArray(input));
				result.append("\n\n");
			}
			System.out.println(result);

		}

	}


