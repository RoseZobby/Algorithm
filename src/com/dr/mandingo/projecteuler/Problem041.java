package com.dr.mandingo.projecteuler;

/**
 * Pandigital prime
 * 
 * ============================================================================
 * 
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 * 
 * Answer: 7652413
 * 
 */
public class Problem041 {

	private static boolean exitFlag = false;

	public static void main(String[] args) {
		int n = 9;
		while (n >= 1) {
			StringBuffer sb = new StringBuffer();
			for (int i = n; i >= 1; i--) {
				sb.append(i);
			}
			digger(sb.toString(), "");
			if (exitFlag) {
				break;
			}
			n--;
		}
	}

	public static void digger(String source, String target) {
		if (!exitFlag) {
			if (source.length() == 1) {
				int lastNumber = Integer.valueOf(source);
				if (lastNumber % 2 != 0) {
					target = target + lastNumber;
					if (isPrime(Integer.valueOf(target))) {
						System.out.println("the result is: " + target);
						exitFlag = true;
					}
				}
			} else {
				for (int i = 0; i < source.length(); i++) {
					String currentSub = source.substring(i, i + 1);
					digger(source.replace(currentSub, ""),
							target.concat(currentSub));

				}
			}
		}
	}

	public static boolean isPrime(long value) {
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
