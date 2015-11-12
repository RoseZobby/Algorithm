package com.dr.mandingo.projecteuler;

/**
 * Smallest multiple
 * 
 * ============================================================================
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * Answer: 232792560
 */
public class Problem005 {

	public static void main(String[] args) {
		for (int i = 2520;; i++) {
			for (int j = 20; j > 10; j--) {
				if (j == 11 && i % 11 == 0) {
					System.out.println("the final result is:" + i);
					return;
				} else if (i % j != 0) {
					break;
				}
			}
		}
	}

}
