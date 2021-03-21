package com.practice.recursion;

public class NthFibNumber {
	
	public static int[] fib_result;
	public static void main(String[] args) {
		int n = 6;
		fib_result = new int[n+1];
		System.out.println(fib(n));
	}

	static int fib(int n) {
		if(fib_result[n] != 0) {
			return fib_result[n];
		}
		
		if (n <= 1)
			return n;
		int result =  fib(n - 1) + fib(n - 2);
		fib_result[n] = result;
		return result;
	}
}
