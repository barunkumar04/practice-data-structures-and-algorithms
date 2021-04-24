package com.practice.interview.google;


/**
 * 
 * Problem statement
 * 	https://docs.google.com/document/d/130mAVdQ_f0gYp0eKrDSuyfAwGZLjbt4dC2vb4X6LQ-s/edit?usp=sharing 
 * 
 * @author Barun
 *
 */

public class StringDecompresison {

	private static int start = 0;
	public static void main(String[] args) {
		String inputStr = "3[abc2[bc]d]c"; //3[abcbcbcd]c ->  abcbcbcdabcbcbcdabcbcbcdc 
		int end = inputStr.length() - 1;
		StringBuilder decompressedString = new StringBuilder();

		while (start <= end) {
			char ch = inputStr.charAt(start);
			if (ch >= 'a' && ch <= 'z') {
				decompressedString.append(ch);
			} else { // its a case where expansion is required.
				decompressedString.append(decompress(inputStr));
			}
			start++;
		}
		System.out.println("decompressed String: " + decompressedString.toString());

	}

	public static String decompress(String inputStr) {
		// start index is either pointing to a digit or a '['. Example 2[ab] or ab[]d
		// (i.e. ab1[]d)

		int decompCount = 0;
		if (!isDigit(inputStr.charAt(start + 1)) && inputStr.charAt(start + 1) != '[') { // its ab[]d case -> ab1[]d
			decompCount = 1;
		} else {
			while (isDigit(inputStr.charAt(start))) {
				decompCount = decompCount * 10 + Integer.parseInt(inputStr.charAt(start) + "");
				start++;
			}
		}
		// here, start is pointing to '['
		start++;

		StringBuilder strToExpand = new StringBuilder();
		while (inputStr.charAt(start) != ']') { // fetching string to be expanded decompCount time;

			char ch = inputStr.charAt(start);
			if (!(ch >= 'a' && ch <= 'z')) { // If there is nested expansion
				strToExpand.append(decompress(inputStr));
				start++;
				continue;
			}
			strToExpand.append(ch);
			start++;
		}
		// expanding
		StringBuilder expandedString =new StringBuilder();
		for (int i = 0; i < decompCount; i++) {
			expandedString.append(strToExpand);
		}
		return expandedString.toString();

	}

	private static boolean isDigit(char ch) {
		if (ch >= '0' && ch <= '9')
			return true;
		else
			return false;
	}

}
