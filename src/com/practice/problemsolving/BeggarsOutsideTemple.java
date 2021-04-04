package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

public class BeggarsOutsideTemple {

	public static void main(String[] args) {
		 int noOfBeggers = 5;
		 ArrayList<Integer> donation = null;
		 
		 ArrayList<ArrayList<Integer>> devotees = new ArrayList<ArrayList<Integer>>();
		 
		 donation =  new ArrayList<Integer>(Arrays.asList(1,2,10));// Amount 10 to beggars 1 to 2
		 devotees.add(donation);
		 
		 donation =  new ArrayList<Integer>(Arrays.asList(2,3,20));// Amount 20 to beggars 2 to 3
		 devotees.add(donation);
		 
		 donation =  new ArrayList<Integer>(Arrays.asList(2,5,25));// Amount 20 to beggars 2 to 3
		 devotees.add(donation);
		 
		 ArrayList<Integer> beggarsCollection  = calculateBeggerCollections(noOfBeggers, devotees);
		 
		 System.out.println(beggarsCollection);
	}

	private static ArrayList<Integer> calculateBeggerCollections(int noOfBeggers,
			ArrayList<ArrayList<Integer>> devotees) {

		ArrayList<Integer> beggerCollections = new ArrayList<Integer>();
		for(int i=0; i<noOfBeggers; i++) {
			beggerCollections.add(0);
		}
		
		
		for(ArrayList<Integer> beggarsAndDonation : devotees) {
			int amount = beggarsAndDonation.get(2);
			int beggarStartIndex = beggarsAndDonation.get(0)-1;
			int beggarEndIndex = beggarsAndDonation.get(1)-1;
			
			beggerCollections.set(beggarStartIndex, beggerCollections.get(beggarStartIndex) + amount);
			if((beggarEndIndex+1) == beggerCollections.size())
				continue;
			beggerCollections.set(beggarEndIndex+1, beggerCollections.get(beggarEndIndex+1) + (amount * -1));
			
		}
		
		//Take prefix sum to calculate final amount distributed
		int lastSum = beggerCollections.get(0);
		for(int i=1; i<beggerCollections.size(); i++) {
			lastSum = lastSum + beggerCollections.get(i);
			beggerCollections.set(i, lastSum);
		}
		
		return beggerCollections;
	}

}
