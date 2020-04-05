package com.practice.bitwise;

/**
 * 
 * @author Barun
 *
 * @purpose Find if Kth bit of a number in set or not
 * 
 * @steps 
 *  1. Right shift the input number with (k-1), idea is to shift the Kth bit to last. 
 *  2. Do inputN & 1.
 *  3. If output is 1 -> bit was not set, otherwise bit is set.
 */


public class KthBitSetOrNotUsingRightShiftOperator {

	public static void main(String[] args) {
		
		int inputN = 13;
		int k = 3;
		
		//step#1 & 2
		int bitShiftedNumber = inputN >> (k-1);
		
		//step #3
		if((bitShiftedNumber & 1) > 0)
			System.out.println("Kth bit is 1.");
		else
			System.out.println("Kth bit is 0.");
		
	}

}
