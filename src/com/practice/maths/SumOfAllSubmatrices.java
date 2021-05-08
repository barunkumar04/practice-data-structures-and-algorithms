package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Problem Description Given a 2D Matrix A of dimensions N*N, we need to return
 * sum of all possible submatrices.
 * 
 * Problem Constraints 1 <= N <=30 0 <= A[i][j] <= 10
 * 
 * Input Format Single argument representing a 2-D array A of size N x N.
 * 
 * Output Format Return an integer denoting the sum of all possible submatrices
 * in the given matrix.
 * 
 * Example Input A = [ [1, 1] [1, 1] ]
 * 
 * Example Output 16
 * 
 * 
 * Example Explanation Number of submatrices with 1 elements = 4, so sum of all
 * such submatrices = 4 * 1 = 4 Number of submatrices with 2 elements = 4, so
 * sum of all such submatrices = 4 * 2 = 8 Number of submatrices with 3 elements
 * = 0 Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
 * Total Sum = 4+8+4 = 16
 * 
 * @author Barun
 *
 */

public class SumOfAllSubmatrices {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1, 2));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(3, 4));

		A.add(row1);
		A.add(row2);

		System.out.println(solve(A));

	}

	public static int solve(ArrayList<ArrayList<Integer>> A) {

		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> row = A.get(i);
			for (int j = 0; j < row.size(); j++) {
				int subMatCount = subMatrixCount(i + 1, j + 1, row.size());
				sum = sum + (row.get(j) * subMatCount);
			}

		}

		return sum;
	}

	private static int subMatrixCount(int i, int j, int n) {
		return i * (n - i + 1) * j * (n - j + 1);
	}

}
