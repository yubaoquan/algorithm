package algorithm;

public class Sort {
	// -----------��������
	public static void qSort(Comparable[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			qSort(a, p, q - 1);
			qSort(a, q + 1, r);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int partition(Comparable[] a, int p, int r) {
		int i = p;
		int j = r + 1;
		Comparable x = a[p];
		while (true) {
			while (a[++i].compareTo(x) < 0 && i < r)
				;
			while (a[--j].compareTo(x) > 0)
				;
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		a[p] = a[j];// ��ʱa[j]��a[p]С,���Խ�a[j]�������,a[p]�����м�
		a[j] = x;
		return j;
	}

	@SuppressWarnings("rawtypes")
	private static void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		return;
	}

	// ------------------���ָ������������İ汾
	@SuppressWarnings("rawtypes")
	private static int randomizedPartition(Comparable[] a, int p, int r) {
		int i = random(p, r);
		swap(a, i, p);
		return partition(a, p, r);
	}

	// ����p,r֮��������
	private static int random(int p, int r) {
		int a = r - p;
		return Math.round((float) Math.random() * a) + p;
	}

	@SuppressWarnings("rawtypes")
	public static void randomizedQuickSort(Comparable[] a, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(a, p, r);
			randomizedQuickSort(a, p, q - 1);
			randomizedQuickSort(a, q + 1, r);
		}

	}

	// ��������
	public static void insertSort(int[] a) {
		int temp;
		int i, j;
		for (i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				temp = a[i];
				for (j = i - 1; j >= 0 && temp < a[j]; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}

	}

	// ϣ������
	public static void shellSort(int[] a, int[] d) {
		/**
		 * dk:ÿ������Ĳ��� 
		 * d:��������
		 */
		int dk;
		int temp;
		int i, j, k;
		for (k = 0; k < d.length; k++) {
			dk = d[k];
			for (i = dk; i < a.length; i++) {
				if (a[i] < a[i - dk]) {
					temp = a[i];
					for (j = i - dk; j >= 0 && temp < a[j]; j -= dk) {
						a[j + dk] = a[j];
					}
					a[j + dk] = temp;
				}
			}
		}
	}

	public static void selectSort(int[] array) {
		for (int i = 0;i < array.length - 1;i++) {
			//int min = array[i];
			int minIndex = i;
			for (int j = i + 1;j < array.length;j++) {
				if (array[minIndex] > array[j]) {
					//min = array[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
	// ��·�鲢
	public static void binaryMergeSort(int[] a) {
		int[] temp = new int[a.length];
		System.arraycopy(a, 0, temp, 0, a.length);
		/*for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}*/
		mergeSort(temp, a, 0, a.length - 1);

	}

	private static void mergeSort(int[] a, int[] a1, int s, int t) {
		// int[] tt = new int[a.length];
		int m;
		if (s == t) {
			a1[s] = a[s];
		} else {
			m = (s + t) / 2;

			mergeSort(a, a1, s, m);
			mergeSort(a, a1, m + 1, t);

			merge(a1, a, s, m, t);
			//copyArray(a1, a);
			System.arraycopy(a, 0, a1, 0, a.length);/*--------------------->��������һ������,���Ǵ˲�
								�һ�����һ�����ʱ��debug,
								�����ҵ�����������.����ݹ鿴��û����,��ʵ����һ���ܶ��ĵ�����,�м�״̬����a1������
								Ӧ���ڶ�����a����merge�Ժ��a����һ��,
								��������һ��merge��ʱ������a�����ݾͻᱻ�޸Ļ�ԭ��
								������,���º����޷�����,��֮���bug��һ���ݹ�bug,a�ڵݹ����mergeSort��ʱ����Ϊa1����,
								����է��һ����Ϊÿ�β����Ƕ�a1���й鲢,��ʵ��a ���Կ��������龰,�����������Ԫ��...*/
		}
	}

	private static void merge(int[] a, int[] target, int s, int m, int t) {
		int i = s;
		int j = m + 1;
		int k = s;
		while (i <= m && j <= t) {
			if (a[i] < a[j]) {
				target[k++] = a[i++];
			} else {
				target[k++] = a[j++];
			}
		}
		while (i <= m) {
			target[k++] = a[i++];
		}
		while (j <= t) {
			target[k++] = a[j++];
		}
	}

	/*
	 * //----------------------------������----------------- HeapSortTest.java��ʵ��
	 */
	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	//�˷����滻ΪSystem.arraycopy()
	public static void copyArray(int[] des, int[] src) {
		for (int i = 0; i < src.length; i++) {
			des[i] = src[i];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = { 1, 0, 32, 5, 8, 3, 100, 2323, 4, 4, 6, 9 };
		int[] b = { 1, 0, 32, 5, 8, 3, 100, 2323, 4, 4, 6, 9 };
		printArray(b);
		selectSort(b);
		printArray(b);
		// int[] b = {1,0,32};//,5,8,3,100,2323,4,4,6,9};
		int[] c = { 5, 3, 1 };
		// insertSort(b);
		// shellSort(b,c);
		/*System.out.println("2luguibing: ");
		binaryMergeSort(b);
		System.out.println("b: ");
		printArray(b);*/
		// Sort.qSort(a, 0, a.length - 1);
		/*
		 * for(Integer i:a){ System.out.print(i + ", "); }
		 */
	}

}
