package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthSmallestInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inputArray1 = new ArrayList<Integer>(
				Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66,
						35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
		int result1 = kthSmallestIntegerInteger(inputArray1, 9);
		System.out.println(result1);

	}

	private static int kthSmallestIntegerInteger(ArrayList<Integer> array, int k) {
		Collections.sort(array);
		return array.get(k - 1);
	}
}
