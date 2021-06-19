package com.practice.bitwise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Explanation: https://www.youtube.com/watch?v=Roz2OEKYlIE
 * [ASKED in GOOGLE]
 */
public class DifferentBitsSumPairwise_Optimized {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5));
        System.out.println(countBits(A));
    }

    public static int countBits(ArrayList<Integer> A) {
        long diffrentBitCount = 0;
        int mod = 1000000007;
        for (int i = 0; i < 32; i++) {
            long countOfOne = 0;
            long countOfZero = 0;
            for (int j = 0; j < A.size(); j++) {
                if (((A.get(j) >> i) & 1)  == 1) { // This is differ from what explained in video
                    countOfOne++;
                } else {
                    countOfZero++;
                }
            }
            diffrentBitCount += 2 * countOfOne * countOfZero;
            diffrentBitCount = diffrentBitCount % mod;
        }


        return (int) diffrentBitCount;

    }
}

// TC: O(N^2 * count of bits)
