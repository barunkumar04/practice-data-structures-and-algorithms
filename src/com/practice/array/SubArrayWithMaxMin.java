package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithMaxMin {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(377, 448, 173, 307, 108));

		int subarrayLength = findArrayLenghtContainingMaxMin(A);
		System.out.println(subarrayLength);
	}

	private static int findArrayLenghtContainingMaxMin(ArrayList<Integer> list) {

		int subArrayLength = 0;
		if (list.size() == 0) {
			subArrayLength = 0;
		} else if (list.size() == 1) {
			subArrayLength = 1;
		} else if (list.size() == 2) {
			subArrayLength = 2;
		} else {
			int minElement = list.get(0);
			int maxElement = list.get(0);
			
			int minIndex = 0;
			int maxIndex = 0;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) <= minElement) {
					minElement = list.get(i);
					minIndex = i;

				}

				if (list.get(i) >= maxElement) {
					maxElement = list.get(i);
					maxIndex = i;
				}

			}
			int minDiff = Integer.MAX_VALUE;
			
			for (int i = 0; i < list.size(); i++) {
				
				if(list.get(i) == minElement) {
					minIndex = i;
					if(Math.abs(minIndex - maxIndex) < minDiff) {
						minDiff = Math.abs(minIndex - maxIndex) ;
						subArrayLength = minDiff+1;
					}
				}else if(list.get(i) == maxElement) {
					maxIndex = i;
					if(Math.abs(minIndex - maxIndex) < minDiff) {
						minDiff = Math.abs(minIndex - maxIndex) ;
						subArrayLength = minDiff+1;
					}
				}
				
				
			}
			
			
			
			System.out.println();
		}
		return subArrayLength;

	}

}
