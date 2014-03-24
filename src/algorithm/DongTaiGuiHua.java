package algorithm;
public class DongTaiGuiHua {

	/**
	 * @param args
	 */
	//矩阵乘法
	public static void matrixMultiply(int[][] a,int[][] b,int[][] c,int ra,int ca,int rb,int cb){
		if(ca != cb){
			throw new IllegalArgumentException("矩阵不可乘");
		}
		for(int i = 0; i < ra; i ++){
			for(int j = 0; j < cb; j ++){
				int sum = a[i][0] * b[0][j];
				for(int k = 1; k < ca; k ++){
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
	}
	//m[i][j]代表矩阵i一直相乘到矩阵j所需的相乘次数
	//p[]代表每个矩阵的列数p[i-1]就是矩阵i的行数
	//s[i][j]代表从矩阵i乘到矩阵j的最佳分割点,即i乘到j可以划分为i乘到s[i][j],s[i+1][j]乘到j,所得的两个新矩阵相乘.
	public static void matrixChain(int []p,int[][] m,int[][] s){
		int n = p.length - 1;
		for(int i = 0; i <=n; i++){
			m[i][i] = 0;//矩阵i不和自己本身相乘,所以计算次数=0
		}
		for(int r = 2; r <=n; r ++){//每一次有r个矩阵相乘,r从最小的情况2开始,最后到所有n个矩阵相乘
			for(int i = 1; i <= n - r + 1; i ++){//从第一个矩阵开始的r个矩阵相乘,到第n-r+1个矩阵开始的r个矩阵相乘
				int j = i + r - 1;//j指向本次最后一个矩阵
				m[i][j] = m[i + 1][j] + p[i - 1]*p[i]*p[j];/*矩阵i乘到矩阵j的乘法次数等于
																		矩阵i+1乘到矩阵j的乘法次数m[i + 1][j] ,此时得到新矩阵
																		加上矩阵i和新矩阵相乘所需的乘法次数p[i - 1]*p[i]*p[j]   */
				s[i][j]= i;//初始时设最佳分割点在矩阵i之后
				for(int k = i + 1; k < j; k ++){
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];/*矩阵i乘到矩阵k,乘法次数m[i][k],矩阵k+1乘到矩阵j,乘法次数m[k+1][j]
					 																		得到的两个新矩阵相乘,乘法次数p[i - 1] * p[k] * p[j] */
					if(t < m[i][j]){					/*如果在此种分割点得到的乘法次数比刚才分割点得到的乘法次数小,则当前分割点是最佳分割点*/
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
	}
	//根据得到的切点数组,对矩阵链进行连乘,不知道对不对
	public static void matrixChainMultiply(int[][][] matrixChain,int start,int chainSize,int[] p,int[][] cutPoint,int[][] result){
		int cut = cutPoint[start][chainSize];
		int ra = p[start - 1];
		int ca = p[start];
		int cb = p[chainSize];
		if(chainSize == 2){
			matrixMultiply(matrixChain[start], matrixChain[cut +1], result, ra,ca,ca,cb);
		}else{
			int[][] temp1 = new int[ra][p[cut]];
			int[][] temp2 = new int[p[cut]][cb];
			
			matrixChainMultiply(matrixChain,start,cut,p,cutPoint,temp1);
			matrixChainMultiply(matrixChain,cut + 1,chainSize - cut,p,cutPoint,temp2);
			matrixMultiply(temp1, temp2, result, ra,ca,ca,cb);
		}
	}
	public static void main(String[] args) {

	}

}
