package algorithm;

public class ChineseChess {

	/**
	 * @param args
	 * ��ӡ��˧�����������п��ܰڷ�λ��
	 */
	public static void main(String[] args) {
		byte i = 81;
		while (i != 0) {
			i --;
			if (i / 9 % 3 == i % 9 % 3) {
				continue;
			}
			System.out.println("A = " +( i / 9 + 1 )+ " B = " +( i % 9 + 1));
		}

	}

}
