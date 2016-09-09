package com.dr.mandingo.projecteuler;

/**
 * Integer right triangles
 * 
 * ============================================================================
 * 
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 * Answer: 840
 */
public class Problem039 {

	public static void main(String[] args) {
		int maxS = 0;
		int maxP = 0;
		for (int p = 1; p <= 1000; p++) {
			int gateValue = p / 2;
			int counter = 0;
			for (int a = 1; a < gateValue; a++) {
				for (int b = a; b < gateValue; b++) {
					int c = p - a - b;
					if (c > b && c < gateValue && a * a + b * b == c * c) {
						counter++;
					}
				}
			}
			if (counter > maxS) {
				maxS = counter;
				maxP = p;
			}
		}
		System.out.println("p value is: " + maxP);
	}

}
