package com.practice.array;

public class SpecialSubSequence {

	public static void main(String[] args) {
		String inputStr = "ABCGAG";
		String subSequence = "AG";
		int count = findSubSequence(inputStr);
		System.out.println(count);

	}
	
	/**
	 * Logic
	 * 	1. Maintain count of 'A'
	 *  2. On each occurrence of 'G', increment count.
	 * 
	 * @param A
	 * @return
	 */
	
	public static int findSubSequence(String A) {

		int countOfA = 0;
		int subSequenceCount = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'A') {
				countOfA += 1;
			}
			if (A.charAt(i) == 'G') {
				subSequenceCount = subSequenceCount + countOfA;
			}
		}

		return (int) (subSequenceCount % (Math.pow(10, 9) + 7));
	}
}
