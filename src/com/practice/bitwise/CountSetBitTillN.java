package com.practice.bitwise;

public class CountSetBitTillN {

	public static void main(String[] args) {
		int n = 10;
		
		int result  = usingArrayAndOddAndEven(n);
		System.out.println(result);
		
		result  = usingBitPattern(n);
		System.out.println(result);

	}
	
	/**
	 * Algorithm:
	 * 1. Calculate on LSBs and post calculation right shift by 1 till number is > 0
	 * 2. In every iteration increase gruop formation as 2, 4, 8 ..and so on. And count set bits as below
	 * 		a. From the LSB side, Every 2 (i.e. groupDivisor) consecutive pairs of set bits contains one 0 and one 1.
			b. From the LSB side, Every 4 (i.e. groupDivisor) consecutive pairs of set bits contains two 0 and two 1.
			c. From the LSB side, Every 8 (i.e. groupDivisor) consecutive pairs of set bits contains four 0 and four 1.
		3. Count set bit of residual numbers as all number from 0 to n, may not be in perfect groups/
			a. Iterate from start of residual number to N
			b. Right shift based on group formation (1, 2, 3..etc)
			c. Check for LSB and count.
	 * 
	 * @param A
	 * @return
	 */
	private static int usingBitPattern(int A) {
		
		int countInGroup = 2;
		long countOfBit = 0;
		int pow = 0;
		int tempN = A;
		int previousNumber = 0;
		while(tempN > 0) {
			/**
			 * From the LSB side, Every 2 (i.e. groupDivisor) consecutive pairs of set bits contains one 0 and one 1.
			 * From the LSB side, Every 4 (i.e. groupDivisor) consecutive pairs of set bits contains two 0 and two 1.
			 * From the LSB side, Every 8 (i.e. groupDivisor) consecutive pairs of set bits contains four 0 and four 1.
			 */
			int groups = A/countInGroup;
			countOfBit = (long) (countOfBit + (groups * Math.pow(2, pow)));
			
			/**
			 * bit count for remaining number. Checking LSB
			 * 
			 * Decimal Value (n)                                  11                                                           12
			 * Binary Value (n)                                00001011                                                     00001100
			 * Binary of 1 (1)                                 00000001                                                     00000001
			 * Bitwise AND (n & 1)                             00000001                                                     00000000
			 */
			int i = groups * countInGroup;
			
			if(i == 0) { // i..e there is no prefect group formed
				i = previousNumber;
			}
			previousNumber = groups * countInGroup;
			for(; i<=A; i++ ) {
				countOfBit = countOfBit + ( ((i>>pow) & 1) == 0 ? 0 : 1 );
			}
			countInGroup = countInGroup * 2;
			pow = pow + 1;
			tempN = tempN>>1;
			
			
		}
		
		return (int) (countOfBit % 1000000007);
	}

	private static int usingArrayAndOddAndEven(int A) {
		int[] bitCountArray = new int[A+1];
		bitCountArray[0] = 0;
		bitCountArray[1] = 1;
		int sum=1;
		for(int i=2; i<=A; i++) {
			int half = i/2;
			
			if(i%2 == 0) {
				bitCountArray[i] = bitCountArray[half];
			}else {
				bitCountArray[i] = bitCountArray[half] + 1;
			}
			sum+=bitCountArray[i];
		}
		
		return sum;
	}

}
