package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
Problem Description

	We have a wooden plank of the length A units. Some covid viruses are walking on the plank, each covid virus moves with speed 1 unit per second. Some of the covid viruses move to the left, the other move to the right.
	When two covid viruses moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions doesn't take any additional time.
	When an covid virus reaches one end of the plank at a time t, it falls out of the plank imediately.
	Given an integer A and two integer arrays B signifying left going covid viruses and C signifying right going covid viruses, the positions of the covid viruses moving to the left and the right. Return the moment when the last covid virus(s) fall out of the plank.


Problem Constraints
	1 <= A <= 10^4
	0 <= B.length <= A + 1
	0 <= B[i] <= A
	0 <= C.length <= A + 1
	0 <= C[i] <= A
	1 <= B.length + C.length <= A + 1
	All values of left and right are unique, and each value can appear only in one of the two arrays.

Input Format
	First argument contains integer A.
	Second argument contains B denoting covid viruses moving left.
	Third argument contains C denoting covid viruses moving right.

Output Format
	Return a single integer.

Example Input
	Input 1:
		n = 4
		left = [4,3]
		right = [0,1]

	Input 2:
		n = 9
		left = [5]
		right = [4]

Example Output
	Output 1:
		4
	Output 2:
		5

Example Explanation
	Explanation 1:
		In the image above:
			-The covid virus at index 0 is named A and going to the right.
			-The covid virus at index 1 is named B and going to the right.
			-The covid virus at index 3 is named C and going to the left.
			-The covid virus at index 4 is named D and going to the left.
			Note that the last moment when an covid virus was on the plank is t = 4 second, after that it falls imediately out of the plank. (i.e. We can say that at t = 4.0000000001, there is no covid viruses on the plank).
	Explaination 2
		At t = 1 second, both covid viruses will be at the same intial position but with different direction.
 * 
 * 
 * @author Barun
 *
 */
public class WhenWillCovidDie {

	public static void main(String[] args) {
		int A = 4;
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4,3));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(0,1));
		
		System.out.println(solve(A, B, C));

	}
	
	public static int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
       
		/**
         * 
         * A - plank size
         * B - Right to left going covid viruses
         * C - Left to right going covid virus
         * 
         * */
         
         //Finding max time taken by right to left going covid viruses
         int rightToLeftMaxTime = Integer.MIN_VALUE;
         for(Integer i : B){
             int timeTakeToFallICovidVirus = i; // i, Because these viruses need to reach start of plank that is 0.
             if(timeTakeToFallICovidVirus> rightToLeftMaxTime)
                rightToLeftMaxTime = timeTakeToFallICovidVirus;
         }
         
         //Finding max time taken by left to right going covid viruses
         int leftToRightMaxTime = Integer.MIN_VALUE;
         for(Integer i : C){
             int timeTakeToFallICovidVirus = A - i; // A-i, Because these viruses need to reach end of plank that is A.
             if(timeTakeToFallICovidVirus > leftToRightMaxTime)
                leftToRightMaxTime = timeTakeToFallICovidVirus;
         }
         
         return rightToLeftMaxTime > leftToRightMaxTime ? rightToLeftMaxTime : leftToRightMaxTime;
        
    }
}
