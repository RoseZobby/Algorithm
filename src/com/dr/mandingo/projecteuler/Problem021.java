package com.dr.mandingo.projecteuler;

/**
 * 
 * Amicable numbers
 * 
 * ============================================================================
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * Answer: 31626
 * 
 */
public class Problem021 {

	private static int GATE = 10000;

	private static int[] sDValue = new int[GATE];

	public static void main(String[] args) {
		int result = 0;
		for (int i = 1; i < GATE; i++) {
			sDValue[i] = getDValue(i);
		}

		for (int i = 1; i < GATE; i++) {
			int dValue = sDValue[i];
			if (dValue > i && dValue < GATE && sDValue[dValue] == i) {
				result += (i + dValue);
			}
		}

		System.out.println("the final result is:" + result);
	}

	public static int getDValue(int n) {
		int sumOfDevisors = 0;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				sumOfDevisors += i;
			}

		}
		sumOfDevisors += 1;
		return sumOfDevisors;
	}
}
