package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 * NOTE: Order of the resultant array should be same as the input array.
 * <p/>
 * Problem Constraints
 *      1 <= length of the array <= 100000
 *      1 <= A[i] <= 106
 * <p/>
 * Input Format
 *      The only argument given is the integer array A.
 * <p/>
 * Output Format
 *      Return the count of divisors of each element of the array in the form of an array.
 * <p/>
 * Example Input
 * <p/>
 *  Input 1:
 *      A = [2, 3, 4, 5]
 * <p/>
 *  Input 2:
 *      A = [8, 9, 10]
 * <p/>
 * Example Output
 * <p/>
 *  Output 1:
 *      [2, 2, 3, 2]
 * <p/>
 *  Output 1:
 *      [4, 3, 4]
 * <p/>
 * Example Explanation
 *      Explanation 1:
 *          The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 *          So the count will be [2, 2, 3, 2].
 *      Explanation 2:
 *          The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 *          So the count will be [4, 3, 4].
 */
public class CountOfDivisors {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        System.out.println(countDivisor(A));
    }

    public static ArrayList<Integer> countDivisor(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer a : A) {
            int count = 0;
            double sqrtVal = Math.sqrt(a); // calculate square root once instead of doing multiple times in for-loop condition
            for (int i = 1; i < sqrtVal; i++) {
                if (a % i == 0)
                    count = count + 2; // +2 is because we are considering another pair. for example: a = 9 | loop runs till < 3 | for i=1, there are two factors 1 and 9.
            }
            if (a % sqrtVal == 0) { // perfect square case handling
                count++;
            }
            result.add(count);
        }
        return result;
    }
}
