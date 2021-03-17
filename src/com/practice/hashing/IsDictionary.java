package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IsDictionary {

	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<String>();
		A.add("hello");
		A.add("scaler");
		A.add("interviewbit");
		
		String B = "adhbcfegskjlponmirqtxwuvzy";
		Solution1 s = new Solution1();
		System.out.println(s.solve(A, B));

	}

}

class Solution1 {
    public int solve(ArrayList<String> A, String B) {
        // A = ["hello", "scaler", "interviewbit"]
        // B = "adhbcfegskjlponmirqtxwuvzy"
        
        Map<Character, Integer> alienCharPosition = new HashMap<>();
        
        for(int i = 0; i<B.length(); i++){
            alienCharPosition.put(B.charAt(i),i);
        }
        
        int previousStringHash = Integer.MIN_VALUE;
        for(int i=1;i<A.size();i++){
            String prevString = A.get(i-1);
            String currentString = A.get(i);
            
            if(!isGreater(currentString, prevString, alienCharPosition)){
                return 0;
            }
            
        }
        
        return 1;
    }
    
    public boolean isGreater(String currentString, String prevString,  Map<Character, Integer> alienCharPosition){
        
        for(int i=0 ; i<currentString.length(); i++){
            int currCharPosition = alienCharPosition.get(currentString.charAt(i));
            int prevCharPosition = -1;
            if(i < prevString.length() ){
                prevCharPosition = alienCharPosition.get(prevString.charAt(i));
            }
            
            if(currCharPosition < prevCharPosition){
                return false;
            }
        }
        
        return true;
    }
}