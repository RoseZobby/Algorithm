package com.dr.mandingo.projecteuler;

/**
 * Largest palindrome product
 * 
 * ============================================================================
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * Answer: 906609
 */
public class Problem004 {

	public static void main(String[] args) {
		int target = 0;
		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--) {
				int product = i * j;
				if (target > product) {
					break;
				}
				if (isPalindromicNumber(product)) {
					target = product;
					break;
				}
			}
		}
		System.out.print("the final resulit is:" + target);
	}

	private static boolean isPalindromicNumber(int number) {
		String numberStr = String.valueOf(number);
		int i = 0;
		int j = numberStr.length() - 1;
		while (i <= j) {
			if (numberStr.charAt(i) != numberStr.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
