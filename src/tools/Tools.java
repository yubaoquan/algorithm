package tools;

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
	
	public static void main(String[] args) {
		int[] array = generateArray(30);
		printArray(array);
	}
}
