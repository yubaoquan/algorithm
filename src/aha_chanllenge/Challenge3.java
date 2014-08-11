package aha_chanllenge;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

import tools.Tools;

public class Challenge3 {

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
		for (int i = 3;i <= 20;i ++) {
			result = (int) Tools.minCommonMultiple(result, i);
		}
		return result;
	}

	/**
	 * check whether the two integer parameters contains the same number;
	 * ex. 123 and 321 contains the same numbers 1, 2 and 3, so return true;
	 * 123 and 234 have different numbers 1 and 4  ,so return false.
	 * 122 and 112 ,return false;
	 * @param a
	 * @param b
	 * @return
	 */
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
	
	private static void testContainTheSameNumbers() {
		
	}
	
	public static void main(String[] args) {
		out.println(challenge33());

	}

}
