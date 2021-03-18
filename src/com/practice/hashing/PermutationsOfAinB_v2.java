package com.practice.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationsOfAinB_v2 {

	public static void main(String[] args) {

		String A ="abc";
		String B = "abcbca";
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
		Map<Character, Integer> charCountMapOfBSlices = new HashMap<Character, Integer>();
		countChars(A, charCountMapOfA);
		
		for(int i=0; i<lengthofA; i++) {
			char charAtI = A.charAt(i);
			Integer count = charCountMapOfBSlices.get(charAtI);
			if(count == null ) {
				charCountMapOfBSlices.put(charAtI, 1);
			}else {
				charCountMapOfBSlices.put(charAtI, count + 1);
			}
		}
		
		
		int resultCount = 0;
		if(charCountMapOfA.equals(charCountMapOfBSlices)) {
			resultCount ++;
		}
		
		for(int i=lengthofA ,j=0; i<lengthofB; i++) {
			char charAtI = B.charAt(i);
			Integer count = charCountMapOfBSlices.get(charAtI);
			if(count == null ) {
				charCountMapOfBSlices.put(charAtI, 1);
			}else {
				charCountMapOfBSlices.put(charAtI, count + 1);
			}
			
			charCountMapOfBSlices.put(B.charAt(j), charCountMapOfBSlices.get(B.charAt(j)) - 1);
			j++;
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
