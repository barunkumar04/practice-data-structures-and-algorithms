package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SelectionSortStepIndices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inputArray1 = new ArrayList<Integer>(
				Arrays.asList(18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605, 3903, 154, 293, 12383, 17422, 18717, 19719, 19896, 5448, 21727, 14772, 11539, 1870, 19913, 25668, 26300, 17036, 9895, 28704, 23812, 31323, 30334, 17674, 4665, 15142, 7712, 28254, 6869, 25548, 27645, 32663, 32758, 20038, 12860, 8724, 9742, 27530, 779, 12317, 3036));
		System.out.println(inputArray1.size());
		ArrayList<Integer> result1 = pivotIndices(inputArray1);
		System.out.println(result1);

	}

	 public static ArrayList<Integer> pivotIndices(ArrayList<Integer> A) {
	        
	        ArrayList<Integer> minIndices = new ArrayList<Integer>();
	        for(int i=0; i<A.size(); i++){
	            int min = A.get(i);
	            int min_index = i;
	            for(int j=i+1; j<A.size(); j++){
	                if(A.get(j) < min){
	                    min = A.get(j);
	                    min_index = j;
	                }
	            }
	            Collections.swap(A, i, min_index);
	            minIndices.add(min_index);
	        }
	        return minIndices;
	    }
	    
}
