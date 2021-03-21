package com.practice.string;

public class RotateNTimesClockWise {

	public static void main(String[] args) {
		String A = "scaler";
		int B = 2;
		System.out.println(rotateStringClockWise(A, B));
	}

	public static String rotateStringClockWise(String A, int B) {

		int length = A.length();
		int mod = B % length;
		String rotationPart = A.substring(length - mod, length);
		String secondPart = A.substring(0, length - mod);

		return rotationPart + secondPart;

	}
}

// alersc
// expected = erscal