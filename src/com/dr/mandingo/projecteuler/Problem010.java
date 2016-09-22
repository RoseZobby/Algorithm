package com.dr.mandingo.projecteuler;

/**
 * Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * Answer:142913828922
 */
public class Problem010 {

	public static void main(String[] args) {
		int current = 3;
		long sum = 2;
		while (true) {
			if (current < 2000000) {
				if (isPrime(current)) {
					sum += current;
				}
				current += 2;
			} else {
				break;
			}
		}
		System.out.println("this final result is:" + sum);
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
