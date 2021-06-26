package com.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialInteger {
    private static int result  = -1;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 2, 24, 38, 25, 35, 33, 43, 12, 49, 35, 45, 47, 5, 33 ));
        int B = 249;

        System.out.println(solve(A, B));
    }

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
