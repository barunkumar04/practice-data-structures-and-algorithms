package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class RowWithMaxOnes {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A =  new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 1));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 1));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 1));
		ArrayList<Integer> row4 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 1));
		ArrayList<Integer> row5 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 1));
		
		A.add(row1);
		A.add(row2);
		A.add(row3);
		A.add(row4);
		A.add(row5);
		
		
	}
	
	public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rowWithMaxCount = 0;
        int countOfOne;
        int maxCount=0;
        int i=0;
        for(; i <A.size(); i++){
            countOfOne = 0;
            for(Integer j : A.get(i)){
                if(j==1){
                    countOfOne++;
                }                
            }
            if(countOfOne > maxCount){
                maxCount = countOfOne;
                rowWithMaxCount = i;
            }
        }
        
        return rowWithMaxCount;
    }
}
