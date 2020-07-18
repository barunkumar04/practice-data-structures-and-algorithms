package com.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = new int[]{10,5,20,7,20,15};

		//performing insertion sort
		
		for (int i=1; i< arr.length; i++) {
			
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > key) {
					arr[j+1] = arr[j];
					j--;
				
			}			
			arr[j+1] = key;
			
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println("After sort: "+ Arrays.toString(arr));
		
	}

}
