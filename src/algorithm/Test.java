package algorithm;

import stdlib.StdDraw;
import stdlib.StdOut;
import tools.Tools;

public class Test {

	private static void modifyArray(int[] array) {
		array[1] = 999;
	}
	
	private static void testModigyArrays() {
		int[] array = {1,2,3};
		Tools.printArray(array);
		modifyArray(array);
		Tools.printArray(array);
	}
	
	private static void testMod64(int input) {
		int mod64 = input % 64;
		int mod8 = input % 8;
		System.out.println(input + "mod64=" + mod64);
		System.out.println(input + "mod8=" + mod8);
		System.out.println("==============");
	}
	
	public static void main(String[] args) {
		testMod64(56);
		testMod64(16);
		testMod64(57);
		testMod64(17);
	}

}
