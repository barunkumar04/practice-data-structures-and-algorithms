package com.practice.array;

/**
 * For problem statement and solution approach(Approach 3) refer https://docs.google.com/document/d/16Q85dI0OXGZ0SWH7D-Pb9MmBPagCQTO_iHGpNdg-E4s/edit# 
 * 
 * 
 * @author Barun
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] input = new int[] {2,0,2};
		System.out.println(trappedWaterVolumn(input));
	}
	 public static int trappedWaterVolumn(int[] height) {
	        //Finding max height
	        int maxHeight = Integer.MIN_VALUE;
	        int maxHeightIndex = -1;
	        for(int i=0; i<height.length; i++){
	            if(height[i] > maxHeight){
	                maxHeight = height[i];
	                maxHeightIndex = i;
	            }
	        }
	        int waterVolumn = 0;
	        //Iterate till maxHeightIndex, consider this as right max and calcualte water volumn from laft side of buildings
	        int leftMax = Integer.MIN_VALUE;
	        for(int i=0; i<maxHeightIndex; i++){
	            if(height[i] >  leftMax){
	                leftMax = height[i]; 
	            }
	            
	            waterVolumn += Math.min(leftMax, maxHeight) - height[i];
	        }
	       
	        //calculate for right side of maxHeightIndex
	        int rightMax = Integer.MIN_VALUE;
	        for(int i=height.length-1; i>maxHeightIndex; i--){
	             if(height[i] >=  rightMax){
	                rightMax = height[i]; 
	            }
	            
	            waterVolumn += Math.min(rightMax, maxHeight) - height[i];
	        }
	        
	        return waterVolumn;
	    }
}
