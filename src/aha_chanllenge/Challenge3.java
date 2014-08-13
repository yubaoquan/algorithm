package aha_chanllenge;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import tools.Tools;

public class Challenge3 {

	@SuppressWarnings("unused")
	private static int findOnes() {
		int result = 0;
		String one = "5923873243257023487032984093274307524832483290484883926752083429174392705780324093811432843025072848289411147329865892374321493289568274329874921247384732008432984032104809327432074362473207403249032848329408329048950923782184032743982638924924083928752083429174392705780324093811432843025072843289461147329865892374321493289568274329874921247324732808432984032104809327432075092378218403274398649326483274972398478392749832694263892492408392675208382917439270578032409381143284302507284328941114732886589237432149328956827432987492124732473200843296403210480932743207509237821840327439826389249240889267520834291743927057803240938114328430250728432694111473298658923743214932895682743298749212473248320084329840321048093274320750923782184032743982668924924083926752083429174392705780324093811432843825072843289411147329865892374321493289568274329878921247324732008432984032104809327432075092378218463274398263892492439827489237489237483243729479832882394893225923873243257023487032984093274307524838";
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) == '1') {
				result++;
			}
		}
		return result;
	}

	@SuppressWarnings("unused")
	private static int addNumbers() {
		int result = 0;
		String numbers = "5923873243257023487032984093274307524832483290484883926752083429174392705780324093811432843025072848289411147329865892374321493289568274329874921247384732008432984032104809327432074362473207403249032848329408329048950923782184032743982638924924083928752083429174392705780324093811432843025072843289461147329865892374321493289568274329874921247324732808432984032104809327432075092378218403274398649326483274972398478392749832694263892492408392675208382917439270578032409381143284302507284328941114732886589237432149328956827432987492124732473200843296403210480932743207509237821840327439826389249240889267520834291743927057803240938114328430250728432694111473298658923743214932895682743298749212473248320084329840321048093274320750923782184032743982668924924083926752083429174392705780324093811432843825072843289411147329865892374321493289568274329878921247324732008432984032104809327432075092378218463274398263892492439827489237489237483243729479832882394893225923873243257023487032984093274307524838";
		for (int i = 0; i < numbers.length(); i++) {
			result += Integer.parseInt(numbers.substring(i, i + 1));
		}
		return result;
	}

	/**
	 * 找一个整数他可以整除1～10之间任意一个整数，并且要求这个整数越小越好——这是整数是2520。如果想找一个可以整除1～20之间任意一个整数，这个整数最小是？
	 * 
	 * @return
	 */
	private static int challenge33() {
		int result = 1;
		for (int i = 3; i <= 20; i++) {
			result = (int) Tools.minCommonMultiple(result, i);
		}
		return result;
	}

	/**
	 * check whether the two integer parameters contains the same number; ex. 123 and 321 contains
	 * the same numbers 1, 2 and 3, so return true; 123 and 234 have different numbers 1 and 4 ,so
	 * return false. 122 and 112 ,return false;
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean containTheSameNumbers(int a, int b) {
		String str1 = String.valueOf(a);
		String str2 = String.valueOf(b);
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		Arrays.sort(str1Array);
		Arrays.sort(str2Array);
		return Arrays.equals(str1Array, str2Array);
	}

	@SuppressWarnings("unused")
	private static void testContainTheSameNumbers() {

	}

	/**
	 * 数组中相邻的两个数相加，和是素数，首尾相加，和也是素数，则返回true
	 * 
	 * @param numbers
	 * @return
	 */
	private static boolean checkSumIsPrime(int[] numbers) {
		int t = numbers[0] + numbers[numbers.length - 1];
		if (!Tools.isPrime(t)) {
			return false;
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			t = numbers[i] + numbers[i + 1];
			if (!Tools.isPrime(t)) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkSumIsPrime(int number) {
		String numberStr = String.valueOf(number);
		int[] array = new int[numberStr.length()];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(numberStr.substring(i, i + 1));
		}
		return checkSumIsPrime(array);
	}


	private static void testCheckSum() {
		int[] array = { 1, 2, 3, 4 };
		int[] array2 = { 4, 4, 4, 4 };
		int a = 1234;
		int b = 4444;
		out.println(checkSumIsPrime(array));
		out.println(checkSumIsPrime(array2));
		out.println(checkSumIsPrime(a));
		out.println(checkSumIsPrime(b));
	}

	private static int challenge20() {
		HashSet<String> parameters = Tools.pailiezuhe("123456");
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (String s : parameters) {
			int temp = Integer.parseInt(s);
			if (checkSumIsPrime(temp)) {
				results.add(temp);
			}
		}
		Collections.sort(results);
		for (Integer i : results) {
			out.println(i);
		}
		return results.get(0);
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private static boolean endWith7(int number) {
		String str = String.valueOf(number);
		return str.charAt(str.length() - 1) == '7';
	}

	private static void testEndwith7() {
		for (int i = 0; i <= 21; i++) {
			out.println(i + " " + endWith7(i));
		}
	}

	private static int challenge16() {
		int result = 0;
		for (int i = 1; i <= 10000000; i++) {
			if (i % 7 == 0 || endWith7(i)) {
				result++;
			}
		}
		return result;
	}

	private static void challenge13() {
		for (int a = 0; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				for (int c = 0; c <= 9; c++) {
					int acb = getANumber(a, c, b);
					int bac = getANumber(b, a, c);
					int bca = getANumber(b, c, a);
					int cab = getANumber(c, a, b);
					int cba = getANumber(c, b, a);
					int sum = acb + bac + bca + cab + cba;
					//out.println(sum);
					if (sum == 2012) {
						out.println(getANumber(a, b, c));
					}
				}
			}
		}
	}

	private static int getANumber(int... numbers) {
		int result = 0;
		for (int number : numbers) {
			result *= 10;
			result += number;
		}
		return result;
	}

	private static void testGetANumber() {
		out.println(getANumber(1, 2, 3, 4));
		out.println(getANumber(1));
		out.println(getANumber(0));
		out.println(getANumber(0, 1, 2, 3, 4));
	}

	public static void main(String[] args) {
		// out.println(challenge16());
//		testGetANumber();
		challenge13();

	}

}
