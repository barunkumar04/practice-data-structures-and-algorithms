package com.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 Problem Description
    Given a array of integers A of size N and an integer B.
    Return number of non-empty subsequences of A of size B having sum <= 1000.

 Problem Constraints
    1 <= N <= 20
    1 <= A[i] <= 1000
    1 <= B <= N

 Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

 Output Format
    Return number of subsequences of A of size B having sum <= 1000.

 Example Input
    Input 1:
        A = [1, 2, 8]
        B = 2
    Input 2:
        A = [5, 17, 1000, 11]
        B = 4

 Example Output
    Output 1:
        3
    Output 2:
        0

 Example Explanation
    Explanation 1:
        {1, 2}, {1, 8}, {2, 8}
 Explanation 1:
        No valid subsequence
 *
 */

public class SIXLETS_v1 {

    private static int count=0;

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,8));
        int B = 2;
        int start = 0;
        int end = A.size();
        int sum = 0;
        findSixlets(A, B, start, end, sum);
        System.out.println("Total # of sub-sequences having sum <= 1000 are: "+count);
    }
    // Approach - Take current element or leave it.
    private static void findSixlets(ArrayList<Integer> A, int seqSize, int index, int end, int sum){
        // System.out.println(seqSize+"  "+sum +" " +index);
        //Base condition
        if(seqSize == 0 && sum <= 1000){
            count++;
            return;
        }
        if(seqSize == 0){
            return;
        }
        if(index >= end){
            return;
        }

        findSixlets(A, seqSize-1, index+1, end, sum + A.get(index));
        findSixlets(A, seqSize, index+1, end, sum);

    }
}
