package com.practice.bitwise;

/**
 * 
 * @author Barun
 *
 * @purpose Count of set (or 1) in binary of a number
 * 
 * Time complexities
 *   Approach 1 and 2:  Theta(total number of bit in number)
 *   Approach 3 using Brian and Kerningham: Theta (total number of set bit in number)
 *   Approach 4: takes Theta(1) time, but requires some preprocessing
 */

public class CountSetBits {

	public static void main(String[] args) {
		int inputN = 13;
		int count = 0;
		boolean isFirst = true;
		int copyInputN = inputN;
		//Approach 1
		while(inputN > 0) {
			if(isFirst) {
				if((inputN & 1) > 0)
					count++;
				isFirst = false;
				continue;
			}
			inputN = inputN >> 1;
			if((inputN & 1) > 0)
				count++;
		}
		
		System.out.println("Approach1 - Total number of set bits are: "+count);

		//Approach 2
		
		count=0;
		inputN =  copyInputN;
		while(inputN > 0 ) {
			count = count + (inputN & 1);
			inputN = inputN >> 1; // or inputN = inputN / 2 
		}
		System.out.println("Approach2 - Total number of set bits are: "+count);

		//Approach 3 Brian and Kerningham

		count=0;
		inputN =  copyInputN;
		while(inputN > 0 ) {
			inputN =  (  inputN & (inputN-1) );
			count++;
		}
		System.out.println("Approach 3 (Brian and Kerningham) - Total number of set bits are: "+count);

		count=0;
		inputN =  copyInputN;
		int countOfBit256[] = new int[256];
		initilize(countOfBit256);
		
		count = countSetBit(inputN, countOfBit256);
		System.out.println("Approach 4 - Total number of set bits are: "+count);

		
		
	}

	private static int countSetBit(int inputN, int[] countOfBit256) {
		int count = countOfBit256[inputN & 0xff];
		
		inputN = inputN >> 8;
		count = count + countOfBit256[inputN & 0xff];
		
		inputN = inputN >> 8;
		count = count + countOfBit256[inputN & 0xff];
		
		inputN = inputN >> 8;
		count = count + countOfBit256[inputN & 0xff];
		
		return count;
	}

	private static int[] initilize(int[] countOfBit256) {
		countOfBit256[0] = 0;
		
		for(int i=1; i<256; i++) {
			
			countOfBit256[i] = (i &  1) + countOfBit256[i/2];
			
		}
		
		return countOfBit256;
	}

}
