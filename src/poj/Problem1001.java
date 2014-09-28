package poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 * @author DELL
 * @Description 用来解决poj上的题目
 */
public class Problem1001 {

	private static String inner1001(BigDecimal a, int b) {
		BigDecimal result = a.pow(b);
		String resultStr = result.toPlainString();
		int head = 0;
		while (resultStr.charAt(head) == '0') {
			head++;
		}
		int tail = resultStr.length() - 1;
		while (resultStr.charAt(tail) == '0') {
			tail--;
		}
		if (resultStr.charAt(tail) == '.') {
			tail --;
		}
		return resultStr.substring(head, tail + 1);
	}

	private static void problem1001() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			BigDecimal a = sc.nextBigDecimal();
			int b = sc.nextInt();
			System.out.println(inner1001(a, b));
		}
	}

	private static void test1001() {
		String[] answer = new String[7];
		answer[1] = "548815620517731830194541.899025343415715973535967221869852721";
		answer[2] = ".00000005148554641076956121994511276767154838481760200726351203835429763013462401";
		answer[3] = "43992025569.928573701266488041146654993318703707511666295476720493953024";
		answer[4] = "29448126.764121021618164430206909037173276672";
		answer[5] = "90429072743629540498.107596019456651774561044010001";
		answer[6] = "1.126825030131969720661201";
		String[] myAnswer = new String[7];
		myAnswer[1] = inner1001(new BigDecimal("95.123"), 12);
		myAnswer[2] = inner1001(new BigDecimal("0.4321"), 20);
		myAnswer[3] = inner1001(new BigDecimal("5.1234"), 15);
		myAnswer[4] = inner1001(new BigDecimal("6.7592"), 9);
		myAnswer[5] = inner1001(new BigDecimal("98.999"), 10);
		myAnswer[6] = inner1001(new BigDecimal("1.0100"), 12);

		for (int i = 1; i < answer.length; i++) {
			if (!myAnswer[i].equals(answer[i])) {
				System.out.println("std answer" + i + ":" + answer[i]);
				System.out.println("my answer" + i + " :" + myAnswer[i]);
			}
		}
	}

	private static void testNextDecimal() {
		Scanner sc = new Scanner(System.in);
		BigDecimal a = sc.nextBigDecimal();
		BigDecimal b = new BigDecimal("95.123");
		System.out.println(a.toPlainString());
		System.out.println(b.toPlainString());
	}
	public static void main(String[] args) {
//		test1001();
		problem1001();
	}
}
