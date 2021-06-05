package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
Problem Description

Diamond Miner is a game that is similar to Gold Miner, but there are n miners instead of 1 in this game.

The mining area can be described as a plane. The n miners can be regarded as n points on the y-axis. There are n diamond mines in the mining area. We can regard them as n points on the x-axis. For some reason, no miners or diamond mines can be at the origin (point (0,0)).

Every miner should mine exactly one diamond mine. Every miner has a hook, which can be used to mine a diamond mine.

If a miner at the point (a,b) uses his hook to mine a diamond mine at the point (c,d), he will spend √(a−c)2+(b−d)2 energy to mine it (the distance between these points). The miners can't move or help each other.
The object of this game is to minimize the sum of the energy that miners spend. Can you find this minimum?



Problem Constraints
1<=n<=1e5
-1e5<=x,y<=1e5


Input Format
First Argument denotes n which if no. miners and mines.
Second Argument contains array of integers of size 2n which denotes X-coordinate of points.
Third Argument contains array of integers of size 2n; which denotes Y-coordinated of points.
NOTE: Any point (x,y) to describe a miner's or a diamond mine's position. Either x=0, meaning there is a miner at the point (0,y), or y=0, meaning there is a diamond mine at the point (x,0). There can be multiple miners or diamond mines at the same point.
It is guaranteed that no point is at the origin. It is guaranteed that the number of points on the x-axis is equal to n and the number of points on the y-axis is equal to n.



Output Format
Return the the integer which is  minimal sum of energy that should be spent.
NOTE: if the minimal sum of energy is 3.54 then you have to return its integer part that is 3 only


Example Input
Input-1
A=2
B=[0,1,0,-2]
C=[1,0,-1,0]
Input-2

A=1
B=[0,1]
C=[1,0]


Example Output
Output-1
3
Output-2

1
 * 
 * @author Barun
 *
 */
public class DiamondMiner {

	public static void main(String[] args) {
		int A=18;
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-4, 10, -11, -4, -15, 16, 8, 13, 15, -13, 10, 12, -1, 11, -11, -14, 15, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 10, 15, 11, 13, 14, 14, 10, 15, 13, 15, 15, 12, 15, 14, 12, 15, 14));
		
		System.out.println(solve(A, B, C));
	}

	public static int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<Integer> shiftedMines = new ArrayList<Integer>();
        ArrayList<Integer> shiftedMiners = new ArrayList<Integer>();
        // tranposing -ve X-coordinate values to first quardrant. Also, exclusing zeros as one of the co-ordinate will be always zero
        for(int i=0; i<B.size(); i++){
            if(B.get(i) == 0)
                continue;
            if(B.get(i) < 0){
                shiftedMines.add(B.get(i) * -1);
            }else{
                shiftedMines.add(B.get(i));
            }
        }
        
        for(int i=0; i<C.size(); i++){
            if(C.get(i) == 0)
                continue;
            
            if(C.get(i) < 0){
                shiftedMiners.add(C.get(i) * -1);
            }else{
                shiftedMiners.add(C.get(i));
            }
        }
        
        Collections.sort(shiftedMines);
        Collections.sort(shiftedMiners);
        /*System.out.println(shiftedMines);
        System.out.println(shiftedMiners);*/
        
        double totalEffort = 0;
        //Calculating distance between two points
        for(int i=0; i<shiftedMines.size();i++){
            totalEffort += Math.sqrt((shiftedMines.get(i) * shiftedMines.get(i)) + (shiftedMiners.get(i) * shiftedMiners.get(i)));
        }
        return (int)totalEffort;
        
    }
}
