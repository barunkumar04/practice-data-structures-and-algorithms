package com.practice.searching;

import java.util.ArrayList;
import java.util.Arrays;

/***
 *
 Problem Description
     Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
     For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
     NOTE: Users are expected to solve this in O(log(N)) time.

 Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 109

 Input Format
    The only argument given is the integer array A.

 Output Format
    Return the peak element.

 Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
    Input 2:
        A = [5, 17, 100, 11]

 Example Output
    Output 1:
        5
     Output 2:
        100

 Example Explanation
    Explanation 1:
        5 is the peak.
    Explanation 2:
        100 is the peak.

 ***/

public class FindPeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,7,5,4));
        int peak = findPeak(A, 0, A.size()-1);
        System.out.println(peak);
    }

    private static int findPeak(ArrayList<Integer> A, int start, int end){

        if(start > end){
            return -1;
        }

        //calculate pivot index
        int pivotIndex = start + (end - start) / 2;

        int prevElement = pivotIndex == 0? Integer.MIN_VALUE : A.get(pivotIndex-1); //Left buondary case
        int nextElement = pivotIndex == end? Integer.MIN_VALUE : A.get(pivotIndex+1); //Right buondary case

        if(A.get(pivotIndex) > prevElement && A.get(pivotIndex)  > nextElement){ // pivot indexed element is greated then its neighbours
            return A.get(pivotIndex) ;
        }

        // Move to ascending direction
        if(nextElement >= A.get(pivotIndex)){
            return findPeak(A, pivotIndex+1, end);
        }else{
            return findPeak(A, 0, pivotIndex-1);
        }

    }
}
