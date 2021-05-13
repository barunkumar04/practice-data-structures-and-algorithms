package com.practice.dp;

/**

Problem 
	Our very own Suppandi has decided to start investing in the stock market. He has decided that to begin with he will buy shares of company X. The shares of company X have the following behavior.
	The price of the share remains the same throughout the day.
	At the end of the day the share price either reduces by 1$ or becomes double.
	Suppandi has decided that he will buy the share once the share price reaches m$/share. Can you help Suppandi calculate the minimum number of days after which he’ll be able to buy the shares of Company X, given the price of the share on Day 0 is n$/share.
Input Format
	The input consists of 2 lines each containing an integer. First line denotes n, the initial price of the stock and next line denotes m, the price at which Suppandi wants to buy the stock.
Constraints
	0<n,m<=10000
Output Format
	Print a single integer, the minimum number of days after which Suppandi will be able to buy shares of Company X.
Sample Input #1
	10
	1
Sample Output #1
	9

Sample Input #2
	3
	4
Sample Output #2
	2

 * 
 * 
 * @author Barun
 *
 */
public class WaitDaysToBuyStock {

	public static void main(String[] args) {
		int initialPrice = 7;
		int targetPrice = 11;
		
		int days = daysToWait(initialPrice, targetPrice);
		System.out.println(days);

	}

	private static int daysToWait(int currentPrice, int targetPrice) {
		
		//base check - if both prices are same, then we don't have wait
		if(currentPrice == targetPrice ) {
			return 0;
		}else if((currentPrice-1) == targetPrice ){
			return 1;
		}else if((currentPrice*2) == targetPrice ) {
			return 1;
		}
		
		/**
		 * 
		 * Now, there are 2 options
		 * 	a. consider a day when stock price will reduce by 1
		 *  b. consider a days when stock price will double 
		 * 
		 * Apply both operation on currentPrice and which so ever is closer to target price move towards that.
		 */
		
		int reducedPrice = currentPrice -1;
		int doubledPrice = currentPrice * 2;
		int reducePriceDays = Integer.MAX_VALUE;
		int doubledPriceDays = Integer.MAX_VALUE;
		
		if(Math.abs(targetPrice - reducedPrice) < Math.abs(targetPrice - doubledPrice)) {
			reducePriceDays = daysToWait(currentPrice-1, targetPrice) + 1;
		}else {
			doubledPriceDays = daysToWait(currentPrice*2, targetPrice) + 1;
		}
		
		return min(reducePriceDays, doubledPriceDays);
		
	}

	private static int min(int i, int j) {
		return i < j ? i : j;
	}

}
