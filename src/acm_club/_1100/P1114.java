package acm_club._1100;

import java.util.Scanner;

public class P1114 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			for (;n> 0;n--) {
				double x1 = sc.nextDouble();
				double y1 = sc.nextDouble();
				double x2 = sc.nextDouble();
				double y2 = sc.nextDouble();
				double x3 = sc.nextDouble();
				double y3 = sc.nextDouble();
				
				double resultX = (x1 + x2 + x3) / 3.0;
				double resultY = (y1 + y2 + y3) / 3.0;
				java.text.DecimalFormat   df   =new   java.text.DecimalFormat("0.0");  
				System.out.println(df.format(resultX) + " " + df.format(resultY));
			}
		}
		sc.close();
	}

}
