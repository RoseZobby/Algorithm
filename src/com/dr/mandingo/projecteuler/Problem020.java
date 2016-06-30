package com.dr.mandingo.projecteuler;

/**
 * 
 * Factorial digit sum
 * 
 * ============================================================================
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * Answer:
 * 
 */
public class Problem020 {

	public static void main(String[] args) {
		String number = "1";
		String[] bitMultiplieResults;
		for (int i = 2; i <= 100; i++) {
			String currentNumber = String.valueOf(i);
			bitMultiplieResults = new String[currentNumber.length()];
			for (int j = 0; j < currentNumber.length(); j++) {
				String bitMultiplieResult = bitMultiplie(number,
						Integer.valueOf(currentNumber.substring(j, j + 1)));
				int k = currentNumber.length() - 1 - j;
				while (k > 0) {
					bitMultiplieResult += "0";
					k--;
				}
				bitMultiplieResults[j] = bitMultiplieResult;
			}
			number = bitMultiplieResults[0];
			for (int j = 1; j < bitMultiplieResults.length; j++) {
				number = bitSum(number, bitMultiplieResults[j]);
			}

		}
		System.out.println(number);
		int sum = 0;

		for (int i = 0; i < number.length(); i++) {
			sum += Integer.valueOf(number.substring(i, i + 1));

		}
		System.out.println("the final result is: " + sum);

	}

	public static String bitMultiplie(String number, int bitDigital) {
		StringBuffer result = new StringBuffer();
		if (bitDigital == 0) {
			return "";
		} else if (bitDigital == 1) {
			return number;
		} else {
			int carry = 0;
			int bit = 0;
			for (int i = number.length() - 1; i >= 0; i--) {
				bit = bitDigital * Integer.valueOf(number.substring(i, i + 1))
						+ carry;
				carry = bit / 10;
				result.insert(0, bit % 10);
			}
			if (carry != 0) {
				result.insert(0, carry);
			}
			return result.toString();
		}
	}

	public static String bitSum(String number1, String number2) {
		StringBuffer result = new StringBuffer();
		if (number1.length() > number2.length()) {
			String temp = number2;
			number2 = number1;
			number1 = temp;
		}
		int carry = 0;
		int bit = 0;
		int offset = number2.length() - number1.length();
		for (int i = number1.length() - 1; i >= 0; i--) {
			bit = Integer.valueOf(number1.substring(i, i + 1))
					+ Integer.valueOf(number2.substring(i + offset, i + offset
							+ 1)) + carry;
			carry = bit / 10;
			result.insert(0, bit % 10);
		}
		if (carry == 0) {
			result.insert(0, number2.substring(0, offset));
		} else {
			for (int i = offset - 1; i >= 0; i--) {
				bit = Integer.valueOf(number2.substring(i, i + 1)) + carry;
				carry = bit / 10;
				result.insert(0, bit % 10);
			}
			if (carry != 0) {
				result.insert(0, carry);
			}
		}
		return result.toString();
	}
}
