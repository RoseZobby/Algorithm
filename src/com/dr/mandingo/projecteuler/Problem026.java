package com.dr.mandingo.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Reciprocal cycles
 * 
 * ============================================================================
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2 = 0.5 1/3 = 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8
 * = 0.125 1/9 = 0.(1) 1/10 = 0.1 Where 0.1(6) means 0.166666..., and has a
 * 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * Answer: 983
 * 
 */
public class Problem026 {

	public static void main(String[] args) {
		int recurringCycleSize = 0;
		int value = 0;
		for (int i = 1; i < 1000; i++) {
			String recurringCycleString = getRecurringCycle(1, i,
					new ArrayList<Integer>(), new ArrayList<Integer>());
			if (recurringCycleString.length() > recurringCycleSize) {
				recurringCycleSize = recurringCycleString.length();
				value = i;
			}
		}
		System.out.println("the final result is:"+ value);
	}

	public static String getRecurringCycle(int numerator, int denominator,
			List<Integer> bitResults, List<Integer> bitRemains) {
		numerator *= 10;
		if (numerator % denominator == 0) {// 整除, 无循环
			return "";
		} else {
			int bitResult = (numerator / denominator);
			int bitRemain = (numerator % denominator);
			for (int i = 0; i < bitResults.size(); i++) {
				if (bitResult == bitResults.get(i)
						&& bitRemain == bitRemains.get(i)) {
					StringBuffer sb = new StringBuffer();
					for (int j = i; j < bitResults.size(); j++) {
						sb.append(bitResults.get(j));
					}
					return sb.toString();
				}
			}
			bitResults.add(bitResult);
			bitRemains.add(bitRemain);
			return getRecurringCycle(bitRemain, denominator, bitResults,
					bitRemains);
		}
	}

}
