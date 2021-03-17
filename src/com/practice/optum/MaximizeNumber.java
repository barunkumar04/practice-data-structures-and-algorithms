package com.practice.optum;

public class MaximizeNumber {

	public static void main(String[] args) {
		System.out.println(solution(0));

	}
	
	 public static int solution(int N) {
	     if(N == 0) {
	    	 return 50;
	     }   
		 boolean isNegative = false;
	        if(N < 0){
	            isNegative = true;
	            N = -1 * N;
	        }

	        int tempN = N;
	        int[] digits = new int[10];
	        int i = 0;
	        while(tempN >0){
	            digits[i] = tempN % 10;
	            tempN = tempN / 10;
	            i++;
	        }
	        int multiplier = 10;
	        int resultNumber = 0;
	        boolean fiveInserted = false;
	        for(int j=i-1; j>=0; j-- ){
	            if(!isNegative){
	                if(digits[j] <= 5 && !fiveInserted){
	                    resultNumber = resultNumber * multiplier + 5;
	                    fiveInserted = true;
	                }
	                resultNumber = resultNumber * multiplier + digits[j];
	            }else{
	                if(digits[j] >= 5 && !fiveInserted){
	                    resultNumber = resultNumber * multiplier + 5;
	                    fiveInserted = true;
	                }
	                resultNumber = resultNumber * multiplier + digits[j];
	            }
	            
	        }
	        if(isNegative)
	            return -1 * resultNumber;
	        else
	            return resultNumber;        
	    }
}
