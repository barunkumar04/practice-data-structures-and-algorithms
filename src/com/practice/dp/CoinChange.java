package com.practice.dp;

import java.util.Arrays;

/**
 * Problem statement - https://leetcode.com/problems/coin-change/
 * 
 * Approach:
 * 	- Sort the array in ascending order and process from last index (i.e. max denomination coin) so that # of coin can be minimized.
 *  - Iterate coins
 *  	- Recursive call to get minimum coin for same index as well as nor next index
 *  		- if denomination is less than or equal to balance amount then we will reflect on coin count
 * @author Barun
 *
 */
public class CoinChange {
	
	private static int memo[] = new int[12];
	public static void main(String[] args) {
		int[] coins = new int[] {186,419,83,408};
		int amount = 6249;

		System.out.println(coinChange(coins, amount));

	}

	public static int coinChange(int[] coins, int amount) {
		int totalSum = 0;
		int coinCount = 0;
		Arrays.sort(coins);
		int result = Integer.MAX_VALUE;
		for (int i = coins.length-1; i >= 0; i--) {
			result = Math.min(result, minCoinCount(coins, i, coinCount, totalSum, amount));
		}

		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int minCoinCount(int[] coins, int index, int coinCount, int totalSum, int amount) {
		if (totalSum == amount) {
			return coinCount;
		}
		if (index < 0) {
			return Integer.MAX_VALUE;
		}

		int diff = amount - totalSum;
		int result1 = Integer.MAX_VALUE;
		int result2 = Integer.MAX_VALUE;
		if (diff >= coins[index]) {
			totalSum = totalSum + coins[index];
			coinCount = coinCount + 1;
			result1 =  minCoinCount(coins, index, coinCount, totalSum, amount);
		} 
		result2 = minCoinCount(coins, index - 1, coinCount, totalSum, amount);
		return Math.min(result1, result2);
		
	}
}
