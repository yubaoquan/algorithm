package tools;

import java.util.ArrayList;
import java.util.Random;

import aha_chanllenge.Challenge1;
import static java.lang.System.*;

public class Tools {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int[] generateArray(int len) {
		int[] array = new int[len];
		Random ran = new Random();
		
		for (int i = 0; i < len; i ++) {
			array[i] = ran.nextInt(len);
		}
		return array;
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i ++) {
			out.print(array[i] + "\t");
			if ((i + 1) % 10 == 0 && i > 0) {
				out.println();
			}
		}
		out.println();
	}
	
	/**
	 * 因式分解
	 * 
	 * @param input
	 * @return input 的所有素因子
	 */
	public static ArrayList<Integer> yinshifenjie(int input) {
		ArrayList<Integer> factors = new ArrayList<>();
		if (input < 2) {
			factors.add(input);
			return factors;
		}
		for (; input != 1;) {
			for (int i = 0; i < input; i++) {
				int factor = Challenge1.getNthPrime(i);
				if (input % factor == 0) {
					factors.add(factor);
					input /= factor;
					break;
				}
			}
		}
		return factors;
	}
	
	/**
	 * 测试因式分解方法
	 */
	private static void testYSFJ() {
		ArrayList<Integer> factors = null;
		for (int i = 0; i < 20; i++) {
			factors = Tools.yinshifenjie(i);
			out.println(i);
			printFactors(factors);
			out.println();
		}
	}

	private static void printFactors(ArrayList<Integer> factors) {
		for (int i : factors) {
			out.print(i + " ");
		}
	}
	
	
	/**
	 * 求a 和 b 的最大公约数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int maxDivisor(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		if (a % b == 0) {
			return b;
		}
		if (b % a == 0) {
			return a;
		}
		int t;
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}
		t = a % b;
		while (t > 0) {
			a = b;
			b = t;
			t = a % b;
		}
		return b;
	}

	/**
	 * 求 a 和 b 的最小公倍数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long minCommonMultiple(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		if (a % b == 0) {
			return a;
		}
		if (b % a == 0) {
			return b;
		}
		long result = 1;
		result = a / maxDivisor(a, b) * b ;//avoid integer overflow
		return result;
	}

	/**
	 * 测试最小公倍数方法 test the function minCommonMultiple(int a, int b)
	 */
	private static void testMinCommonMultiple() {
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				out.println("[" + i + ", " + j + "]: " + minCommonMultiple(i, j));
			}
		}
	}

	/**
	 * 测试最大公约数方法。
	 * test the maxDivisor(int, int) method.
	 */
	private static void testMaxDivisor() {
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				out.println("[" + i + ", " + j + "]: " + maxDivisor(i, j));
			}
		}
	}

/**
 * 测试获取第n个素数方法
 */
	private static void testGetNthPrime() {
		for (int i = 0; i < 21;i ++) {
			out.println(Challenge1.getNthPrime(i));
		}
	}
	
	public static void main(String[] args) {
		int[] array = generateArray(30);
		printArray(array);
	}
}
