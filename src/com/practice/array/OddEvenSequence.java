package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class OddEvenSequence {

	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(12);
		A.add(10);
		A.add(28);
		A.add(37);
		A.add(43);
		A.add(40);
		A.add(14);
		A.add(12);
		A.add(48);
		
		int result = maxOddEvenSeq(A);
		System.out.println(result);
		
	}

	private static int maxOddEvenSeq(ArrayList<Integer> A) {

		if(A == null || A.size() == 0){
            return 0;
        }
        
        boolean lookForOdd = false;
        if (A.get(0) % 2 == 0){
            lookForOdd = true;
        }else{
            lookForOdd = false;
        }
        int length = 1;
        for(int i=1; i<A.size(); i++){
            
            String current = A.get(i) % 2 == 0 ? "Even" : "Odd"; 
            
            if(lookForOdd && "Odd".equals(current)){
                length++;
                lookForOdd = false;
                continue;
            }
            
            if(!lookForOdd && "Even".equals(current)){
                 length++;
                lookForOdd = true;
            }
        }
        

        
        return length;
	}

}
