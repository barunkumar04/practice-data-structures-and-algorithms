package com.practice.recursion;

/**
 *
 * A password is considered strong if the below conditions are all met: It has at least 6 characters and at most 20 characters.
 * It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.
 *
 * In one step, you can:
 *     Insert one character to password,
 *     Delete one character from password, or
 *     Replace one character of password with another character.
 *
 * Example 1:
 * Input: password = "a"
 * Output: 5
 *
 * Example 2:
 * Input: password = "aA1"
 * Output: 3
 *
 *
 * Example 3:
 * Input: password = "1337C0d3"
 * Output: 0 Constraints: 1 <= password.length <= 50
 *
 * password consists of letters, digits, dot '.' or exclamation mark '!'.
 *
 */
public class PasswordFixEffortSlidingWindow {
    private static Boolean hasUpper = Boolean.FALSE;
    private static Boolean hasLower = Boolean.FALSE;
    private static Boolean hasDigit = Boolean.FALSE;
    public static void main(String[] args){
        System.out.println(fixPasswordEffort("aA1aaa")); // Output - 1
        System.out.println(fixPasswordEffort("aA1")); // Output - 3
        System.out.println(fixPasswordEffort("a")); // Output - 5
        System.out.println(fixPasswordEffort("1337C0d3")); // Output - 0
        System.out.println(fixPasswordEffort("aaa3bbb")); // Output - 2

    }

    public static int fixPasswordEffort(String input){
        int length  = input.length();
        int effort = 0;
        if(length < 6 ){
            effort = 6 - length;
        }
        if(length >= 3){
            int seqBreakEffort = 0;
            for(int i = 0; i<length; i++){
                int start = i;
                int end = (i+3) < length ? (i+3) : length;
                char[] chunkOfThreeChars = input.substring(start, end).toCharArray();
                seqBreakEffort += checkValidity(chunkOfThreeChars);
            }
            effort += hasUpper ? 0 : (seqBreakEffort > 0 ? 0 : 1);
            effort += hasLower ? 0 : (seqBreakEffort-1 > 0 ? 0 : 1);
            effort += hasDigit ? 0 : (seqBreakEffort-2 > 0 ? 0 : 1);
            effort += seqBreakEffort;
        }

        return effort;
    }

    private static int checkValidity(char[] chunk) {
        int effort = 0;
        int asciiSum = 0;
        for(int i=0; i <chunk.length; i++){
            if(chunk[i] >= 'A' &&  chunk[i] <= 'Z'){
                hasUpper = Boolean.TRUE;
            }else if (chunk[i] >= 'a' &&  chunk[i] <= 'z'){
                hasLower = Boolean.TRUE;
            }else if (chunk[i] >= '0' &&  chunk[i] <= '9'){
                hasDigit = Boolean.TRUE;
            }
            asciiSum += chunk[i];
        }
        if(asciiSum == chunk[0] * 3){
            effort = 1;
        }
        return effort;
    }

}

// TC - O(n^2)