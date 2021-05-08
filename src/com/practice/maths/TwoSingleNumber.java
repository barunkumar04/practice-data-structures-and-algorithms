package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoSingleNumber {

	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(3857, 21351, 23083, 3857, 19441, 2102, 15569, 11685, 2102, 21351, 161, 11685, 161, 6305, 6305, 19441, 15569, 8245 ))));

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		// Taking XOR, will result X^Y, X and Y are 2 non repeating elements
		int xor = calXOR(A);

		// finding first set bit from LSB side
		int i = 0;
		for (; i < 32; i++) {
			if (((xor >> i) & 1) == 1)
				break;
		}

		// ith element has set bit, meaning either X or Y has 1 and another has 0 on ith
		// bit.
		// Taking this in consideration, split the input array in to two, where
		// first ArrayList will have all elements having 1 at ith index
		// and second ArrayList will have all elements having 0 at ith index
		// Doing So, will place the X and Y in to two different array and since rest
		// numbers are in pairs, taking xor on these 2 arrays will result X and Y

		ArrayList<Integer> oneAtIindex = new ArrayList<Integer>();
		ArrayList<Integer> zeroAtIindex = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (Integer a : A) {
			if (((a >> i) & 1) == 1) {
				oneAtIindex.add(a);
			} else {
				zeroAtIindex.add(a);
			}
		}

		result.add(calXOR(oneAtIindex));
        result.add(calXOR(zeroAtIindex));
        

		Collections.sort(result);

		return result;

	}

	public static int calXOR(ArrayList<Integer> A) {
		int xor = 0;
		for (Integer a : A) {
			xor ^= a;
		}
		return xor;
	}
}
