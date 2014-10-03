package acm_club._1;

import java.util.Scanner;

public class Problem1032 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int row = sc.nextInt();
			int[] family = new int[21];
			int ancestor = 0;
			for (int i = 0; i < row; i++) {
				int son = sc.nextInt();
				int father = sc.nextInt();
				if (father > ancestor) {
					ancestor = father;
				}
				family[son] = father;
			}
			int generationMing = 0;
			int generationYu = 0;
			int beginningMing = 1;
			int beginningYu = 2;
			while (family[beginningMing] != ancestor) {
				beginningMing = family[beginningMing];
				generationMing++;
			}
			while (family[beginningYu] != ancestor) {
				beginningYu = family[beginningYu];
				generationYu++;
			}
			if (generationMing > generationYu) {
				System.out.println("You are my elder");
			} else if (generationMing == generationYu) {
				System.out.println("You are my brother");
			} else {
				System.out.println("You are my younger");
			}
		}
		sc.close();
	}

}
