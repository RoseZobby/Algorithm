package com.dr.mandingo.projecteuler;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Truncatable primes
 * 
 * ============================================================================
 * 
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * Answer: 748317
 * 
 */
public class Problem037 {

	public static void main(String[] args) {
		int counter = 0;
		int sum = 0;
		Set<Integer> primeSet = new HashSet<Integer>();
		primeSet.add(2);
		primeSet.add(3);
		primeSet.add(5);
		primeSet.add(7);

		for (int i = 11;; i = i + 2) {
			if (!primeSet.contains(i) && !isPrime(i)) {
				continue;
			} else {
				primeSet.add(i);
			}
			String number = String.valueOf(i);
			boolean isTruncatable = true;

			for (int j = 1; j < number.length(); j++) {
				int subNumber = Integer.valueOf(number.substring(0, j));
				if (!primeSet.contains(subNumber) && !isPrime(subNumber)) {
					isTruncatable = false;
					break;
				}
			}

			if (!isTruncatable) {
				continue;
			}

			int lastIndex = number.length();
			for (int j = lastIndex - 1; j > 0; j--) {
				int subNumber = Integer.valueOf(number.substring(j, lastIndex));
				if (!primeSet.contains(subNumber) && !isPrime(subNumber)) {
					isTruncatable = false;
					break;
				}
			}

			if (!isTruncatable) {
				continue;
			}
			counter++;
			sum += i;

			if (counter == 11) {
				break;
			}
		}

		System.out.println(">>>" + sum);
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
