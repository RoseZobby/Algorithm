package com.dr.mandingo.projecteuler;

/**
 * 10001st prime
 * 
 * ============================================================================
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * PS:合数的最大质因子不大于它的平方根
 * 
 * Answer: 104743
 * 
 */
public class Problem007 {

	public static void main(String[] args) {
		int current = 3;
		int counter = 1;
		while (true) {
			if (counter < 10001) {
				if (isPrime(current)) {
					counter++;
				}
				current += 2;
			} else {
				System.out.println("the final result is: " + (current - 2));
				break;
			}
		}
	}

	public static boolean isPrime(long value) {
		if (value <= 1) {
			return false;
		} else if (value == 2) {
			return true;
		} else if (value % 2 == 0) {
			return false;
		} else {
			long factor = 1;
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
						factor = i;
						break;
					}
				}
			}
			return factor == 1;
		}
	}

}
