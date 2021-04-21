package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**

Circle of Monsters
	Problem Description
		You are playing another computer game, and now you have to slay n monsters. These monsters are standing in a circle, numbered clockwise from 1 to n. Initially, the i-th monster has ai health.
		You may shoot the monsters to kill them. Each shot requires exactly one bullet and decreases the health of the targeted monster by 1 (deals 1 damage to it). Furthermore, when the health of some monster i becomes 0 or less than 0, it dies and explodes, dealing bi damage to the next monster (monster i+1, if i < n, or monster 1, if i=n). If the next monster is already dead, then nothing happens. If the explosion kills the next monster, it explodes too, damaging the monster after it and possibly triggering another explosion, and so on.
		You have to calculate the minimum number of bullets mod 10 9 + 7 you have to fire to kill all n monsters in the circle.
		NOTE: If the minimum no. of bullets are x then you have to return x % 1e9 + 7 .


Problem Constraints
	2<= n <=300000
	1<= A[i], B[i]<= 1e9

Input Format
	First Argument is array of integers of N size denoting array A Second Argument is array of integers of N size denoting array B

Output Format
	Return the miniumum number of bullets mod 10 9 + 7 you have to fire to kill all of the monsters.


Example Input
	Input- 1
		A=[7,2,5]
		B=[15,14,3]
	Input- 2
		A=[1 2]
		B=[2 1]

Example Output
	Output- 1
		6
	Output- 2
		1

Example Explanation
	Explanation-1
		Firstly we shoot 2nd monster whose health is 2 with 2 bullets and then this monster will create damage of 14 to another monster.
		Now 3rd monster health will decrease by 14 units . hence 3rd monster also died . hence it will create damage of 3 units to 1st monster
		Now 1st monster health is 7-3=4 . and now 4 more bullets are required to kill 1st monster.
		Total bullets required to kill all the monsters = 2+4= 6
	Explanation-2
		Kill 1st monster with 1 bullet so it will cause 2 units of damage to 2nd monster.
		Hence 2nd monster automatically died.
		Total bullets required=1

 * 
 * 
 * @author Barun
 *
 */
public class CircleOfMonsters {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7,2,5));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(15,14,3));
		
		System.out.println(solve(A, B));
	}
	
	 public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
	        
	        int mod = 1000000007;
	        long bulletsToKillAllWithDamage=0;
	        // Calculating totoal number of bullets to kill all monsters, consider there will be damages from previous one.=, i.e. max(0, A[i], B[i-1])
	        for(int i=0; i<A.size(); i++){
	            long health = 0 ;
	            long damage = 0;
	            
	            if(i == 0){
	                health = A.get(i) ;
	                damage = B.get(A.size()-1); // Since this is first element, last monster in circle will impact first one.
	            }else{
	                 health = A.get(i) ;
	                 damage = B.get(i-1);
	            }
	            bulletsToKillAllWithDamage = bulletsToKillAllWithDamage + max(0, health - damage);
	        }
	        long minBulletCount = Long.MAX_VALUE;
	        //Calculating bullets count to kill each monster and tracking minimum of those.
	        for(int i=0; i<A.size(); i++){
	            long health = 0 ;
	            long damage = 0;
	            
	            if(i == 0){
	                health = A.get(i) ;
	                damage = B.get(A.size()-1); // Since this is first element, last monster in circle will impact first one.
	            }else{
	                 health = A.get(i) ;
	                 damage = B.get(i-1);
	            }
	            /**
	             * bulletsToKillAllWithDamage contains ttotoal number of bullets to kill all monsters, consider there will be damages from previous one.
	             * But, for first one, there is no damage from previous one. Hence, we must need its health equivalent bullets to kill first one.
	             * Hence, from bulletsToKillAllWithDamage, we must reduce max(0, A[i], B[i-1]), what we have added consider there will be damage from previous one.
	             * Now, we need to hit bullets equivalent to ith health.
	             * 
	             * */
	            long bulletCount = bulletsToKillAllWithDamage - max(0, health - damage)  + health; // bulletsToKillAllWithDamage contains total number of 
	            if(bulletCount < minBulletCount)
	                minBulletCount = bulletCount;
	        }
	        
	        return (int)(minBulletCount % mod );
	        
	    }
	    
	    public static long max(long val1, long val2){
	        
	        return val1 > val2 ? val1 : val2;
	    }
}
