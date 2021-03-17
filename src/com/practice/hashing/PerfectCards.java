package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PerfectCards {

	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(6,6))));

	}
	
	public static String solve(ArrayList<Integer> A) {
        if(A == null || A.size() < 2){
            return "LOSE";
        }
        Map<Integer, Integer> valueVsCount = new HashMap<>();
        
        for(Integer a : A) {
        	if(valueVsCount.keySet().contains(a)) {
        		valueVsCount.put(a, valueVsCount.get(a) + 1);
        	}else {
        		valueVsCount.put(a,1);
        	}
        }
        String result = "";
        if(valueVsCount.keySet().size() > 2 || valueVsCount.keySet().size() < 2) {
        	result =  "LOSE";
        }else if(valueVsCount.keySet().size() == 2){
        	int k = 1;
        	int picks = 0;
        	for(Map.Entry<Integer, Integer> entry : valueVsCount.entrySet()) {
        		picks = picks + entry.getValue() * k;
        		k = k * -1;
        	}
        	if(picks == 0) {
        		result =  "WIN";
        	}else {
        		result =  "LOSE";
        	}
        }
         return result;
        
		/*
		 * int tom_pick = A.get(0); int harry_pick = A.get(1); A.remove(new
		 * Integer(tom_pick)); A.remove(new Integer(harry_pick)); int tomPickCount = 1;
		 * int harryPickCount = 1; boolean tomTurn = true; for(int i = 0; i< A.size();
		 * i++){ if(tomTurn){ if(A.contains(new Integer(tom_pick))){ A.remove(new
		 * Integer(tom_pick)); tomPickCount++; tomTurn = false; } }else{
		 * if(A.contains(new Integer(harry_pick))){ A.remove(new Integer(harry_pick));
		 * harryPickCount++; tomTurn = true; } } } if(tomPickCount == harryPickCount &&
		 * A.size() == 0){ return "WIN"; }else{ return "LOSE"; }
		 */
    }
}
