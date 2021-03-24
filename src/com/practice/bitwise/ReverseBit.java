package com.practice.bitwise;

public class ReverseBit {

	public static void main(String[] args) {
		long number = 3;
		System.out.println(reverseBit(number));

	}

	private static long reverseBit(long n) {

		long rev = 0;
		int bitLenght = 32;
		while (bitLenght > 0) {
			rev = rev << 1; // Shifting one bit to create placeholder

			/**
			 * Checking if last bit of n is 1. If so, update the placeholder with 1, using
			 * XOR operator.
			 * 
			 */
			if ((long) (n & 1) == 1.0) {
				rev = rev ^ 1;
			}
			n = n >> 1; // right shift n
			bitLenght--;
		}

		return rev;
	}

}
