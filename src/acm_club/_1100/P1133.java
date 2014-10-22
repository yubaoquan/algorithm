package acm_club._1100;

import java.util.Scanner;

public class P1133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (; sc.hasNext();) {
			int n = sc.nextInt();
			int[][] array = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			System.out.println(maxSubMatrixSum(array));
		}
		sc.close();
	}

	private static int maxSubMatrixSum(int[][] mat) {
		int ret, sum, i, k;
		int j = 0;
		//matsum[i][j + 1]代表数组第i行从第0个元素到第j个元素的和;
		int[][] matsum = new int[mat.length][mat.length + 1];
		
		//初始化matsum
		for (i = 0; i < mat.length; i++)
			for (j = 0,matsum[i][j] = 0; j < mat.length; j++){
				matsum[i][j + 1] = matsum[i][j] + mat[i][j];
			}
		
		
		for (j = 0,ret = mat[0][0]; j < mat.length; j++)//子矩阵的左端
			for (k = j; k < mat.length; k++)//子矩阵的右端;
				//每一行进行求和;
				//每次外层循环改变子矩阵的左右端位置,代表一种新的子矩阵,此时将sum清零;
				for (sum = 0, i = 0; i < mat.length; i++) {
					sum = (sum > 0 ? sum : 0) + matsum[i][k + 1] - matsum[i][j];
					ret = (sum > ret ? sum : ret);//记录当前最大结果;
				}
		return ret;
	}

}
