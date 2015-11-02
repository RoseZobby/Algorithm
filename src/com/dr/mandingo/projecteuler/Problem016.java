package com.dr.mandingo.projecteuler;

/**
 * Power digit sum
 * 
 * ============================================================================
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * Answer: 1366
 */
public class Problem016 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("1");
		int carry = 0;
		for (int i = 0; i < 1000; i++) {
			int digitResult = 0;
			for (int j = sb.length() - 1; j >= 0; j--) {
				digitResult = Integer.valueOf(sb.substring(j, j + 1)) * 2
						+ carry;
				sb.replace(j, j + 1, String.valueOf(digitResult % 10));
				carry = digitResult / 10;
			}
			if (carry != 0) {
				sb.insert(0, carry);
				carry = 0;
			}
		}

		int sum = 0;
		for (int i = 0; i < sb.length(); i++) {
			sum += Integer.valueOf(sb.substring(i, i + 1));
		}

		System.out.print("the final result is:" + sum);
	}

}
