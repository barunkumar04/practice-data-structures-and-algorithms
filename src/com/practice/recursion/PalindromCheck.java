package com.practice.recursion;

public class PalindromCheck {

	public static void main(String[] args) {

		String inputString = "ABCCBA";
        int length = inputString.length();
        
        System.out.println(isPalindrom(inputString, 0, length-1));
    
	}
	
	 public static int isPalindrom(String A, int startIndex, int endIndex){
	        
	        // Base case
	        if(startIndex >= endIndex){
	            return 1;
	        }
	        
	        if(A.charAt(startIndex) != A.charAt(endIndex)){
	            return 0;
	        }
	        
	        //Recursive relation
	        return isPalindrom(A, startIndex + 1, endIndex - 1);
	        
	    } 
}
