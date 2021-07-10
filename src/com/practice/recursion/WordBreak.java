package com.practice.recursion;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "apple"));
        int partitionStartPointer = 0;
        int end = s.length() - 1;
        Boolean result = checkWordBreak(s, wordDict, partitionStartPointer, end);
        System.out.println(result);
    }

    private static boolean checkWordBreak(String s, List<String> wordDict, int partitionStartPointer, int end) {

        //base case
        if (partitionStartPointer > end) {
            return true;
        }

        for (int i = partitionStartPointer; i <= end; i++) {
            String firstChunk = s.substring(partitionStartPointer, i + 1); // +1 because end parameter is exclusive
            //Checking if its valid word
            if (wordDict.contains(firstChunk)) {
                boolean validBreak = checkWordBreak(s, wordDict, i + 1, end);
                if (validBreak) {
                    return true;
                }
            }
        }

        return false;

    }
}
