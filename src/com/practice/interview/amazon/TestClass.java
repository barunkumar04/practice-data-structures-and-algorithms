package com.practice.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		List<Integer> startIndices = new ArrayList<Integer>(Arrays.asList(1,1));

		List<Integer> endIndices = new ArrayList<Integer>(Arrays.asList(1,6));
		numberOfItems("*|*|*|", startIndices, endIndices); 

	}
public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        
        
        
        int startCompartmentIndex = 0;
        int endCompartMentIndex = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '|'){
                startCompartmentIndex = i;
                break;
            }
        }
        
        for(int i=s.length()-1; i>0; i--){
            if(s.charAt(i) == '|'){
                endCompartMentIndex = i;
                break;
            }
        }
        int[] prefixSum = new int[s.length()];
        int previousSum = 0;
        prefixSum[0] = 0;
        for(int i=startCompartmentIndex; i<endCompartMentIndex+1; i++){
            if(s.charAt(i) == '*'){
                previousSum = previousSum + 1;
            }else{
                previousSum = previousSum + 0;
            }
            prefixSum[i] = previousSum;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<endIndices.size(); i++){
            int endIndex = endIndices.get(i);
            result.add(prefixSum[endIndex-1]);
            
        }
        
        return result;
    }
}
