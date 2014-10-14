package acm_club._1051;

import java.util.Scanner;

/**
 * 
 * @author	yubaoquan
 * @Date	2014年10月9日
 * @Description	WA
 *
 */
public class P1072 {

	private static enum Flag {
		TERMINATE, ARITHMETIC, GEOMETRIC, FIBONACCI
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		while (true) {
			for (int i = 0; i < 5; i++) {
				array[i] = sc.nextInt();
			}
			Flag f = getFlag(array);
			switch (f) {
				case TERMINATE:
					sc.close();
					return;
				case ARITHMETIC:
					arithmetic(array);
					break;
				case GEOMETRIC:
					geometric(array);
					break;
				case FIBONACCI:
					febonacci(array);
					break;
				default:
					System.out.println("wtf");
					break;
			}
				System.out.println("" + array[5] + " " +array[6] + " " +array[7] + " " +array[8] + " " +array[9]);
		}
	}

	private static Flag getFlag(int[] array) {
		int[] cha = new int[4];
		double[] shang = new double[4];
		int num = array[4];
		for (int i = 0; i < 4; i++) {
			num += array[i];
			cha[i] = array[i + 1] - array[i]; 
			if (array[i] == 0) {
				shang[i] = -1;
			} else {
				shang[i] = 1.0 * array[i + 1] / array[i];
			}
		}
		if (num == 0) {
			return Flag.TERMINATE;
		}
		if (cha[0] == cha[1] && cha[1] == cha[2] && cha[2] == cha[3]) {
			return Flag.ARITHMETIC;
		}
		if (shang[0] == shang[1] && shang[1] == shang[2] && shang[2] == shang[3]) {
			return Flag.GEOMETRIC;
		}
		return Flag.FIBONACCI;
	}

	private static void arithmetic(int[] array) {
		int cha = array[1] - array[0];
		for (int i = 5; i < array.length; i++) {
			array[i] += array[0] + cha * i;
		}
	}

	private static void geometric(int[] array) {
		int shang = array[1] / array[0];
		for (int i = 5; i < array.length; i++) {
			array[i] = (int) (array[0] * Math.pow(shang, i));
		}
	}

	private static void febonacci(int[] array) {
		for (int i = 5; i < array.length; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
	}
}
