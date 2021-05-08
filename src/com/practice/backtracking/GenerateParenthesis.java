package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		System.out.println(AllParenthesis(3));
		

	}
	
	public static List<String> AllParenthesis(int n) 
    {
        List<String> result  = new ArrayList<>();
	    allParenthesis("", n, n, result);
        return result;
    }
    
    private static void allParenthesis(String str,  int open, int close, List<String> result){
    	//safety check
    	if(close < open )
    		return;
    
        //base case - count of open and close has reached to completion
    	if( open == 0 && close == 0){
    		result.add(str);
            return;
        }
    	
    	//Following are 2 possibilities
    	String x = str+"(";
    	String y = str+")";
    	
        if(open>0)
            allParenthesis(x,  open-1, close, result);
        if(close>open)
            allParenthesis(y,  open, close-1, result);
    }
}
