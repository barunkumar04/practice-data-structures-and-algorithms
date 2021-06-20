package com.practice.searching;

import java.util.ArrayList;

/**
 *
 *
 Problem Description
     Given a matrix of integers A of size N x M in which each row is sorted.
     Find and return the overall median of the matrix A.
     NOTE: No extra memory is allowed.
     NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

 Problem Constraints
    1 <= N, M <= 10^5
    1 <= N*M <= 10^6
    1 <= A[i] <= 10^9
    N*M is odd

 Input Format
    The first and only argument given is the integer matrix A.

 Output Format
    Return the overall median of the matrix A.

 Example Input
    Input 1:
        A = [   [1, 3, 5],
                [2, 6, 9],
                [3, 6, 9]   ]

     Input 2:
        A = [   [5, 17, 100]    ]

 Example Output
    Output 1:
        5
     Output 2:
        17

 Example Explanation
    Explanation 1:
        A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
         Median is 5. So, we return 5.
    Explanation 2:
        Median is 17.
 *
 */
public class MatrixMedian {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        int median = findMedian(A);
        System.out.println(median);
    }

    public static int findMedian(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        //Since row and cols are sorted find min and max to bound search space
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<rows; i++){
            if(A[i][0] < min)
                min = A[i][0];
            if(A[i][cols-1] > max)
                max = A[i][cols-1];
        }


        int start = min;
        int end = max;

        while(start != end){

            int mid = start + (end - start) / 2;

            int count = countOfNumLessThanMid(A, mid, rows, cols);
            if(count > (rows * cols)/2 ){ // valid search space is on left side
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    //To find how many elements in the matrix are less than or equal to mid
    private static int countOfNumLessThanMid(int[][] A, int mid, int rows, int cols){
        int count = 0;
        for(int i=0; i<rows; i++){
            int indexJustGreaterThanMid = binarySearch(A[i], mid, 0, cols-1);
            count = count + indexJustGreaterThanMid;
        }
        return count;
    }

    private static int binarySearch(int[] row, int x, int low, int high) {
        if(low > high)
            return low; // Since its zero-based index

        int pivot = low + (high - low) / 2;

        if(row[pivot] <= x){ // all number are less than X, hence search space is on right
            return binarySearch(row,x, pivot+1, high);
        }else{
            return binarySearch(row,x, 0, pivot-1);
        }

    }
}
