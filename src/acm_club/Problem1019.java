package acm_club;

import java.util.Scanner;

public class Problem1019 {

	private static int judgeFacade(String a, String b) {
		return judge(a.charAt(0), b.charAt(0));
	}

	/**
	 * 
	 * @author yubaoquan
	 * @Description R for Rock, S for Scissors and P for paper
	 * @param a
	 * @param b
	 * @return
	 */
	private static int judge(int player1, int player2) {
		if (player1 == player2) {
			return 0;
		}
		switch (player1) {
			case 'R':
				switch (player2) {
					case 'S':
						return 1;
					case 'P':
						return -1;
					default:
						return 999;
				}
			case 'S':
				switch (player2) {
					case 'R':
						return -1;
					case 'P':
						return 1;
					default:
						return 999;
				}
			case 'P':
				switch (player2) {
					case 'S':
						return -1;
					case 'R':
						return 1;
					default:
						return 999;
				}
			default:
				return 999;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		String[] resultDesc = { "TIE", "Player 1", "Player 2" };
		int row = sc.nextInt();
		for (int i = 0; i < row; i++) {
			int fightTime = sc.nextInt();
			int fightSum = 0;
			for (int j = 0; j < fightTime; j++) {
				String c1 = sc.next();
				String c2 = sc.next();
				fightSum += judgeFacade(c1, c2);
			}
			if (fightSum > 0) {
				sb.append(resultDesc[1]);
			} else if (fightSum < 0) {
				sb.append(resultDesc[2]);
			} else {
				sb.append(resultDesc[0]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
