package algorithm;

public class HuiSu {

	/**
	 * @param args
	 */
	//八皇后问题
	static int n;
	static int[] x;
	static long sum;
	
	private static boolean place(int k){//用于判断第k行的第x[k]列是否可以放皇后
		for(int j = 1; j < k; j ++){
			if(Math.abs(k - j) == Math.abs(x[j] - x[k]) || x[j] == x[k]){
				return false;
			}
		}
		return true;
	}
	//递归方式
	public static long nQueen(int nn){
		n = nn;
		sum = 0;
		x = new int[n + 1];
		for(int i = 0; i <= n; i ++){
			x[i] = 0;
		}
		backtrack(1);
		return sum;
	}
	
	private static void backtrack(int t){
		if(t > n){
			sum ++;
		}else{
			for(int i = 1; i <= n; i ++){
				x[t] = i;
				if(place(t)){
					backtrack(t + 1);
				}
			}
		}
	}
	

	//非递归方式
	public static long nQueen2(int nn){
		n = nn;
		sum = 0;
		x = new int[n + 1];
		for(int i = 0; i <= n; i ++){
			x[i] = 0;
		}
		backtrack();
		return sum;
	}
	
	private static void backtrack() {
		x[1] = 0;
		int k = 1;
		while(k > 0){
			x[k] += 1;
			while((x[k] <= n) && !place(k)){
				x[k] += 1;
			}
			if(x[k] <= n){
				if(k == n){
					sum ++;
				}else{
					k ++;
					x[k] = 0;
				}
			}else{
				k --;
			}
		}
	}


	public static void main(String[] args) {
		
	}
}
