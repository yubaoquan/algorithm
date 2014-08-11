package aha_chanllenge;

import static java.lang.System.out;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import tools.Tools;

public class Challenge2 {

	private static Logger logger = Logger.getLogger(Challenge2.class);
	// 代表100个灯，true表示灯开着
	private static boolean[] lights = new boolean[100];
	// factorArray[index] 代表index的因子个数
	private static int[] factorArray = new int[87654321];
	static {
		Arrays.fill(lights, true);
	}

	private static void turnTheLight(int pos) {
		lights[pos] = !lights[pos];
	}

	private static void initFactorArray(int[] array) {
		long len = array.length;
		for (int i = 0; i < len; i++) {
			if (i % 10000 == 0) {
				out.print(i + " ");
			}
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					array[i]++;
				}
			}
		}
	}

	/**
	 * 问题地址：http://tz.ahalei.com/problems/view/18
	 */
	private static int xiaoming() {
		for (int i = 1; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (j % i == 0) {
					turnTheLight(j);
				}
			}
		}
		int result = 0;
		for (boolean light : lights) {
			if (light) {
				result++;
			}
		}
		return result;
	}

	private static int xiaoming2() {
		int result = 0;
		initFactorArray(factorArray);
		for (int i : factorArray) {
			if (i % 2 != 0) {
				result++;
			}
		}
		return result;
	}

	private static int findFactor(int number) {
		int result = 0;
		for (int i = 1; i < number; i++) {
			out.println(i);
			if (number % i == 0) {
				out.println("find one \nresult: " + result);
				result++;
			}
		}
		return result;
	}

	/**
	 * 查找第n个素数
	 * 
	 * @param n
	 */
	private static int findTheNthPrime(int n) {
		Challenge1.initPrimeArray();
		int pos = 0;
		for (int i = -1; i != n - 1;) {
			if (Challenge1.booleanPrimeArray[pos++]) {
				i++;
			}
		}
		pos--;
		out.println("the " + n + " prime is " + pos);
		return pos;
	}

	/**
	 * devide number n into two primes
	 * 
	 * @param n
	 * @return
	 */
	private static int gedebahe(int n) {
		int result = 0;
		int middle = n / 2;
		for (int i = 2; i <= n / 2; i++) {
			int j = n - i;
			if (Challenge1.isPrime(i) && Challenge1.isPrime(j)) {
				out.println(i + " + " + j + " = " + n);
				result++;
			}
		}
		out.println("totally " + result + " solutions.");
		return result;
	}

	/**
	 * 克拉子变换，用long是防止溢出
	 * 
	 * @param n
	 * @return
	 */
	private static int kelaziChange(long n) {
		long orin = n;
		int steps = 1;
		while (n != 1) {
			if (n % 2 != 0) {
				n = n * 3 + 1;
			} else {
				n /= 2;
			}
			// out.print(n + " ");
			steps++;
			/*
			 * if (steps > 1000000) { out.println("totally " + steps + " steps, seems like an error."); return steps; }
			 */
		}

		out.println(orin + " totally " + steps + " steps.");
		return steps;
	}

	/**
	 * // findLongestStepsOfKalaziChange(1000000); = long 837799 525 steps //findLongestStepsOfKalaziChange(10000); = int 6171 262 steps
	 * 
	 * @param n
	 */
	private static void findLongestStepsOfKalaziChange(long n) {
		int temp = 0;
		int max = 0;
		int num = 0;
		for (int i = 1; i <= n; i++) {
			temp = kelaziChange(i);
			if (temp > max) {
				max = temp;
				num = i;
			}
		}
		out.println(num + " " + max);
	}

	private static void testLog4j() {
		out.println("begin logging...");
		logger.info(" 这里是测试log4j 的代码");
		out.println("ok");
	}

	private static int hanks(int a0, int a1, int b0, int b1) {
		int result = 0;
		for (int i = 1; i <= b1; i ++) {
			if (Tools.maxDivisor(i, a0) == a1 && Tools.minCommonMultiple(i, b0) == b1) {
				out.print(i + " ");
				result ++;
			}
//			if (i % 40000 == 0) {
//				out.println("\n" + i + " times");
//			}
		}
		out.println();
		return result;
	}
	
	public static void main(String[] args) throws Exception {
//		out.println(hanks(41, 1, 96, 288));
//		testGetNthPrime();
		out.println(hanks(8085, 105, 1532, 11099340));
		
	}

}
