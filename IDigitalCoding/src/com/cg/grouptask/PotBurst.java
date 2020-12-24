package com.cg.grouptask;

/**
 * 
 * @author Aditya Ghogale & Ashutosh Javheri
 *
 *         Class with functionality to find minimum no of arrows required to
 *         burst pots placed at different heights.
 */
public class PotBurst {

	public static void main(String[] args) {
		// demo arrays
		int[] potPositionArray1 = { 5, 4, 3, 3, 2, 2, 1, 1, 1 };
		int[] potPositionArray2 = { 31, 25, 4, 3, 41, 40, 1 };

		// passing arrays to get minimu no. of arrows
		System.out.println("Minimum arrows required are : " + findMinimumNoOfArrowsReq(potPositionArray1));
		System.out.println("Minimum arrows required are : " + findMinimumNoOfArrowsReq(potPositionArray2));

	}

	// This method accepts array containing height of pots
	// Performs operations and returns minimum number of arrows required to burst
	// them all
	public static int findMinimumNoOfArrowsReq(int[] potPositionArray) {

		// if array is empty then no arrows is required
		if (potPositionArray.length == 0)
			return 0;

		// operation to sort array in descending order
		for (int i = 0; i < potPositionArray.length; i++) {
			int temp = 0;
			for (int j = i + 1; j < potPositionArray.length; j++) {
				if (potPositionArray[i] < potPositionArray[j]) {
					temp = potPositionArray[i];
					potPositionArray[i] = potPositionArray[j];
					potPositionArray[j] = temp;
				}
			}
		}

		// to count same number
		int sameNum = 0;

		// if array is not empty then there will be 1 sequence by default
		int seq = 1;

		// to keep track of number of repeated numbers.
		int prev = 0;

		// loop to go through all positions of pots
		for (int i = 1; i < potPositionArray.length; i++) {
			
			// when there is break between numbers. (like  41,35,23) 
			if (potPositionArray[i - 1] - potPositionArray[i] > 1) {
				seq++;
			}
			
			// when number or equal its the same number, hence we can form another set with
			if (potPositionArray[i] == potPositionArray[i - 1])
				sameNum++;
			if (potPositionArray[i] != potPositionArray[i - 1])
				sameNum = 0;
			
			//count number of sets apart from initial one
			if (prev < sameNum)
				prev = sameNum;
		}
		
		// combine both break in sequence and same numbers.
		return (seq + prev);
	}

}
