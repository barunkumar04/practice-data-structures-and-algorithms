package com.practice.maths;


/**
 * Refer GCD class before proceeding.
 * 
 * This approach is called Euclid's method
 ***/

public class GCDOptimized {

	public static void main(String[] args) {
		System.out.println((gcd(100, 3)));

	}
	
    public static int gcd(int A, int B) {
    	//System.out.println(A +"\t"+ B);
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
        
        return gcd(B,A%B);
    }
}

/***

TC: O(log max(a,b))

Proof:  
	- After the first call, gcd(a, b) -> gcd(b, a%b)
	- Since b < a, then maximum possible value of expression a%b can return is less than a/2	
	- Similarly, In next call we will reduce b by its half.
	- So, in every call we are reducing values by its half.
**/