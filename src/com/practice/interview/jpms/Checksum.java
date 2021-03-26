package com.practice.interview.jpms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/***
 * Question - Find checksum of a given number
 * 
 * Logic to calculate checksum - 
 * 	1. Consider each digit
 *  2. digitChecksum = Multiply by 2
 *  	a. If digitChecksum is 1+ digits number take sum of each digits.
 *  3. checksum = checksum + digitchecksum;
 * 
 * 
 * @author Barun
 *
 */
public class Checksum {

	public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      System.out.println(checksum(line));
	    }
	  }

	private static int checksum(String numberStr) {
		int checksum = 0;
		int length = numberStr.length()-1;
		for(int i=length, count=1; i>=0; i--, count++) {
			int digitChecksum = 0;
			if(count % 2 == 0) {
				digitChecksum = 2 * Integer.valueOf(numberStr.charAt(i)+"");
				if(String.valueOf(digitChecksum).length() == 2 ) {
					digitChecksum = sumDigits(digitChecksum);
				}
			}else {
				digitChecksum = Integer.valueOf(numberStr.charAt(i)+"");
			}
			
			checksum = checksum + digitChecksum;
		}
		
		return checksum;
	}

	private static int sumDigits(int number) {
		int sumDigits = 0;
		
		while(number > 0 ) {
			sumDigits = sumDigits + number % 10;
			number = number / 10;
		}
		return sumDigits;
	}

}
