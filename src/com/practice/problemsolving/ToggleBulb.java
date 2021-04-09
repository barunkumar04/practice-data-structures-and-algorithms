package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/*

Problem Description

	N light bulbs are connected by a wire.
	Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
	Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
	You can press the same switch multiple times.
	Note: 0 represents the bulb is off and 1 represents the bulb is on.

Problem Constraints
	1 <= N <= 5*105
	0 <= A[i] <= 1

Input Format
	The first and the only argument contains an integer array A, of size N.

Output Format
	Return an integer representing the minimum number of switches required.

Example Input
	Input 1:
 		A = [0, 1, 0, 1]
	Input 2:
 		A = [1, 1, 1, 1]

Example Output
	Output 1:
 		4
	Output 2:
 		0

Example Explanation
Explanation 1:
 press switch 0 : [1 0 1 0]
 press switch 1 : [1 1 0 1]
 press switch 2 : [1 1 1 0]
 press switch 3 : [1 1 1 1]
 
Explanation 2:

 There is no need to turn any switches as all the bulbs are already on.
 
 * 
 */

public class ToggleBulb {

	public static void main(String[] args) {
		int moves = toggleBulb(new ArrayList<Integer>(Arrays.asList(1,1,1,0,1,0,1,1,1,0,0)));
		System.out.println(moves);

	}
	
	public static int toggleBulb(ArrayList<Integer> A) {
		
		Boolean hasToggeled = false;
		int toggleCount = 0;
		for (int i=0; i <A.size(); i++) {
			if(A.get(i) == 1 && !hasToggeled) { // This is in correct state, no action required
				continue;
			}else if(A.get(i) == 0 && !hasToggeled) { // This bulb is off, need to toggle
				toggleCount ++;
				A.set(i, 1);
				hasToggeled = true;
			}else if(A.get(i) == 0 && hasToggeled) { // This is a toggled 0, i.e. its 1
				A.set(i, 1);
			}else if(A.get(i) == 1 && hasToggeled) { // This is a toggled 1, i.e. its 0, So this need to be toggled
				toggleCount ++;
				A.set(i, 1);
				hasToggeled = false;
			}
			
		}
		
		
		return toggleCount;
    }

}
