package com.dr.mandingo.projecteuler;

/**
 * 1000-digit Fibonacci number
 * 
 * ============================================================================
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1. Hence the first 12 terms will be:
 * 
 * F1 = 1 F2 = 1 F3 = 2 F4 = 3 F5 = 5 F6 = 8 F7 = 13 F8 = 21 F9 = 34 F10 = 55
 * F11 = 89 F12 = 144 The 12th term, F12, is the first term to contain three
 * digits.
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000
 * digits?
 * 
 * Answer: 4782
 */
public class Problem025 {

	public static void main(String[] args) {
		int currentIndex = 2;
		String preFibo = "1";
		String posFibo = "1";
		while (posFibo.length() < 1000) {
			int carry = 0;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < preFibo.length(); i++) {
				if (i == preFibo.length() - 1) {
					int digitSum = Integer.valueOf(preFibo.substring(
							preFibo.length() - 1 - i, preFibo.length() - i))
							+ Integer.valueOf(posFibo.substring(0,
									posFibo.length() - i)) + carry;
					sb.insert(0, digitSum);
				} else {
					int digitSum = Integer.valueOf(preFibo.substring(
							preFibo.length() - 1 - i, preFibo.length() - i))
							+ Integer.valueOf(posFibo.substring(
									posFibo.length() - 1 - i, posFibo.length()
											- i)) + carry;
					sb.insert(0, digitSum % 10);
					carry = (digitSum / 10);
				}
			}
			preFibo = posFibo;
			posFibo = sb.toString();
			currentIndex++;
		}
		System.out.print("the final result is:" + currentIndex);
	}

}
