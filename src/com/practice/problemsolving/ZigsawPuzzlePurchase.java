package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Jigsaw puzzle
You need to buy N jigsaw puzzles from available M puzzles. Each puzzle contains a distinct number of pieces. 
Choose N puzzles such that, if A is the largest puzzle  and B is the smallest puzzle then A - B should be minimized.
*/
public class ZigsawPuzzlePurchase {

	public static void main(String[] args) {
		ArrayList<Integer> availableZigsawPuzzleSizes = new ArrayList<Integer>(Arrays.asList(8952, 1727, 3560, 3087,
				9652, 1063, 1269, 556, 810, 3404, 4904, 240, 1739, 2136, 7832, 9453, 810, 9730, 7829, 8085, 9007, 9406,
				204, 3438, 8899, 5622, 2270, 2131, 7442, 3903, 3837, 2745, 1981));
		int countToBuy = 31;

		System.out.println(solve(availableZigsawPuzzleSizes, countToBuy));

	}

	public static int solve(ArrayList<Integer> A, int B) {

		Collections.sort(A);
		int minDiff = Integer.MAX_VALUE;
		for (int i = B; i <= A.size(); i++) {
			int minSizePuzzle = A.get(i - B);
			int maxSizePuzzle = A.get(i - 1);
			int diff = maxSizePuzzle - minSizePuzzle;
			if (diff < minDiff) {
				minDiff = diff;
			}
		}

		return minDiff;
	}
}
