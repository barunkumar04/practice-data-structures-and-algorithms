package com.practice.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem statement -
 * https://docs.google.com/document/d/1XchOdqck1dIN025fSoGj29RF61SuFJBAN5IAa76s9Ao/edit?usp=sharing
 * 
 * @author Barun
 *
 */
public class WordSquare {
	private static ArrayList<String> words = new ArrayList<String>(
			Arrays.asList("AREA", "BALL", "DEAR", "LADY", "LEAD", "YARD"));
	private static Map<String, ArrayList<String>> prefixMatchingWords = new HashMap<>();

	public static void main(String args[]) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < words.size(); i++) {
			ArrayList<String> currentList = new ArrayList<String>();
			currentList.add(words.get(i));
			findWordSquare(currentList, 1, result);
		}
		System.out.println(result);
	}

	public static void findWordSquare(ArrayList<String> currentList, int index, ArrayList<ArrayList<String>> result) {
		// base condition - its square matrix
		if (currentList.size() == currentList.get(0).length()) {
			result.add(currentList);
			return;
		}

		// Creating prefix string by contacting each character at index in currentList
		StringBuilder prefixSB = new StringBuilder();
		for (String str : currentList) {
			prefixSB.append(str.charAt(index));
		}

		// Get all words in which are starting with prefix
		ArrayList<String> candidateWords = getCandidateWords(prefixSB.toString());

		// Recursively checking and adding to result set if these are next fit
		for (String candidateWord : candidateWords) {
			currentList.add(candidateWord);
			findWordSquare(currentList, index + 1, result);
		}

	}

	private static ArrayList<String> getCandidateWords(String prefix) {
		if (prefixMatchingWords.keySet().contains(prefix)) {
			return prefixMatchingWords.get(prefix);
		}
		ArrayList<String> candidateWords = new ArrayList<>();
		for (String word : words) {
			if (word.startsWith(prefix)) {
				candidateWords.add(word);
			}
		}
		prefixMatchingWords.put(prefix, candidateWords);
		return candidateWords;
	}

}
