package com.practice.bitwise;

/**
 * 
 * @author Barun
 *
 * @purpose Find if Kth bit of a number in set or not
 * 
 * @steps 
 *  1. Create a reseter of all bits except for Kth bit. 
 *  2. Apply inputN & bit reseter.
 *  3. If output is 1 -> bit was not set, otherwise bit is set.
 */


public class KthBitSetOrNotUsingLeftShiftOperator {

	public static void main(String[] args) {
		
		int inputN = 5;
		int k = 3;
		
		//step#1 & 2
		int reseter = 1 << (k-1);
		
		//step #3
		if((inputN & reseter) > 0)
			System.out.println("Kth bit is 1.");
		else
			System.out.println("Kth bit is 0.");
		
	}

}
