package com.practice.string;

import java.util.Stack;

public class ReverseWordsInString {

	// input - This is for brush-up
	// output - brush-up for is This
	public static void main(String[] args) {
		
		String input = "This is for brush-up";
		
		String result = solution1(input);
		System.out.println(result);
		
		result = solution2(input);
		System.out.println(result);
	}

	/**
	 *  This takes O(1) auxiliary space
	 *  
	 *  solution approach - reverse the words then reverse the whole string.
	 *  eg: 
	 *  	input:  abc def 
	 *  	step 1: cba fed
	 *  	step 2: def abc
	 */
	private static String solution2(String input) {
		
		StringBuilder sbInput = new StringBuilder(input);
		
		int beginIndex = 0;
		for(int i = 0; i< sbInput.length(); i++) {
			
			if(input.charAt(i) == ' ') {
				reverseString(sbInput, beginIndex, i-1);
				beginIndex = i+1;
			}
		}
		//reversing last word
		reverseString(sbInput, beginIndex, sbInput.length() -1 );
		
		//reversing whole string
		reverseString(sbInput, 0, input.length()-1);
		return sbInput.toString();
		
	}

	private static void reverseString(StringBuilder input, int beginIndex, int endIndex) {
		
		
		while (beginIndex < endIndex ) {
			char temp = input.charAt(beginIndex);
			input.setCharAt(beginIndex, input.charAt(endIndex));
			input.setCharAt(endIndex, temp);
			
			beginIndex ++;
			endIndex --;
		} 
		
	}

	/**
	 *  This takes O(n) auxiliary space
	 *  
	 *  solution approach - use stack 
	 *  
	 */
	private static String solution1(String input) {
		String[] splitsOnSpace = input.split(" ");
		Stack<String> words = new Stack<String>();
		for (String word : splitsOnSpace) {
			words.push(word);
		}
		
		String output = "";
		while(!words.isEmpty()) {
			output = output+words.pop()+" ";
		}
		
		return output.trim();
	}

}
