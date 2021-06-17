package com.practice.math;


/**
 * Approach - Chinese Mathemetician technique (https://en.wikipedia.org/wiki/Euclidean_algorithm)
 * 1. Use gcd(a,b) = gcd(b, a-b)
 * 2. Use recursive approach
 * 3. Swap a and b so that (a-b) doesnot returns negetive value 
 * 
 * Proof of gcd(a,b) = gcd(b, a-b)
 *  - Let say, b is smaller than a then we can write a = b + k
 *  - And k = a - b
 *  - Now, gcd(a,b) can be written as gcd(b+k, b)
 *  - Lets assume the gcd(a,b) = g. then g will be the gcd of (b+k, b) as well
 *  - Meaning, a, b and (b+k) is divisible by k
 *  - I.e. k is also divisble by g adn k = a -b
 * 
 ***/

public class GCD {

	public static void main(String[] args) {
		System.out.println((gcd(5, 10)));

	}
	
    public static int gcd(int A, int B) {
        //Base check
        if(B == 0){
            return A;
        }
        
        //Swaping to avoid negetive calculation
        if(A < B){
            int tmp = A;
            A = B;
            B = tmp;
        }
        
        return gcd(B, A-B);
    }
}
