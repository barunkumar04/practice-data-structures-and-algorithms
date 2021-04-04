package com.practice.maths;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {
		
		int n = 3125;
		
		System.out.println(trailingZeroinFactorial(n));

	}

	private static int trailingZeroinFactorial(int n) {
		
		int countOfTrailingZeros = 0;
		
		int pow = 1;
		int denominator = (int) (Math.pow(5, pow));
		while( n >= denominator) {
			countOfTrailingZeros += n/denominator;
			pow++;
			denominator = (int) (Math.pow(5, pow));
		}
		
		return countOfTrailingZeros;
	}

}
