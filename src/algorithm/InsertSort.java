package algorithm;

import tools.Tools;

public class InsertSort {

	private static void insertSort(int[] array) {
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			for (j = i - 1; j >= 0 && array[j] >= temp; j--) {
				array[j + 1] = array[j];//循环的第一次，array[i]的值就被修改了，所以要预先保存在temp中
			}
				array[j+1] = temp;
		}
	}

	private static int[] mergeSort(int[] array) {
		if (array.length == 1) {
			return array;
		}
		int middle = array.length / 2;
		int[] arrayLeft = new int[middle];
		int[] arrayRight = new int[array.length - middle];
		System.arraycopy(array, 0, arrayLeft, 0, middle);
		System.arraycopy(array, middle, arrayRight, 0, arrayRight.length);
		arrayLeft = mergeSort(arrayLeft);
		arrayRight = mergeSort(arrayRight);
		array = merge(arrayLeft, arrayRight);
		return array;
	}
	
	private static int[] merge(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		for (;i < array1.length && j < array2.length;) {
			if (array1[i] <= array2[j]) {
				result[k ++] = array1[i ++];
			} else {
				result[k ++] = array2[j ++];
			}
		}
		if (i == array1.length) {
			for (;j < array2.length;) {
				result[k ++] = array2[j ++];
			}
		}
		if (j == array2.length) {
			for (;i < array1.length;) {
				result[k ++] = array1[i ++];
			}
		}
		return result;
	}
	
	private static void testInsertSort() {
		int[] array = Tools.generateArray(10);
		Tools.printArray(array);
		insertSort(array);
		Tools.printArray(array);
	}

	private static void testMerge() {
		int[] array1 = {10};
		int[] array2 = {6};
		int[] result = merge(array1, array2);
		Tools.printArray(result);
	}
	
	private static void testMergeSort() {
		int[] array = Tools.generateArray(10);
		//array = new int[]{2, 1};
		Tools.printArray(array);
		array = mergeSort(array);
		Tools.printArray(array);
	}
	public static void main(String[] args) {
		testMergeSort();
	}

}
