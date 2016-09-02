package com.dr.mandingo.projecteuler;

/**
 * Self powers
 * 
 * ============================================================================
 * 
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 * 
 * Answer: 9110846700
 */
public class Problem048 {

	private static final int MAX_NUM = 1000;

	private static final int LAST_LENGTH = 10;

	public static void main(String[] args) {
		String[] products = new String[MAX_NUM];
		for (int i = 0; i < MAX_NUM; i++) {
			products[i] = product(i + 1, LAST_LENGTH);
		}
		System.out.println("the answer is:" + sum(products, LAST_LENGTH));
	}

	private static String product(int digit, int lastLength) {
		StringBuffer sb = new StringBuffer("1");
		int carry = 0;
		for (int i = 0; i < digit; i++) {
			int digitResult = 0;
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
			if (sb.length() > lastLength) {
				sb = sb.delete(0, sb.length() - lastLength);
			}
		}
		return sb.toString();
	}

	private static String sum(String[] products, int lastLength) {
		if (products == null || products.length == 0) {
			return "0";
		} else if (products.length == 1) {
			return products[0].length() > lastLength ? products[0]
					.substring(products[0].length() - lastLength) : products[0];
		} else {
			for (int i = 0; i < products.length; i++) {
				String current = products[i];
				if (current.length() > lastLength) {
					products[i] = current.substring(current.length()
							- lastLength);
				} else if (current.length() < lastLength) {
					while (current.length() < lastLength) {
						current = "0" + current;
					}
					products[i] = current;
				}
			}

			int carry = 0;
			StringBuffer sb = new StringBuffer();
			for (int i = lastLength - 1; i >= 0; i--) {
				int digitSum = 0;
				for (int j = 0; j < products.length; j++) {
					digitSum += Integer
							.valueOf(products[j].substring(i, i + 1));
				}
				digitSum += (carry % 10);
				carry = carry / 10;
				sb.insert(0, digitSum % 10);
				carry += (digitSum / 10);
			}
			if (carry != 0) {
				sb.insert(0, carry);
			}
			return sb.substring(sb.length() - lastLength);
		}
	}

}
