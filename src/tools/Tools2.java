package tools;

import java.util.ArrayList;
import java.util.Random;

public class Tools2 {

	/**
	 * 输入一个字符串,一个List,将字符串中字符的所有组合填入List中
	 * 
	 * @param str 输入的字符串
	 * @param result 作为结果输出的List
	 * @return 同上
	 */
	public static ArrayList<String> pailiezuhe0(String str,ArrayList<String> result) {
		if (str.length() < 2) {
			String sb = new String(str);
			result.add(sb);
			return result;
		}
		String temp = null;
		result = pailiezuhe0(str.substring(1), result);
		int originSize = result.size();
		for (int index = 0; index != originSize; index++) {
			temp = result.get(0);
			insertChar2String0(str.charAt(0), temp,result);
			result.remove(0);
		}
		return result;
	}

	private static void insertChar2String0(char c,String str,ArrayList<String> result) {
		String temp = null;
		for (int i = 0; i <= str.length(); i ++) {
			temp = str.substring(0,i) + c + str.substring(i);
			//System.out.println(temp);
			result.add(temp);
		}
	}
	
	public static int[] generateArrayWithNoSameNumbers(int len) {
		int[] array = new int[len];
		boolean[] exists = new boolean[len];
		Random ran = new Random();

		for (int i = 0; i < len;) {
			int temp = ran.nextInt(len);
			if (!exists[temp]) {
				exists[temp] = true;
				array[i] = temp;
				i ++;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = generateArrayWithNoSameNumbers(10);
		Tools.printArray(array);
	}
}
