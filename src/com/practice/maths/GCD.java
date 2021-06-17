package com.practice.maths;


/**
 * Approach - 
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
 *  - I.e. k is also divisible by g and k = a -b
 * 
 ***/

public class GCD {

	public static void main(String[] args) {
		System.out.println((gcd(100, 3)));

	}
	
    public static int gcd(int A, int B) {
        //Base check
        if(B == 0){
            return A;
        }
        
        //Swapping to avoid negative calculation
        if(A < B){
            int tmp = A;
            A = B;
            B = tmp;
        }
        
        return gcd(B, A-B);
    }
}

/***

TC - O(a/b)

Note, if b = 1(or a smaller b) then TC will be O(a). Which is again not much optimized
Example: gcd(100, 3) -> gcd(3, 97) -> gcd(3, 94) -> gcd(3, 91) -> .... -> gcd(3, 4) -> gcd(3, 1) -> gcd(2, 1) -> gcd(1, 1) -> gcd(1, 0) - > 1 is the answer.

We can optimize this by doing % operation and avoid method calls from gcd(3, 97) -> gcd(3, 94) -> gcd(3, 91) -> .... -> gcd(3, 4) . 

Proof: A number N can be written as N = k mod some_constant + r. In above approach we avoided k steps

Refer GCDOptimized class for code.
**/