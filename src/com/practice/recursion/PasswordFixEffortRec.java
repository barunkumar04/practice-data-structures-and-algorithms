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
public class PasswordFixEffortRec {
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
        if(length < 6 ) {
            effort = 6 - length;
        }else if (length >= 3){
            effort = checkValidity(input, 0, '\n', 0, effort);
            effort += hasUpper ? 0 : 1;
            effort += hasLower ? 0 : 1;
            effort += hasDigit ? 0 : 1;
        }

        return effort;
    }

    /**
     *
     * Approach -
     *  1. Called when length is more than 3. Because these could ob chance of invalidity
     *  2. In recursive call check:
     *      a. Its has upper char, lower char and digit
     *      b. Also, it there were consecutive chars
     *  3. When there are 3 consecutive found, add 1 to effort
     *  4. At the end allocate 1 for each non-occurred Upper char, Lower char and Digit
     *
     * @param input
     * @param loc
     * @param prevChar
     * @param sameCharCountSeqCount
     * @param effort
     * @return
     */

    private static int checkValidity(String input, int loc, char prevChar, int sameCharCountSeqCount, int effort){
        if(loc == input.length()){
            return  effort;
        }
        if(prevChar == input.charAt(loc)){
            sameCharCountSeqCount ++;
        }else{
            sameCharCountSeqCount = 0;
        }

        if(sameCharCountSeqCount == 2){
            effort ++;
        }

        if(input.charAt(loc) >= 'A' &&  input.charAt(loc) <= 'Z'){
            hasUpper = Boolean.TRUE;
        }else if (input.charAt(loc) >= 'a' &&  input.charAt(loc) <= 'z'){
            hasLower = Boolean.TRUE;
        }else if (input.charAt(loc) >= '0' &&  input.charAt(loc) <= '9'){
            hasDigit = Boolean.TRUE;
        }

        return  checkValidity(input, loc+1, input.charAt(loc), sameCharCountSeqCount, effort);

    }
}

// TC - O(n)