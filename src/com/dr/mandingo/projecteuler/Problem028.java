package com.dr.mandingo.projecteuler;

/**
 * 
 * Number spiral diagonals
 * 
 * ============================================================================
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:
 * 
 * [21] 22 23 24 [25]
 * 
 * 20 [7] 8 [9] 10
 * 
 * 19 6 [1] 2 11
 * 
 * 18 [5] 4 [3] 12
 * 
 * [17] 16 15 14 [13]
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 * 
 * Answer: 669171001
 * 
 */
public class Problem028 {

	private static int SPIRAL_SIZE = 1001;

	private static int MAX_X = SPIRAL_SIZE - 1;

	private int basePointX = (SPIRAL_SIZE - 1) / 2;
	private int basePointY = (SPIRAL_SIZE - 1) / 2;

	private int sum = 0;
	private int currentValue = 1;
	private int offset = 0;

	private int currentPointX = basePointX;
	private int currentPointY = basePointY;

	public static void main(String[] args) {
		Problem028 tar = new Problem028();
		while (true) {
			boolean run = tar.rock();
			if (!run) {
				break;
			}
		}
		tar.printResult();
	}

	public boolean rock() {
		if (currentPointX > basePointX) {
			if (currentPointY < basePointY) {
				if (currentPointX < basePointX + offset) {
					currentPointX++;
				} else {
					if (currentPointY == basePointY - offset) {
						sum += currentValue;
						offset++;
						currentPointX++;
					} else {
						currentPointY++;
					}
				}
			} else if (currentPointY > basePointY) {
				if (currentPointX < basePointX + offset) {
					currentPointX--;
				} else {
					if (currentPointY == basePointY + offset) {
						sum += currentValue;
						currentPointX--;
					} else {
						currentPointY++;
					}
				}
			} else if (currentPointY == basePointY) {
				currentPointY++;
			}
		} else if (currentPointX < basePointX) {
			if (currentPointY > basePointY) {
				if (currentPointX > basePointX - offset) {
					currentPointX--;
				} else {
					if (currentPointY == basePointY + offset) {
						sum += currentValue;
						currentPointY--;
					} else {
						currentPointY--;
					}
				}
			} else if (currentPointY < basePointY) {
				if (currentPointX > basePointX - offset) {
					currentPointX++;
				} else {
					if (currentPointY == basePointY - offset) {
						sum += currentValue;
						currentPointX++;
					} else {
						currentPointY--;
					}
				}
			} else if (currentPointY == basePointY) {
				currentPointY--;
			}
		} else if (currentPointX == basePointX) {
			if (currentPointY > basePointY) {
				currentPointX--;
			} else if (currentPointY < basePointY) {
				currentPointX++;
			} else if (currentPointY == basePointY) {
				sum += currentValue;
				offset++;
				currentPointX++;
			}
		}
		currentValue++;
		if (basePointX + offset <= MAX_X) {
			return true;
		}
		return false;
	}

	public void printResult() {
		System.out.println("the final result is:" + sum);
	}
}
