package com.practice.array;

public class MaximizeProfitStockBuySell {

	public static void main(String[] args) {
		// int arr[] = {1,5,3,8,12}; //13
		// int arr[] = {30,20,10}; //0
		int arr[] = {10,20,30}; //0
		
		int profit = 0;
		int lastBuyRate = arr[0];
		for(int i=1;i<arr.length; i++) {
			
			if(arr[i] > lastBuyRate) {
				profit = profit + (arr[i] - lastBuyRate);
				
			}
			lastBuyRate = arr[i];
			
		}
		
		System.out.println("Total profit: "+profit);

	}

}
/**
 * Time complexity - O(n)
 * Space complexity - Theeta(1)
 * 
 */
