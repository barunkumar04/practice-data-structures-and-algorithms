package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
Problem Description
	Given an integer array A of size N.
	Find the minimum number of elements that need to be removed such that the GCD of the resulting array becomes 1.

If not possible then return -1.

Problem Constraints
	1 <= N <= 100000
	1 <= A[i] <= 1e9

	Input Format
	Input contains a single integer array A

Output Format
	Return an integer

Example Input
	Input 1:
		A = [7, 2, 5]
Example Output
	Output 1:
 		0

Example Explanation
	Explanation 1:
		GCD of the array A is 1.
 		so, the number of elements to be removed is 0.
 * 
 * @author Barun
 *
 */

public class GCD1 {

	public static void main(String[] args) {
		System.out.println(checkGCD1(new ArrayList<Integer>(Arrays.asList(7, 2, 5))));

	}
	/**
     * If any of the element in array is a prime number, GCD ould be 1
     * 
     * */
    public static int checkGCD1(ArrayList<Integer> A) {
        int count = -1;
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for(Integer num : A){
        	
            // If a minimum number is non-prime, should be excluded
            if(isPrime(num)){
               count = 0;
            break;
            }
        }
        
        return count;
    }
    
    public static boolean isPrime(int num){
        if(num ==1){
            return true;
        }
        for(int i=2; i<= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
