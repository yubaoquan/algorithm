package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

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

		for (int i = 0; i < len; i++) {
			array[i] = ran.nextInt(len);
		}
		return array;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
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
				int factor = getNthPrime(i);
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
	 * 判断一个数是否为质数，如果质数数组填充完毕且这个数在数组的范围内，则到数组 中查找，如果数组未填充完毕，则用计算的方法来判断；
	 * 
	 * @param number
	 *            要判断的数
	 * @return 是质数则返回true
	 */
	public static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}

		if (number >= BOOL_PRIME_ARRAY_SIZE || !primeArrayInitialed) {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		} else {
			return booleanPrimeArray[number];
		}
	}

	@SuppressWarnings("unused")
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
		result = a / maxDivisor(a, b) * b;// avoid integer overflow
		return result;
	}

	private static final int BOOL_PRIME_ARRAY_SIZE = 1000000;
	private static final int INT_PRIME_ARRAY_SIZE = BOOL_PRIME_ARRAY_SIZE / 20;

	// 质数数组，质数的位置为TRUE，合数的位置为FALSE
	public static boolean[] booleanPrimeArray = new boolean[BOOL_PRIME_ARRAY_SIZE];
	private static int[] intPrimeArray = new int[INT_PRIME_ARRAY_SIZE];
	private static boolean primeArrayInitialed = false;

	private static void initBoolPrimeArray() {
		int lastPrime = 0;
		int temp = lastPrime;
		for (int i = 0; i < BOOL_PRIME_ARRAY_SIZE; i++) {
			for (; temp < BOOL_PRIME_ARRAY_SIZE; temp++) {
				if (isPrime(temp)) {
					booleanPrimeArray[temp] = true;
					lastPrime = temp;
					temp++;
					break;
				}
			}
		}
	}

	private static void initIntPrimeArray() {
		int pos = 0;
		for (int i = 0; i < intPrimeArray.length; i++) {
			while (!booleanPrimeArray[pos]) {
				pos++;
			}
			intPrimeArray[i] = pos;
			pos++;
		}
	}

	/**
	 * 素数从小到大排列， 获取第n个素数
	 * 
	 * @param n
	 * @return
	 */
	public static int getNthPrime(int n) {
		if (n > INT_PRIME_ARRAY_SIZE) {
			out.println(n + " is too big.");
			throw new IndexOutOfBoundsException();
		}
		initPrimeArray();
		return intPrimeArray[n];
	}

	public static void initPrimeArray() {
		if (primeArrayInitialed) {
			return;
		}
		initBoolPrimeArray();
		initIntPrimeArray();
		primeArrayInitialed = true;
	}

	/**
	 * 返回字符串中字母的所有排列组合
	 * @param input
	 * @return
	 */
	public static HashSet<String> pailiezuhe(String input) {
		HashSet<String> result = new HashSet<>();
		if (input.length() <= 1) {
			result.add(input);
			return result;
		}

		for (int j = 0; j < input.length(); j++) {
			String prefix = input.substring(0, j);
			String suffix = input.substring(j + 1);
			String tempInputStr = prefix + suffix;
			// out.println(tempInputStr);
			char ch = input.charAt(j);
			HashSet<String> temp = pailiezuhe(tempInputStr);

			for (String string : temp) {
				result.addAll(insertChar2String(string, ch));
			}
		}
		return result;
	}
	
/**
 * insert character ch into a position of the target string,
 * return all the possible results
 * @param target
 * @param ch
 * @return
 */
	private static ArrayList<String> insertChar2String(String target, char ch) {
		ArrayList<String> result = new ArrayList<>();
		result.add(ch + target);
		result.add(target + ch);
		for (int i = 0; i < target.length(); i++) {
			String temp = target.substring(0, i) + ch + target.substring(i);
			result.add(temp);
		}
		return result;
	}

	private static void testPailiezuhe() {
		HashSet<String> results = pailiezuhe("abcdef");
		for (String str : results) {
			out.println(str);
		}
	}

	private static void testInsertChar() {
		String target = "hello world!";
		char ch = '*';
		ArrayList<String> result = insertChar2String(target, ch);
		for (String str : result) {
			out.println(str);
		}
	}

	public static void main(String[] args) {
		int[] array = generateArray(30);
		printArray(array);
	}
}
