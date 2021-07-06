package com.practice.recursion;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Problem Description
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p>
 * Problem Constraints
 * 1 <= A <= 16
 * <p>
 * Input Format
 * First argument is an integer A.
 * <p>
 * Output Format
 * Return an array of integers representing the gray code sequence.
 * <p>
 * Example Input
 * Input 1:
 * A = 2
 * Input 1:
 * A = 1
 * <p>
 * Example Output
 * output 1:
 * [0, 1, 3, 2]
 * output 2:
 * [0, 1]
 * <p>
 * Example Explanation
 * Explanation 1:
 * for A = 2 the gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * So, return [0,1,3,2].
 * Explanation 1:
 * for A = 1 the gray code sequence is:
 * 00 - 0
 * 01 - 1
 * So, return [0, 1].
 */
public class GrayCode {

    public static void main(String[] args) {
        System.out.println(grayCode(2));
        System.out.println(grayCodeIterative(2));
    }

    // Approach - https://www.youtube.com/watch?v=ha1gEWYvr78
    public static ArrayList<Integer> grayCode(int a) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(1);
        if (a == 1) {
            return result;
        }
        int pow = 1;
        grayCode(pow, a, result);
        return result;
    }

    private static void grayCode(int currPow, int target, ArrayList<Integer> result) {

        //base case
        if (currPow >= target) {
            return;
        }

        int grayCodeFor = (int) Math.pow(2, currPow);
        ArrayList<Integer> resultSeq = new ArrayList<Integer>();
        for (int i = result.size() - 1; i >= 0; i--) {
            resultSeq.add(result.get(i) + grayCodeFor);
        }
        result.addAll(resultSeq);
        grayCode(currPow + 1, target, result);

    }

    public static ArrayList<Integer> grayCodeIterative(int A) {
        int n = A;
        ArrayList < Integer > result = new ArrayList < > ();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int curSize = result.size();
            // push back all element in result in reverse order
            for (int j = curSize - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            }
        }
        return result;
    }
}
