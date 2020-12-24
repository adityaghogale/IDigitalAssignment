package com.cg.grouptask;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Aditya Ghogale
 *
 *	Test functionality of pot burst class
 */
public class PotBurstTest {

	//when valid input is provided
	@Test
	public void validInput() {
		int[] arr= {5,4,3,3,2,2,1,1,1};
		assertEquals(3, PotBurst.findMinimumNoOfArrowsReq(arr));
	}
	
	//when invalid input is provided
	@Test
	public void invalidInput() {
		int[] arr= {};
		assertEquals(0, PotBurst.findMinimumNoOfArrowsReq(arr));
	}
	
	//when improper input is provided
	@Test
	public void nonSeqInput() {
		int[] arr= {31,21,5,4,3,1};
		assertEquals(4, PotBurst.findMinimumNoOfArrowsReq(arr));
	}
}
