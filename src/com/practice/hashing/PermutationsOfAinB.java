package com.practice.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationsOfAinB {

	public static void main(String[] args) {

		String A ="abc";
		String B = "abcbacabc";
		int count = countPermutations(A, B);
		System.out.println(count);
    

	}

	private static int countPermutations(String A, String B) {
		int lengthofA =  A.length();
		int lengthofB =  B.length();
		
		if( (lengthofA > lengthofB) ) {
			return 0;
		}
		
		Map<Character, Integer> charCountMapOfA = new HashMap<Character, Integer>();
		Map<Character, Integer> charCountMapOfBSlices = null;
		countChars(A, charCountMapOfA);
		
		
		int resultCount = 0;
		for(int i=0; i<=(lengthofB - lengthofA); i++) {
			String windowSubstring = B.substring(i,i+lengthofA);
			charCountMapOfBSlices = new HashMap<Character, Integer>();
			countChars(windowSubstring, charCountMapOfBSlices);
			if(charCountMapOfA.equals(charCountMapOfBSlices)) {
				resultCount ++;
			}
		}
        
        return resultCount; 
	}

	private static void countChars(String A, Map<Character, Integer> charCountMapOfA) {
		for(int i=0; i<A.length(); i++) {
			char charAtI = A.charAt(i);
			Integer count = charCountMapOfA.get(charAtI);
			if(count == null ) {
				charCountMapOfA.put(charAtI, 1);
			}else {
				charCountMapOfA.put(charAtI, count + 1);
			}
		}
		
	}

}
