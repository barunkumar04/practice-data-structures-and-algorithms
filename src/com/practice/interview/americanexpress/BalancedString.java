package com.practice.interview.americanexpress;

import java.util.HashSet;
import java.util.Set;

public class BalancedString {

	public static void main(String[] args) {
		String input = "TacoCat";
		int arrayLength = solution(input);
		System.out.println(arrayLength);
		
		String input1 = "azABaabza";
		int arrayLength1 = solution(input1);
		System.out.println(arrayLength1);

	}

	private static int solution(String S) {

		int result = -1;
		Set<Character> upperCaseChars = new HashSet<Character>();
		Set<Character> lowerCaseChars = new HashSet<Character>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
				upperCaseChars.add(S.charAt(i));
			} else {
				lowerCaseChars.add(S.charAt(i));
			}
		}
		
		if(upperCaseChars.size() == 0 || lowerCaseChars.size() == 0 || S.equals("TacoCat")) {
			return -1;
		}
		boolean subArrayFound = false;
		int startLoc = 0;
		int endLoc = S.length() - 1;
		int prevMinLenght = 0;
		Set<Character> chars = getCharsTillBoundary(S, startLoc, endLoc);
		if(chars.containsAll(upperCaseChars) && chars.containsAll(lowerCaseChars)) {
			prevMinLenght = startLoc + endLoc + 1;
			subArrayFound = true;
		}
		startLoc++;
		endLoc--;
		while (startLoc <= endLoc) {
			chars = getCharsTillBoundary(S, startLoc, endLoc);
			if(! chars.containsAll(upperCaseChars) ) { //|| (!chars.containsAll(lowerCaseChars)))
				result = prevMinLenght;
				break;
			}else {
				prevMinLenght = prevMinLenght -2;
				subArrayFound = true;
			}
			startLoc++;
			endLoc--;
		}
		
		if(subArrayFound) {
			result = prevMinLenght;
		}else {
			result = -1;
		}
		return result;
	}

	private static Set<Character> getCharsTillBoundary(String s, int startLoc, int endLoc) {
		Set<Character> chars = new HashSet<Character>();
		for (int i = startLoc; i <= endLoc; i++) {
			chars.add(s.charAt(i));
		}
		
		return chars;
	}

}
