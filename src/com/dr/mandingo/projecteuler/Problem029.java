package com.dr.mandingo.projecteuler;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Distinct powers
 * 
 * ============================================================================
 * 
 * Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
 * 
 * 2^2=4, 2^3=8, 2^4=16, 2^5=32
 * 
 * 3^2=9, 3^3=27, 3^4=81, 3^5=243
 * 
 * 4^2=16, 4^3=64, 4^4=256, 4^5=1024
 * 
 * 5^2=25, 5^3=125, 5^4=625, 5^5=3125
 * 
 * If they are then placed in numerical order, with any repeats removed, we get
 * the following sequence of 15 distinct terms:
 * 
 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 * 
 * How many distinct terms are in the sequence generated by a^b for 2 ≤ a ≤ 100
 * and 2 ≤ b ≤ 100?
 * 
 * Answer: 9183
 * 
 */
public class Problem029 {

	private static final int MIN = 2;

	private static final int MAX = 100;

	public static void main(String[] args) {

		Set<String> calSet = new HashSet<String>();
		for (int number = MIN; number <= MAX; number++) {
			int cal = 1;
			for (int i = 1; i < MIN; i++) {
				cal *= number;
			}
			String calString = String.valueOf(cal);
			for (int power = MIN; power <= MAX; power++) {
				calString = product(calString, number);
				calSet.add(calString);
			}
		}
		System.out.println("the answer is: " + calSet.size());
	}

	private static String product(String bigDigit, int digit) {
		StringBuffer sb = new StringBuffer(bigDigit);
		int digitResult = 0;
		int carry = 0;
		for (int j = sb.length() - 1; j >= 0; j--) {
			digitResult = Integer.valueOf(sb.substring(j, j + 1)) * digit
					+ carry;
			sb.replace(j, j + 1, String.valueOf(digitResult % 10));
			carry = digitResult / 10;
		}
		if (carry != 0) {
			sb.insert(0, carry);
			carry = 0;
		}
		return sb.toString();
	}

}
