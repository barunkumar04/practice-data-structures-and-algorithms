package com.practice.optum;

public class WaitTimeAtPetrolPump {
	
	public static void main(String[] args) {
		int[] A = new int[5];
		int X=7,Y=11, Z=3;
		
		System.out.println(solution(A, X, Y, Z));
		
	}
	
	public static int solution(int[] A, int X, int Y, int Z) {
        
		int waitTime = 0;
		boolean isFirst = true;
		for(int i=0; i<=A.length;) {
			if(i==0 && A.length > 3) { //first allocation
				if(X >= A[i]) {
					X = X - A[i];
				}else {
					//calculate wait time
					if(Y >= A[i+1] && (Y- A[i+1]) >= A[i]) {
						waitTime = waitTime + A[i+1];
					}
					
					if(Z >= A[i+1] && (Z- A[i+1]) >= A[i]) {
						waitTime = waitTime + A[i+1];
					}
					
				}
				
				if(Y >= A[i+1]) {
					Y = Y - A[i+1];
				}else {
					//calculate wait time
					if(X >= A[i+2] && (X- A[i+2]) >= A[i]) {
						waitTime = waitTime + A[i+1];
					}
					
					if(Z >= A[i+2] && (Z- A[i+2]) >= A[i]) {
						waitTime = waitTime + A[i+1];
					}
					
				}
				
				
			}
		}
		return waitTime;
    }
}
