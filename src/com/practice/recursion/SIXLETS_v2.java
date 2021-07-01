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

public class SIXLETS_v2 {

    private static int count=0;

    public static void main(String[] args) {
        int[] a = new int[]{1,2,8};
        int B = 2;
        System.out.println("Total # of sub-sequences having sum <= 1000 are: "+sixlets(a, 0, 0, B));
    }
    // Approach - Take current element or leave it.
    private static int sixlets(int a[], int i, int sum, int cnt) {
        if (sum > 1000)
            return 0;
        if (cnt == 0)
            return 1;
        if (i == a.length)
            return 0;
        // Take ith element or leave it.
        return sixlets(a, i + 1, sum, cnt) + sixlets(a, i + 1, sum + a[i], cnt - 1);
    }
}
