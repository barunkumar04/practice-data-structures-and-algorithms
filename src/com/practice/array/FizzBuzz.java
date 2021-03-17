package com.practice.array;

import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {
		 ArrayList<String> result = new ArrayList<String>();
	        int A = 15;
	        for(int i=1; i<=A; i++){
	            if(i%3 == 0){
	                result.add("Fizz");
	                continue;
	            } 
	            if(i%5 == 0){
	                result.add("Buzz");
	                continue;
	            }
	            result.add(String.valueOf(i));
	        }

	}

}
