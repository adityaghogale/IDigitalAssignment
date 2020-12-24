package com.cg.individualtask;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public class BoardGameTesting {

	//for valid input if both S and M are in same diagonal
	@Test
	public void validPositionOneMove() {
		assertEquals(1, ChessBoardGame.calculateMinMoves(8, 1, 3, 4, 0));
	}
	
	//for valid input if both S and M are not in same diagonal
	@Test
	public void validPositionTwoMoves() {
		assertEquals(2, ChessBoardGame.calculateMinMoves(8, 1, 3, 5, 1));
	}
	
	/*@Test(expected = GameException.class)
	public void invalidPosition() {
		assertEquals("", ChessBoardGame.calculateMinMoves(8, 1, 3, 9, 1));
	}
	
	@Test(expected = GameException.class)
	public void impossiblePath() {
		assertEquals(2, ChessBoardGame.calculateMinMoves(8, 1, 3, 6, 1));
	}*/
	
	//for input if position of S or M is outside chess board
	@Test
	public void invalidPosition() {
		assertEquals(Integer.MAX_VALUE, ChessBoardGame.calculateMinMoves(8, 1, 3, 9, 1));
	}
	
	//if S and M are not i=on same color block
	@Test
	public void impossiblePath() {
		assertEquals(Integer.MAX_VALUE, ChessBoardGame.calculateMinMoves(8, 1, 3, 6, 1));
	}
}
