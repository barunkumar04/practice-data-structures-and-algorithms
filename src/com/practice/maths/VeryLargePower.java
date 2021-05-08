package com.practice.maths;


/**
 * 
Problem Description
	Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
		"^" means power ,
		"%" means "mod", and
		"!" means factorial.

Problem Constraints
	1 <= A, B <= 5e5

Input Format
	First argument is the integer A
	Second argument is the integer B

Output Format
	Return one integer, the answer to the problem

Example Input
	Input 1:
		A = 1
		B = 1
Input 2:
		A = 2
		B = 2

Example Output
	Output 1:
		1
Output 2:
		4

Example Explanation
	Explanation 1:
		1! = 1. Hence 1^1 = 1.
	Explanation 2:
		2! = 2. Hence 2^2 = 4.
 * 
 * @author Barun
 *
 */

public class VeryLargePower {

	public static void main(String[] args) {
		System.out.println(calcLargePower(5, 100000200));

	}

	/**
     * Steps:
     * 1. Calculate B! % (1e9 + 7) to avoid overflow , lets say fact - O(B) 
     * 2. So the problem now is ((A^fact) % p))
     * 3. From Theorem - 
     *      a . a^(p-1) % p = 1
     *      b. Lets convert fact to (p-1) + (p-1) +(p-1) +...(p-1) + some remainder
     *      c. Then problem will look like to [A^(p-1) x A^(p-1)x A^(p-1)x A^(p-1)...x A^(some remainder) ] % p
     *      d. Then we need to calucate A^(some remainder) % p, using fact exponential method
     * 
     * Fast Exponential  - 
     *      when n is even: A^n = A^n/2 * A^n/2
     *      when n is odd:  A^n = A^n/2 * A^n/2 * A
     * */
	
	public static int calcLargePower(int A, int B) {
         int p = 1000000007;
         // Calculating factorial
         long fact = 1;
         for(int i =1; i<=B; i++){
             fact = (fact * i) % (p-1); // taking mod of (p-1) to follow the property of a^(p-1) % p = 1
         }
        
         
         long result = calcPowerFastExponential(A, fact, p);
         
         return (int)(result % p);
        
    }
    
    private static long calcPowerFastExponential(int A, long n, int p){
        //base case
        if(n==0) return 1;
        if(n==1) return A;
        
        long mult= calcPowerFastExponential(A, n/2, p) ;
        
        mult =  (((long) mult * mult) % p);
        
        //Multiplying one more time as n is even, for ex 2^5 = 2^2 * 2^2 * 2
        if (n % 2 != 0){
            mult  = mult * A;
        }
        
        return mult % p;
        
        
    }
}
