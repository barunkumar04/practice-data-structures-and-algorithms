package com.practice.backtracking;

public class UniquePathsIII {
    
	private static int row = 0;
    private static int col = 0;
    
	public static void main(String[] args) {
		
		int[][] A = new int[][]{
			{1, -1},
			{0, 2,}
		};	

		  int totalValidCellCount = 0;
	        int startCell_i = 0;
	        int startCell_j = 0;
	        
	        row = A.length;
	        col = A[0].length;
	        
	        for(int i=0; i<row; i++){
	            for(int j=0; j<col; j++){
	                if(A[i][j] == 0) 
	                    totalValidCellCount++;
	                if(A[i][j] == 1){
	                    startCell_i = i;
	                    startCell_j = j;
	                }
	            }
	        }
	        int validCellCount = -1; //Starting with -1 because first step is cell having 1
	        int pathCount = countValidPaths(A, startCell_i, startCell_j, validCellCount, totalValidCellCount);
	        System.out.println(pathCount);

	}
	
	private static int countValidPaths(int[][] A, int i, int j, int walkedValidCellCount, int totalValidCellCount){
        if(isInvalidMove(A, i, j)){
            return 0;
        }
        if(A[i][j] == 2){ // Reached destination, but lets check if its valid
            if(walkedValidCellCount == totalValidCellCount){
                return 1;
            }else{
                return 0;
            }
            
        }
        
        A[i][j] = -1; // Marking as -1 so that its not revisied again for current path
        // Move up, down, left and right and check if its a valid path.
        int pathCount = countValidPaths(A, i-1, j, walkedValidCellCount+1, totalValidCellCount) + countValidPaths(A, i+1, j, walkedValidCellCount+1, totalValidCellCount)
                            + countValidPaths(A, i, j-1, walkedValidCellCount+1, totalValidCellCount) + countValidPaths(A, i, j+1, walkedValidCellCount+1, totalValidCellCount);
        //Since path has traversed, backtracing (i.e. reseting to 0)
        A[i][j] = 0;
        
        return pathCount;
    }
    
    private static boolean isInvalidMove(int[][] A, int i, int j){
        if(i < 0 || j < 0 || i >= row || j >= col || A[i][j] == -1){
            return true;
        }else{
            return false;
        }
    }
}
