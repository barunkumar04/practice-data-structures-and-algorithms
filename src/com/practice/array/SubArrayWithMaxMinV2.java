package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithMaxMinV2 {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(377, 448, 173, 307, 108));

		int subarrayLength = findArrayLenghtContainingMaxMin(A);
		System.out.println(subarrayLength);
	}

	private static int findArrayLenghtContainingMaxMin(ArrayList<Integer> list) {

		int min_Index = -1, max_Index = -1;
		int min_ele = Integer.MAX_VALUE, max_ele = Integer.MIN_VALUE;

		int ans = Integer.MAX_VALUE;
		for (int x : list) {
			min_ele = Math.min(min_ele, x);
			max_ele = Math.max(max_ele, x);
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == min_ele)
				min_Index = Math.max(min_Index, i);
			if (list.get(i) == max_ele)
				max_Index = Math.max(max_Index, i);

			if (min_Index != -1 && max_Index != -1) {
				int len = Math.abs(max_Index - min_Index) + 1;
				ans = Math.min(ans, len);
			}

		}

		return ans;
	}

}
