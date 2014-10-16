package acm_club._1100;

import java.util.Arrays;
import java.util.Scanner;

public class P1134 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rowIndex = 1;
		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			Block[] blocks = new Block[n * 6];
			int[] h = new int[blocks.length];
			int index = 0;
			int result = 0;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				blocks[index++] = new Block(x, y, z);
				blocks[index++] = new Block(y, x, z);
				blocks[index++] = new Block(x, z, y);
				blocks[index++] = new Block(z, x, y);
				blocks[index++] = new Block(y, z, x);
				blocks[index++] = new Block(z, y, x);

			}
			Arrays.sort(blocks);
			for (int i = 0; i < blocks.length; i++) {
				h[i] = blocks[i].z;
			}
			for (int i = 0; i < blocks.length; i++) {
				int maxi = 0;

				for (int j = i - 1; j >= 0; j--) {
					if (blocks[i].x > blocks[j].x && blocks[i].y > blocks[j].y
							&& maxi < h[j]) {
						maxi = h[j];
					}
				}
				h[i] += maxi;
				if (result < h[i]) {
					result = h[i];
				}
			}
			System.out.format("Case %d: maximum height = %d\n", rowIndex++, result);
		}
		sc.close();
	}

	static class Block implements Comparable<Block> {
		int x, y, z;

		Block(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Block o) {
			return x - o.x;
		}

	}
}
