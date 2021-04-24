package com.practice.interview.google;

/**
 * 
 * Problem statement
	https://docs.google.com/document/d/1Zh_AXcTICquTwmn1-mtM0eaeEMnyooqDfK50GTfDem8/edit?usp=sharing 
 * @author Barun
 *
 * @author Barun
 *
 */

public class TrappingRainWaterProblem {

	public static void main(String[] args) {

		/**
		 * Input: {3,0,1,2,5} Output: 6
		 * 
		 */

		int arr[] = { 1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2 };

		/**
		 * Time complexity = Theeta(n2)
		 */
		int result = solution1_naive_method(arr);
		System.out.println("Max water can be stored is: " + result);

		/**
		 * Time complexity = Theeta(n)
		 */
		result = measureWaterVolume(arr);
		System.out.println("Max water can be stored is: " + result);
	}

	private static int measureWaterVolume(int[] islandHeight) {
		int n = islandHeight.length;
		// Calculate left max array
		int[] leftMaxHights = new int[n];
		leftMaxHights[0] = islandHeight[0];

		for (int i = 1; i < n; i++) {
			leftMaxHights[i] = max(islandHeight[i], leftMaxHights[i - 1]);
		}

		// Calculate right max array
		int[] rightMaxHights = new int[n];
		rightMaxHights[n - 1] = islandHeight[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			rightMaxHights[i] = max(islandHeight[i], rightMaxHights[i + 1]);
		}

		// water accumulated by ith island would be:
		// min(leftMaxHights[i], rightMaxHights[i]) - islandHeight[i]

		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum = sum + min(leftMaxHights[i], rightMaxHights[i]) - islandHeight[i];
		}

		return sum;

	}

	private static int max(int val1, int val2) {
		return val1 > val2 ? val1 : val2;
	}

	private static int min(int val1, int val2) {
		return val1 < val2 ? val1 : val2;
	}

	private static int solution1_naive_method(int[] arr) {
		int result = 0;

		for (int i = 1; i < (arr.length - 1); i++) {

			int leftMaxBar = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] > leftMaxBar) {
					leftMaxBar = arr[j];
				}
			}
			int rightMaxBar = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > rightMaxBar) {
					rightMaxBar = arr[j];
				}
			}

			int min_lMax_rMax = leftMaxBar < rightMaxBar ? leftMaxBar : rightMaxBar;
			result = result + (min_lMax_rMax - arr[i]);
		}

		return result;
	}

}
