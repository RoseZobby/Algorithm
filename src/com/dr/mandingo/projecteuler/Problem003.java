package com.dr.mandingo.projecteuler;

public class Problem003 {

	/**
	 * 
	 * Largest prime factor
	 * 
	 * ========================================================================
	 * 
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 * 
	 * PS:合数的最大质因子不大于它的平方根
	 * 
	 * Answer:6857
	 */
	public static void main(String[] args) {
		long value = 600851475143l;
		long result = 2;
		long max = (long) Math.sqrt(value);
		if (max % 2 == 0) {
			max -= 1;
		}
		for (long i = max; i >= 1; i = i - 2) {
			if (value % i == 0) {
				boolean flag = true;
				for (long j = 3; j < i; j = j + 2) {
					if (i % j == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					result = i;
					break;
				}
			}
		}
		System.out.println("the final result is:" + result);

	}
}
