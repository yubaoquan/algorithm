package aha_chanllenge;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Challenge1 {

	private static void test() {
		/*
		 * out.println(Math.sqrt(9)); isPrime(9);
		 */
		//out.println(Integer.MAX_VALUE);
		int[] array = new int[10];
		out.println(array[0]);
		changeArray(array);
		out.println(array[0]);
	}

	private static void changeArray(int[] array) {
		array[0] = 250;
	}
	
	
	private static int findMaximumInteger() {
		int handredDigit, tenDigit, oneDigit;
		int result = 0;
		for (handredDigit = 9; handredDigit >= 1; handredDigit--) {
			for (tenDigit = 9; tenDigit >= 0; tenDigit--) {
				for (oneDigit = 9; oneDigit >= 0; oneDigit--) {
					int addResult = oneDigit + 10 * tenDigit + 100 * handredDigit;
					int powResult = (int) (Math.pow(oneDigit, 3) + Math.pow(tenDigit, 3) + Math.pow(handredDigit, 3));
					if (powResult == addResult) {
						out.println(powResult);
						result = powResult;
						return result;
					}
				}
			}
		}
		return result;
	}

	private static int fbnqSeqence() {
		int result = 0;
		int a = 1;
		int b = 1;
		for (int i = 2; i < 45; i++) {
			result = a + b;
			a = b;
			b = result;
		}
		return result;
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			// out.println("number: " + number + " i: " + i);
			if (number % i == 0) {
				return false;
			}
		}
		// out.print("number: " + number + ' ');
		return true;
	}

	private static int findPrime() {
		int result = 0;
		for (int i = 2; i <= 12345; i++) {
			if (isPrime(i)) {
				result++;
			}
		}
		return result;
	}

	private static int addPrimes() {
		int result = 0;
		for (int i = 2; i <= 100; i++) {
			if (isPrime(i)) {
				result += i;
			}
		}
		return result;
	}

	private static int seven() {
		int result = 0;
		for (int i = 0; i < 123456; i++) {
			if (checkSeven(i)) {
				result += i;
			}
		}
		return result;
	}

	private static boolean checkSeven(int number) {
		if (number % 7 == 0 || number % 10 == 7) {
			return true;
		} else {
			return false;
		}
	}

	private static int findMaximumPrimeFactor(int number) {
		int result = 0;
		int sqrt = (int) Math.sqrt(number);
		for (int i = 2; i <= sqrt; i++) {
			if (number % i == 0) {
				out.print(i + " ");
				if (i > result) {
					result = i;
				}
				if (number == i) {
					return result;
				}
				number /= i;
				out.println(number);
				i = 2;
			}
		}
		if (isPrime(number) && number > result) {
			return number;
		}
		return result;
	}

	private static int yanhualiaoluan() {
		int result = 0;
		int temp = 0;
		String bigNumber = "2421902267105562632111110937054421750694165896040884580156166097919133875499200524063689912560717606178664583591245665294765456828489128831426076900428586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776058861164671094050775410022569831552000559357297255258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586657273330010533678812202354218097512545405947522437316717653133062491922511967442657474235534919493407198403850962455444362981230987879927244284909188668966489504452445231617318564030987111217223831139698352031277450632623957831801698480186947885184371636269561882670428252483600823257530420752963450";
		for (int i = 0; i < 995; i ++) {
			if (Integer.parseInt(bigNumber.substring(i, i + 1)) == 9) {
				temp = Integer.parseInt(bigNumber.substring(i, i + 5));
				if (temp > result) {
					result = temp;
				}
			}
		}
		return result;
	}
	
	private static int yanhualiaoluan2() {
		int result = 0;
		int a, b, c, d, e, temp = 0;
		String bigNumber = "2421902267105562632111110937054421750694165896040884580156166097919133875499200524063689912560717606178664583591245665294765456828489128831426076900428586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776058861164671094050775410022569831552000559357297255258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586657273330010533678812202354218097512545405947522437316717653133062491922511967442657474235534919493407198403850962455444362981230987879927244284909188668966489504452445231617318564030987111217223831139698352031277450632623957831801698480186947885184371636269561882670428252483600823257530420752963450";
		for (int i = 0; i < 995; i ++) {
			 a = Integer.parseInt(bigNumber.substring(i, i + 1));
			 b = Integer.parseInt(bigNumber.substring(i + 1, i + 2));
			 c = Integer.parseInt(bigNumber.substring(i + 2, i + 3));
			 d = Integer.parseInt(bigNumber.substring(i + 3, i + 4));
			 e = Integer.parseInt(bigNumber.substring(i + 4, i + 5));
			temp = a * b * c * d * e;
			if (temp > result) {
				result = temp;
			}
		}
		return result;
	}

	static class FiveNumbers implements Comparable {
		private int[] numbers;
		private int product;

		FiveNumbers(int n1, int n2, int n3, int n4, int n5) {
			numbers[0] = n1;
			numbers[1] = n2;
			numbers[2] = n3;
			numbers[3] = n4;
			numbers[4] = n5;
			this.product = numbers[0] * numbers[1] * numbers[2] * numbers[3] * numbers[4];
		}

		public int getProduct() {
			return product;
		}

		public int calculateProduct() {
			return numbers[0] * numbers[1] * numbers[2] * numbers[3] * numbers[4];
		}

		@Override
		public int compareTo(Object arg0) {
			FiveNumbers another = (FiveNumbers) arg0;
			if (product < another.getProduct()) {
				return -1;
			} else if (product > another.getProduct()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	private static int luanShengZhiShu(int start, int end) {
		int result = 0;
		for (int i = start; i < end - 2; i++) {
			if (isPrime(i) && isPrime(i + 2)) {
				result++;
			}
		}
		return result;
	}

	private static int monkey() {
		int result = 1;
		for (int i = 0; i < 9; i++) {
			result += 1;
			result *= 2;
		}
		return result;
	}

	private static int climbStairs(int stairNumber) {
		switch (stairNumber) {
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 4;
			default:
				return climbStairs(stairNumber - 1) + climbStairs(stairNumber - 2) + climbStairs(stairNumber - 3);
		}
	}

	/**
	 * devide a String which is made up of numbers into four parts. Multiply the
	 * four parts. find the maximum result.
	 * 
	 * @param str
	 *            the target String
	 * @return the maximum result
	 */
	private static long devideStringIntoFourNumbers(String str) {
		if (str.length() < 4) {
			return 0;
		}
		long result = 0;
		long left = 0;
		long right = 0;
		for (int middle = 1; middle < str.length(); middle++) {
			long leftNumber = devideStringIntoTwoNumbers(str.substring(0, middle));
			long rightNumber = devideStringIntoTwoNumbers(str.substring(middle));
			out.println();
			long temp = leftNumber * rightNumber;
			out.println("temp: " + temp);
			if (temp > result) {
				result = temp;
				left = leftNumber;
				right = rightNumber;
			}
		}
		// out.println("left: " + left + " right: " + right);
		return result;
	}

	/**
	 * devide a String which is made up of numbers into two parts. Multiply the
	 * two parts. find the maximum result.
	 * 
	 * @param str
	 *            the target String
	 * @return the maximum result
	 */
	private static int devideStringIntoTwoNumbers(String str) {
		out.println("str: " + str);
		if (str == null || str.length() == 0) {
			return 0;
		}
		if (str.length() == 1) {
			return Integer.parseInt(str);
		}
		int result = 0;
		for (int i = 1; i < str.length(); i++) {
			int leftNumber = Integer.parseInt(str.substring(0, i));
			int rightNumber = Integer.parseInt(str.substring(i));
			out.print(" left: " + leftNumber + " right: " + rightNumber);
			int temp = rightNumber * leftNumber;
			if (temp > result) {
				result = temp;
			}
		}
		return result;
	}

	private static long devideStringIntoFourNumbers2(String str) {
		long result = 0;
		long[] fourNumbers = new long[4];
		int[] numbers = new int[str.length()];
		int maximumNumberAmount;
		int maximumNumber = 0;
		maximumNumber = getMaximumNumber(str);
		maximumNumberAmount = recordMaximumNumbers(str, numbers, maximumNumber);
		int[] bigNumbers = new int[maximumNumberAmount];
		for (int i = 0; i < maximumNumberAmount; i ++) {
			//bigNumbers[i] = Integer.parseInt(str.substring(i, number))
		}
		return result;
	}

	private static int recordMaximumNumbers(String str, int[] numbers, int maximumNumber) {
		for (int i = 0, max = maximumNumber; true; max--) {
			for (int j = 0; j < str.length(); j++) {
				int temp = Integer.parseInt(str.charAt(j) + "");
				if (temp == max) {
					numbers[i] = temp;
					i++;
				}
			}
			if (i >= 4) {
				return i;
			}
		}
	}

	/**
	 * get the maximum number in the string
	 * 
	 * @param str
	 * @return
	 */
	private static int getMaximumNumber(String str) {
		int maximumNumber = 0;
		for (int i = 0; i < str.length(); i++) {
			int temp = Integer.parseInt(str.charAt(i) + "");
			if (temp > maximumNumber) {
				maximumNumber = temp;
			}
		}
		return maximumNumber;
	}

	public static void main(String[] args) {
//		 test();
		// out.println("the biggest integer is : " + findMaximumInteger());
		// out.println("the 45th number of fbnq seqence is : " + fbnqSeqence());
		// out.println("totally " + findPrime() + " odd numbers");
		// out.println("prime added from 2 to 100 is " + addPrimes());
		// out.println("seven add: " + seven());
		// out.println("maximum prime factor of 987654321 is " +
		// findMaximumPrimeFactor(987654321));
		// out.println("100到200之间的孪生质数有 " + luanShengZhiShu(100, 200) + " 对。");
		// out.println("the monkey has " + monkey() + " peaches.");
		// out.println("totally " + climbStairs(36) +
		// " methods to climb the stairs.");
		// out.println("the maximum result of the string is " +
		// devideStringIntoFourNumbers("123456789"));
//		out.println("the maximum result of the string is " + devideStringIntoFourNumbers("5483298756"));
		out.println("result of yanhualiaoluan is " + yanhualiaoluan());
	
	
	}

}
