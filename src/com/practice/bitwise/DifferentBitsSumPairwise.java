package com.practice.bitwise;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5));
        System.out.println(countBits(A));
    }

    /***
     *  Approach: Do XOR and get count of set bits
     *
     * */
    public static int countBits(ArrayList<Integer> A) {

        int differentBitCount = 0;

        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.size(); j++){
                if(i!=j){
                    differentBitCount +=  countSetBit(A.get(i)^A.get(j));
                }
            }
        }
        return differentBitCount;
    }

    /***
     * Logic - Iterate till max number bit count and number of 1's in xor result is count of different bit
     *
     * For example - Differnt bit in 5 and 3
     *  101
     *  011
     * ----
     *  110 (XOR)
     * ----
     *
     * Since 3 is of only 2 bits then we should check till 2 bits and total number of diffrent bits is 2.
     *
     * */
    private static int countSetBit(int xor){

        int count = 0;
        while(xor > 0){
            count = count + (xor & 1);
            xor = xor >> 1;
        }
        return count;
    }

}

// TC: O(N^2 * count of bits)
