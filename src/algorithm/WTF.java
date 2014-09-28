package algorithm;

import java.util.Scanner;
import java.util.Arrays;

class Play implements Comparable {
	int num; // N次测试中出现的数字
	int s; // 此数字在N次测试中出现的次数

	public int compareTo(Object o) {
		Play b = (Play) o;
		if (this.s == b.s) // s相等，按num升序
			return this.num - b.num;
		else
			return b.s - this.s; // 按s从大到小降序排
	}

	public String toString() {
		return "[" + num + "," + s + "]";
	}
}

public class WTF {
	
	private static void method() {
		int n, m;
		Scanner in = new Scanner(System.in);
		while (true) {
			n = in.nextInt();
			m = in.nextInt();
			Play p[] = new Play[10001]; // 数据范围在1-10000,数据i用play[i]来记录相关信息
			for (int i = 0; i < 10001; i++)
				p[i] = new Play();
			int temp;
			if (n == 0 && m == 0)
				break;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					temp = in.nextInt();// 测试中出现的数字

					p[temp].num = temp;// 记录这个数字
					p[temp].s++; // 记录此数字出现的次数
				}
			Arrays.sort(p); // 将p按s降序排序

			int i = 1;

			while (p[i].s == p[i + 1].s) // 从下标1开始输出所有出现次数第二多的数字
			{
				System.out.printf("%d ", p[i].num);
				i++;
			}

			System.out.printf("%d\n", p[i].num);
		}
	}
	
	public static void main(String args[]) {
		method();
	}
}