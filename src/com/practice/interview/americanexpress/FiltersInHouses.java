package com.practice.interview.americanexpress;

import java.util.LinkedList;

// Q3
public class FiltersInHouses {

	public static void main(String[] args) {
		String input = "a?b?aa";
		String result = solution(input);
		System.out.println(result);

	}

	private static String solution(String input) {
		LinkedList<Character> charMappings = new LinkedList<Character>(); 
		for(int i=0; i<input.length(); i++) {
			charMappings.add(input.charAt(i) );
		}
		
		for(int i=0; i<charMappings.size(); i++) {
			if(charMappings.get(i) == '?') {
				boolean validPlacement =  checkifConsiqutiveExisits(charMappings, i, 'a');
				if(validPlacement) {
					charMappings.set(i, 'a');
				}else {
					validPlacement =  checkifConsiqutiveExisits(charMappings, i, 'b');
					if(validPlacement) {
						charMappings.set(i, 'b');
					}
				}
			}
		}
		
		StringBuilder str = new StringBuilder();
		
		for(Character ch : charMappings) {
			str = str.append(ch);
		}
		
		
		return str.toString();
	}

	private static boolean checkifConsiqutiveExisits(LinkedList<Character> charMappings, int loc, char placementChar) {
		
		int sum = 0;
		int count = 1;
		for(int k=0; k<charMappings.size(); k++) {
			
			if(charMappings.get(k) == placementChar || k == loc) {
				sum = sum + 1;
			}else {
				sum = sum + 0;
			}
			
			if(count == 3) {
				if(sum == 3) {
					return false;
				}else {
					sum = 0;
					count =1 ;
					continue;
				}
			}
			count++;
		}
		
		return true;
		
	}

}
