package com.practice.recursion;

import java.util.ArrayList;

/**
 *
 Problem Description
     Given a string A, partition A such that every string of the partition is a palindrome.
     Return all possible palindrome partitioning of A.
     Ordering the results in the answer : Entry i will come before Entry j if :
     len(Entryi[0]) < len(Entryj[0]) OR
     (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
     (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))

 Problem Constraints
    1 <= len(A) <= 15

 Input Format
    First argument is a string A of lowercase characters.

 Output Format
    Return a list of all possible palindrome partitioning of s.

 Example Input
    Input 1:
        A = "aab"
    Input 2:
        A = "a"

 Example Output
    Output 1:
        [   ["a","a","b"]
            ["aa","b"],
        ]
    Output 2:
        [
            ["a"]
        ]
 *
 *
 */


/**
 * Solution apporach - https://www.youtube.com/watch?v=WBgsABoClE0
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String a = "efe";
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> candidate = new ArrayList<String>();

        int startIndex = 0;
        int endIndex = a.length();
        partitionAndCheckPalindrom(a, startIndex, endIndex, candidate, result);
        System.out.println(result);
    }

    private static void partitionAndCheckPalindrom(String input, int currIndex, int endIndex, ArrayList<String> candidate, ArrayList<ArrayList<String>> result) {
        //Base check
        if (currIndex == endIndex) {
            //add candidate to result set
            result.add(new ArrayList<>(candidate));
            return;
        }

        for (int i = currIndex; i < endIndex; i++) {
            if (isPalindrom(input, currIndex, i)) {
                candidate.add(input.substring(currIndex, i + 1));
                partitionAndCheckPalindrom(input, i + 1, endIndex, candidate, result);
                candidate.remove(candidate.size() - 1);

            }
        }
    }

    private static boolean isPalindrom(String a, int currIndex, int endIndex) {
        if (currIndex >= endIndex) {
            return true;
        }

        if (a.charAt(currIndex) != a.charAt(endIndex)) {
            return false;
        }
        return isPalindrom(a, currIndex + 1, endIndex - 1);


    }
}
