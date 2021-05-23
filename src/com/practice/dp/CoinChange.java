package com.practice.dp;

/**
 * Problem statement - https://leetcode.com/problems/coin-change/
 * 
 * @author Barun
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		int[] coins = new int[] {2};
		int amount = 3;
		
		System.out.println(coinChange(coins, amount));

	}

	/**
	 * Observation 
	 * 	- To minimize # of coins, if possible pick larger denomination 
	 * 	- Assuming coins are given in sorted denomination
	 **/

	public static int coinChange(int[] coins, int amount) {

		// Base case
		if (amount == 0)
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int i = coins.length - 1; i >= 0; i--) {
			// Checking for max denomination which can be accommodated in balance amount
			if (amount >= coins[i]) {
				int coinCount = coinChange(coins, amount - coins[i]);
				if(coinCount != Integer.MAX_VALUE) {//Meaning this denomination doesn't fit 
					ans = Math.min(ans, coinCount+1);
				}
				
			}
		}

		return ans;
	}
}
