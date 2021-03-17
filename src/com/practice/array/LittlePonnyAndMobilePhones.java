package com.practice.array;

public class LittlePonnyAndMobilePhones {

	public static void main(String[] args) {
		int A[] = new int[] {3, 4, 4, 6};
		int B[] = new int[] {20, 4, 10, 2};
		
		int[] purchaseCount = solve(A, B);

	}
	
	 public static int[] solve(int[] A, int[] B) {
	        
	        int[] purchaseCount = new int[B.length];
	        
	        for(int i=0; i<B.length; i++){
	            int moneyExpend = 0; 
	            for(int j=1; j<=A.length; j++){
	                moneyExpend = moneyExpend + A[j-1];
	                if(moneyExpend > B[i] ) {
	                    purchaseCount[i] = j-1;
	                    break;
	                }
	                if(j==A.length && moneyExpend <= B[i]){
	                    purchaseCount[i] = A.length;
	                    break;
	                }
	            }
	            System.out.println("For "+B[i]+" ruppes -"+purchaseCount[i]+" purcsahed.");
	        }
	        
	        return purchaseCount;
	    }

}
