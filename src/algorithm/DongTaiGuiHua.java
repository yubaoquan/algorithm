package algorithm;
public class DongTaiGuiHua {

	/**
	 * @param args
	 */
	//����˷�
	public static void matrixMultiply(int[][] a,int[][] b,int[][] c,int ra,int ca,int rb,int cb){
		if(ca != cb){
			throw new IllegalArgumentException("���󲻿ɳ�");
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
	//m[i][j]�������iһֱ��˵�����j�������˴���
	//p[]����ÿ�����������p[i-1]���Ǿ���i������
	//s[i][j]����Ӿ���i�˵�����j����ѷָ��,��i�˵�j���Ի���Ϊi�˵�s[i][j],s[i+1][j]�˵�j,���õ������¾������.
	public static void matrixChain(int []p,int[][] m,int[][] s){
		int n = p.length - 1;
		for(int i = 0; i <=n; i++){
			m[i][i] = 0;//����i�����Լ��������,���Լ������=0
		}
		for(int r = 2; r <=n; r ++){//ÿһ����r���������,r����С�����2��ʼ,�������n���������
			for(int i = 1; i <= n - r + 1; i ++){//�ӵ�һ������ʼ��r���������,����n-r+1������ʼ��r���������
				int j = i + r - 1;//jָ�򱾴����һ������
				m[i][j] = m[i + 1][j] + p[i - 1]*p[i]*p[j];/*����i�˵�����j�ĳ˷���������
																		����i+1�˵�����j�ĳ˷�����m[i + 1][j] ,��ʱ�õ��¾���
																		���Ͼ���i���¾����������ĳ˷�����p[i - 1]*p[i]*p[j]   */
				s[i][j]= i;//��ʼʱ����ѷָ���ھ���i֮��
				for(int k = i + 1; k < j; k ++){
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];/*����i�˵�����k,�˷�����m[i][k],����k+1�˵�����j,�˷�����m[k+1][j]
					 																		�õ��������¾������,�˷�����p[i - 1] * p[k] * p[j] */
					if(t < m[i][j]){					/*����ڴ��ַָ��õ��ĳ˷������ȸղŷָ��õ��ĳ˷�����С,��ǰ�ָ������ѷָ��*/
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
	}
	//���ݵõ����е�����,�Ծ�������������,��֪���Բ���
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
