package com.practice.dp;

/**
 * Problem statement - https://leetcode.com/problems/climbing-stairs/
 * 
 * @author Barun
 *
 */

public class ClimbingStairs {
	private static int[] memo = new int[100];

	public static void main(String[] args) {
		System.out.println(climbStairs(10));

	}

	private static int climbStairs(int n) {
		if (memo[n] != 0)
			return memo[n];
		// base case
		if (n == 1)
			return 1; // There is only one way to climb 1-stair
		if (n == 2)
			return 2; // There are 2 ways to climb 2 stairs. 0->1->2 or 0->2

		memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
		return memo[n];
	}
}
