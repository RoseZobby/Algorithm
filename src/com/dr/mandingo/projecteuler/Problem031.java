package com.dr.mandingo.projecteuler;

/**
 * 
 * Coin sums
 * 
 * ============================================================================
 * 
 * In England the currency is made up of pound, £, and pence, p, and there are
 * eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p). It is possible to make £2
 * in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p How many different ways can £2 be
 * made using any number of coins?
 * 
 * Answer: 73682
 */
public class Problem031 {

	private static int VALUE = 200;

	private static int[] COINS = { 1, 2, 5, 10, 20, 50, 100, 200 };

	private static int[] MAX_PER_COINS = { VALUE / 1, VALUE / 2, VALUE / 5,
			VALUE / 10, VALUE / 20, VALUE / 50, VALUE / 100, VALUE / 200 };

	private static int sCounter = 0;

	public static void main(String[] args) {
		digger(0, COINS.length - 1);
		System.out.println("this final result is:" + sCounter);
	}

	public static void digger(int sum, int index) {
		for (int i = MAX_PER_COINS[index]; i >= 0; i--) {
			int currentSum = sum + COINS[index] * i;
			if (currentSum == VALUE) {
				sCounter++;
			} else if (currentSum > VALUE) {
				continue;
			} else {
				if (index > 0) {
					digger(currentSum, index - 1);
				}
			}
		}
	}
}
