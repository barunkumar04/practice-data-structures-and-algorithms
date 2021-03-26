package com.practice.maths;

public class PalindromWithoutExtraSpace {

	public static void main(String[] args) {
		System.out.println(isPalindrome(2147447412));

	}

	public static boolean isPalindrome(int A) {
		
		if(A < 0)
			return false;
		
		int diviserFromLeft = 1;
		while (A / diviserFromLeft >= 10)
			diviserFromLeft = diviserFromLeft * 10;

		while (A > 0) {
			int leadingDigit = A / diviserFromLeft;
			int trailingDigit = A % 10;

			if (leadingDigit != trailingDigit)
				return false;

			A = (A % diviserFromLeft) / 10;
			diviserFromLeft = diviserFromLeft / 100;
		}

		return true;
	}
}
