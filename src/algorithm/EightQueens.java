package algorithm;

import java.util.Arrays;

public class EightQueens {

	private static int[] ground = new int[8];
	{
		Arrays.fill(ground, 0);
	}
	
	public static void findResult() {
		int row = 0;
		while (ground[0] < 8) {
			if (ground[row]>7) {
    			row--;
    			ground[row]++;
    			cleanGround(row + 1);
    			continue;
    		}
			int i = 0;
			for (;i < 8;i++) {
				if (checkPosition(row + 1,i)) {
					ground[row + 1] = i;
					row ++;
					break;
				}
			}
			if (i > 8) {
				row--;
    			ground[row]++;
    			cleanGround(row + 1);
    			continue;
			} else if (i == 7) {
				showResult();
				row --;
				ground[row] ++;
				cleanGround(row + 1);
			} else {
				row ++;
			}
			
		}
	}
	
	public static void cleanGround(int pos) {
		for (int i = pos;i < 8;i ++) {
			//ground[i] = 0;
		}
	}
	
	public static boolean checkPosition(int row,int pos) {
		for (int i = 0;i < row; i++) {
			if (ground[i] == pos) {
				return false;
			}
			if ((ground[i] + row - i == pos) || (ground[i] - row + i == pos)) {
				return false;
			}
		}
		return true;
	}
	
	public static void showResult() {
		for (int i = 0;i < 8; i++) {
			for (int j = 0;j < 8;j++) {
				if (j == ground[i]) {
					System.out.print("田  ");
				} else {
					System.out.print("口  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findResult();
	}

}
