package com.practice.bitwise;

public class NumberAddition {

	public static void main(String[] args) {

		Solution solution = new Solution();
		System.out.println(solution.addBinary("1010110111001101101000", "1000011011000000111100110"));

	}

}

class Solution {
	public String addBinary(String A, String B) {
		int A_length = A.length() - 1;
		int B_length = B.length() - 1;

		int carry = 0;

		// This is to hold the output binary number
		StringBuilder result = new StringBuilder();
		while (A_length >= 0 || B_length >= 0) {
			int b1 = A_length >= 0 ? ( A.charAt(A_length) == '0' ? 0 : 1 ): 0;
			int b2 = B_length >= 0 ? ( B.charAt(B_length) == '0' ? 0 : 1 ): 0;
			result = result.append((int) ((b1 + b2 + carry) % 2));
			//sum[i++] = (int) ((b1 + b2 + carry) % 2);
			carry = (int) ((b1 + b2 + carry) / 2);
			A_length--;
			B_length--;
		}
		if (carry != 0) {
			result = result.append(carry);
		}
		
		return result.reverse().toString();
	}
}