package com.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 Problem Description
    Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.

 Problem Constraints
     1 <= |A| <= 100000
     1 <= A[i] <= 10^9
    1 <= B <= 10^9

 Input Format
     The first argument given is the integer array A.
     The second argument given is integer B.

 Output Format
    Return the maximum value of K (sub array length).

 Example Input
    Input 1:
     A = [1, 2, 3, 4, 5]
     B = 10
    Input 2:
     A = [5, 17, 100, 11]
     B = 130

 Example Output
    Output 1:
    2
    Output 2:
    3

 Example Explanation
    Explanation 1:
        Constraints are satisfied for maximal value of 2.
    Explanation 2:
        Constraints are satisfied for maximal value of 3.
 *
 *
 */

public class SpecialInteger {
    private static int result  = -1;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 2, 24, 38, 25, 35, 33, 43, 12, 49, 35, 45, 47, 5, 33 ));
        int B = 249;

        System.out.println(solve(A, B));
    }

    /**
     * Approach
     *  - Binary search on answer space i.e. all possible sub-array sizes.
     *  - In binary search, for a given mid/pivot check if  mid/pivot sized sub-array sum is less than given B. Use sliding window approach
     *      - If yes, binary search right answer space.
     *      - if no, binary search in left answer space.
     *
     * @param A
     * @param B
     * @return
     */
    public static int solve(ArrayList<Integer> A, int B) {
        //Collections.sort(A);
        int maxPossibleSubarry = A.size();

        binarySearch(A, B, 0, maxPossibleSubarry);
        return result;
    }

    private static void binarySearch(ArrayList<Integer> A, int B,  int startSize, int endSize){
        if(startSize > endSize)
            return;

        int candidateSubArraySize = startSize + (endSize - startSize) / 2;

        boolean isValidSize = checkSubArraySum(A, B, candidateSubArraySize );

        if(isValidSize){
            result = candidateSubArraySize;
            binarySearch(A, B, candidateSubArraySize+1, endSize);
        }else{
            binarySearch(A, B, startSize, candidateSubArraySize-1);
        }

    }

    private static boolean checkSubArraySum(ArrayList<Integer> A, int B,  int candidateSubArraySize){

        long windowSum = 0;
        for(int i=0; i<candidateSubArraySize; i++){
            windowSum += A.get(i);
        }

        if(windowSum > B) return false;

        int previousIndex = 0;
        for(int i=candidateSubArraySize; i< A.size(); i++){
            windowSum = windowSum - A.get(previousIndex) + A.get(i);
            if(windowSum > B) return false;
            previousIndex = previousIndex + 1;
        }
        return true;
    }
}
