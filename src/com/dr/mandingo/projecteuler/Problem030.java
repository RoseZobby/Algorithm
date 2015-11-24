package com.dr.mandingo.projecteuler;

/**
 * 
 * Digit fifth powers
 * 
 * ============================================================================
 * 
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * Answer: 443839
 */
public class Problem030 {

	private static Integer[] sFifthPowerDatas = new Integer[10];

	public static void main(String[] args) {
		long maxNumber = 0;
		for (int i = 1;; i++) {
			maxNumber = 0;
			long maxFifthSum = 0;
			for (int j = 0; j < i; j++) {
				maxNumber = maxNumber * 10 + 9;
				maxFifthSum = maxFifthSum + getFifthPowers(9);
			}
			if (maxNumber > maxFifthSum) {
				break;
			}
		}
		int sum = 0;
		for (long i = 2; i < maxNumber; i++) {
			long fifthSum = 0;
			long value = i;
			while (true) {
				fifthSum += getFifthPowers((int) (value % 10));
				value = value / 10;
				if (value == 0) {
					break;
				}
			}
			if (fifthSum == i) {
				System.out.println("got a number:" + i);
				sum += i;
			}
		}
		System.out.println("the final result is:" + sum);
	}

	public static int getFifthPowers(int digit) {
		if (sFifthPowerDatas[digit] == null) {
			int fifthPowers = 1;
			for (int i = 0; i < 5; i++) {
				fifthPowers *= digit;
			}
			sFifthPowerDatas[digit] = fifthPowers;
		}
		return sFifthPowerDatas[digit];
	}

}
