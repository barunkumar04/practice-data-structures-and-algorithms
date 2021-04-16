package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
Sub-matrix Sum Queries
	Problem Description

	Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.
	Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

	Rows are numbered from top to bottom and columns are numbered from left to right.
	Sum may be large so return the answer mod 109 + 7.

Problem Constraints
	1 <= N, M <= 1000
	-100000 <= A[i] <= 100000
	1 <= Q <= 100000
	1 <= B[i] <= D[i] <= N
	1 <= C[i] <= E[i] <= M

Input Format
	The first argument given is the integer matrix A.
	The second argument given is the integer array B.
	The third argument given is the integer array C.
	The fourth argument given is the integer array D.
	The fifth argument given is the integer array E.
	(B[i], C[i]) represents the top left corner of the i'th query.
	(D[i], E[i]) represents the bottom right corner of the i'th query.

Output Format
	Return an integer array containing the submatrix sum for each query.

Example Input
Input 1:

 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:

 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output
Output 1:

 [12, 28]
Output 2:

 [22, 19]


Example Explanation
Explanation 1:

 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
Explanation 2:

 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.

 * 
 * @author Barun
 *
 */

public class SubMatrixSumQueries_2DPrefixSum {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));		
		A.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
		A.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));
		
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(2,3));
		ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2,3));
		
		System.out.println(solve(A, B, C, D, E));

	}
	
	public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int rows = A.size();
        int columns = A.get(0).size();
        long[][] prefixSumArray = new long[rows][columns];
        
        preparePrefixSumMatrix(A, prefixSumArray, rows, columns);
        
        int queryCount = C.size();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<queryCount; i++){
            int topLeft_i = B.get(i)-1;
            int topLeft_j = C.get(i)-1;
            
            int bottomRight_i = D.get(i)-1;
            int bottomRight_j = E.get(i)-1;
            
            long wholeSubMatrixSum  = prefixSumArray[bottomRight_i][bottomRight_j];
            long aboveCut = (topLeft_i-1) < 0 ? 0 : prefixSumArray[topLeft_i-1][bottomRight_j];
            long leftCut = (topLeft_j -1) < 0 ? 0 : prefixSumArray[bottomRight_i][topLeft_j -1];
            long upperCornerCut = 0;
            
            if((topLeft_i - 1 ) >= 0 && (topLeft_j - 1 ) >= 0){
                upperCornerCut = prefixSumArray[topLeft_i-1][topLeft_j-1];
            }
            
            long sumMattrix = wholeSubMatrixSum - aboveCut - leftCut + upperCornerCut;
            
            //Why this? - Because value can be negative as well and we need to return value 
            // mod 1000000007, meaning between 0 to 1000000007. 
            // Hence adding mod value to bring it to posive zone. 
            // Refer Wheel math.
            while (sumMattrix < 0){
                sumMattrix +=  1000000007;
            }
            result.add((int)(sumMattrix % 1000000007));
        }
       
        return result;
            
        
    }
    
     public static void preparePrefixSumMatrix(ArrayList<ArrayList<Integer>> A, long[][] prefixSumArray, int rows, int columns){
          //Preparing prefix sum array
        
        // Taking row sum
        for(int i=0; i<rows; i++){
            ArrayList<Integer> row = A.get(i);
            long previous = row.get(0);
            prefixSumArray[i][0] = previous;
            for(int j=1;j<columns; j++){
                prefixSumArray[i][j] = previous + row.get(j);
                previous = previous + row.get(j);
            }
        }
        
        // Taking column sum
        for(int i=0; i<columns; i++){
            long previous = prefixSumArray[0][i];
            for(int j=1;j<rows; j++){
                prefixSumArray[j][i] = previous + prefixSumArray[j][i];
                previous = prefixSumArray[j][i];
            }
        }
     }
}
