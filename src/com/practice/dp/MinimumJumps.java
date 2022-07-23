package com.practice.dp;

// Problem statement - https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1?page=1&difficulty[]=1&difficulty[]=2&company[]=Walmart&sortBy=submissions
public class MinimumJumps {
    private static int[] dpLookup;

    static int minJumps(int[] arr){

        if(arr[0] == 0)
            return -1;

        dpLookup = new int[arr.length];
        for(int i=0; i < dpLookup.length; i++){
            dpLookup[i] = -1;
        }
        int loc = 0;
        return findMinJumpRec(loc, arr);

    }

    private static int findMinJumpRec(int loc, int[] arr){

        // base case - array is blank or have only one elemnt or reached at end
        if(loc >= arr.length - 1)
            return 0;

        int jumps = Integer.MAX_VALUE - 10;

        if(dpLookup[loc] != -1)
            return dpLookup[loc];


        for(int step=1; step<=arr[loc]; step++){

            jumps = Math.min(jumps, findMinJumpRec(loc + step, arr)+1);
        }

        dpLookup[loc] = jumps;

        return jumps;
    }
}