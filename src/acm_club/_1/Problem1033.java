package acm_club._1;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Problem1033 {

	private static String[] mask = { "11111111", "11111111", "11111111",
			"00000000" };
	
	private static void convertMask(String input) {
		if (input.equals("255.255.255.0")) {
			return;
		}
		String[] t = input.split("\\.");
		for (int i = 0;i < mask.length;i++) {
			String binary = Integer.toBinaryString(Integer.parseInt(t[i]));
			String b = nf.format(Integer.parseInt(binary));
			mask[i] = b;
		}
	}
	
	private static final DecimalFormat nf = new DecimalFormat("00000000");

	private static String getSubnetMask(String ip) {
		String[] array = ip.split("\\.");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			String binary = Integer.toBinaryString(Integer.parseInt(array[i]));
			String b = nf.format(Integer.parseInt(binary));
			String binaryResult = and(mask[i],b);
			int decimal = Integer.parseInt(binaryResult, 2);
			sb.append(decimal);
			sb.append(".");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private static String and(String binary1, String binary2) {
		char[] result = new char[binary1.length()];
		for (int i = 0; i < result.length; i++) {
			if (binary1.charAt(i) == '0' || binary2.charAt(i) == '0') {
				result[i] = '0';
			} else {
				result[i] = '1';
			}
		}
		return new String(result);
	}

	public static void main(String[] args) throws ParseException {
		 Scanner sc = new Scanner(System.in);
		 String hostIP = sc.nextLine();
		 convertMask(sc.nextLine());
		 String hostMask = getSubnetMask(hostIP);
		 int row = Integer.parseInt(sc.nextLine());
		 for (int i = 0;i < row;i++) {
			 String ip = sc.nextLine();
			 if (hostMask.equals(getSubnetMask(ip))) {
				 System.out.println("INNER");
			 } else {
				 System.out.println("OUTER");
			 }
		 }
		 sc.close();
	}
}
