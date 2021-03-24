package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrangeNumbers {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 0, 9, 3, 6, 8, 5, 4 ));
		arrange(numbers);
		System.out.println(numbers);

		numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 0, 9, 3, 6, 8, 5, 4 ));
		arrange1(numbers);
		System.out.println(numbers);

	}

	private static void arrange1(ArrayList<Integer> numbers) {
		int n = numbers.size();

		for (int i = 0; i < n; i++) {
			numbers.set(i, numbers.get(i) * n);
		}

		for (int i = 0; i < n; i++) {
			int paddedNum = numbers.get(numbers.get(i) / n) / n;
			numbers.set(i, numbers.get(i)+paddedNum);
		}

		for (int i = 0; i < n; i++) {
			int reducedNum = numbers.get(i) % n;
			numbers.set(i, reducedNum);
		}

	}

	/**
	 * 
	 * Input: 3, 2, 0, 1 Output: 1, 0, 3, 2 n = 4 here
	 * 
	 * Logic: for i=0 -> n A[i] = A[i] x n [ 12, 8, 0, 4 | padded with
	 * multiplication of n, this will have no effect as we can get same number by
	 * taking modulo. ]
	 * 
	 * for i=0 -> n A[i] = A[i] + A[ A[i] / n ] / n [ 13, 8, 3, 4 | Here, 13 has
	 * info about 3 (i.e. 13 / 4) as well 1 (13 % 4) ]
	 * 
	 * for i=0 -> n A[i] = A[i] % n [ 13, 8, 3, 4 | Here, 13 has info about 3 (i.e.
	 * 13 / 4) as well 1 (13 % 4) ]
	 * 
	 **/

	public static void arrange(ArrayList<Integer> numbers) {

		int n = numbers.size();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = numbers.get(i);
		}

		for (int i = 0; i < n; i++) {
			array[i] = array[i] * n;
		}

		for (int i = 0; i < n; i++) {
			array[i] = array[i] + array[array[i] / n] / n;
		}

		for (int i = 0; i < n; i++) {
			array[i] = array[i] % n;
		}
		numbers.clear();
		for (int i = 0; i < n; i++) {
			numbers.add(array[i]);
		}
	}
}
