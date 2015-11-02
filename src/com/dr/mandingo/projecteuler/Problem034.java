package com.dr.mandingo.projecteuler;

/**
 * Digit factorials
 * 
 * ============================================================================
 * 
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * Answer: 40730
 */
public class Problem034 {

	private static Integer[] sFactorial = new Integer[10];

	public static void main(String[] args) {
		int factorial9 = getFactorial(9);
		int gate = 9;
		int n = 1;
		while (true) {
			if (gate < factorial9 * n) {
				gate = gate * 10 + 9;
				n++;
			} else {
				break;
			}
		}
		int sum = 0;
		for (int i = 10; i < gate; i++) {
			int factorialSum = 0;
			String ii = String.valueOf(i);
			for (int j = 0; j < ii.length(); j++) {
				factorialSum += getFactorial(Integer.valueOf(ii.substring(j,
						j + 1)));
			}
			if (factorialSum == i) {
				sum += i;
			}
		}
		System.out.println("the final result is:" + sum);
	}

	public static int getFactorial(int x) {
		if (x < 0 || x > 9) {
			throw new RuntimeException();
		}
		if (sFactorial[x] == null) {
			int factorial = 1;
			for (int i = x; i >= 1; i--) {
				factorial *= i;
			}
			sFactorial[x] = factorial;

		}
		return sFactorial[x];
	}
}
