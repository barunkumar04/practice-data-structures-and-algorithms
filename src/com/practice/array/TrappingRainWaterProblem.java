package com.practice.array;

public class TrappingRainWaterProblem {

	public static void main(String[] args) {
		
		/**
		 * Input: {3,0,1,2,5}
		 * Output: 6
		 * 
		 */
		
		int arr[] = {3,0,1,2,5};
		
		/**
		 * Time complexity = Theeta(n2)
		 */
		int result = solution1_naive_method(arr);
		System.out.println("Max water can be stored is: "+ result);
		
		
		/**
		 * Time complexity = Theeta(n)
		 */
		result = solution1_optimized_method(arr);
		System.out.println("Max water can be stored is: "+ result);
	}

	private static int solution1_optimized_method(int[] arr) {
		int leftMaxArray[] = new int[arr.length];
		int rightMaxArray[] = new int[arr.length];
		
		leftMaxArray[0] = arr[0];
		for (int i = 1;  i<arr.length -1; i++) {
			if(arr[i] > leftMaxArray[i-1])
				leftMaxArray[i] =  arr[i];
		}
		
		rightMaxArray[arr.length -1 ] = arr[arr.length -1];
		for (int i = (arr.length-2);  i>=0 ; i--) {
			if(arr[i] > rightMaxArray[i-1])
				rightMaxArray[i] =  arr[i];
		}
		
		
		
		return 0;
	}

	private static int solution1_naive_method(int[] arr) {
		int result = 0 ;
		
		for(int i = 1 ; i< (arr.length-1); i++ ) {
			
			int leftMaxBar = arr[i];
			for(int j = 0; j<i; j++) {
				if(arr[j] > leftMaxBar) {
					leftMaxBar = arr[j];
				} 
			}		
			int rightMaxBar = arr[i];
			for(int j = i+1; j< arr.length ;j++) {
				if(arr[j] > rightMaxBar) {
					rightMaxBar = arr[j];
				}
			}
			
			int min_lMax_rMax = leftMaxBar < rightMaxBar ? leftMaxBar : rightMaxBar;
			result = result + (min_lMax_rMax - arr[i]);
		}
		
		return result;
	}

}
