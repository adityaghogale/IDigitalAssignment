package com.cg.individualtask;

import java.util.Scanner;

/**
 *
 * @author Aditya Ghogale
 *
 */

//main class
public class ChessBoardGame {

	public static void main(String[] args) {

		// variables to store co-ordinates for S and M
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

		// to accept size of board
		int size = 0;

		// variable to manage loop
		int flag = 1;

		// Object of scanner to accept input from user
		Scanner getPosition = new Scanner(System.in);

		// accept board size
		System.out.println("Enter size of board in even Only");
		size = getPosition.nextInt();

		// accepting position co-ordinates of S and M
		// loop will continue till flag=1
		while (flag == 1) {
			System.out.println("Enter value of x1 of S");
			x1 = getPosition.nextInt();
			System.out.println("Enter value of y1 of S");
			y1 = getPosition.nextInt();
			System.out.println("Enter value of x2 of M");
			x2 = getPosition.nextInt();
			System.out.println("Enter value of y2 of M");
			y2 = getPosition.nextInt();

			// call method to check number of moves required for collision
			int noOfMoves = calculateMinMoves(size, x1, y1, x2, y2);
			if (noOfMoves == 0)
				System.out.println("Both are in same position.Minimum no. of moves required are : " + noOfMoves);
			else if (Integer.MAX_VALUE == noOfMoves)
				System.out.println("Collision not possible");
			else
				System.out.println("Minimum no. of moves required are : " + noOfMoves);

			// to check whether user want to continue or not
			System.out.println("Would you like to continue 1/0");
			flag = getPosition.nextInt();
		}

		// closer scanner object
		getPosition.close();
	}

	// methods that will calculate number of moves required for M to collide with S
	public static int calculateMinMoves(int size, int x1, int y1, int x2, int y2) {

		try {
			// check whether position of S and M is within board size or not
			// if not then throw user defined GameException
			if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 || x1 > size - 1 || x2 > size - 1 || y1 > size - 1
					|| y2 > size - 1)
				throw new GameException("Invalid positions");

			// to check whether S and M are on same color block only then collision is
			// possible
			// if S and M are on different color block the throw Exception
			if ((x1 + y1) % 2 != (x2 + y2) % 2)
				throw new GameException("Two blocks cannot connect with each other");

			// check where S and M are in same position
			if ((x1 == x2) && (y1 == y2))
				return 0;

			// check where S and M are on same diagonal
			// if yes then only 1 move is required for collision
			// otherwise 2 moves are required
			if (Math.abs(x1 + y1) == Math.abs(x2 + y2))
				return 1;
			else
				return 2;

		} catch (GameException gameException) {
			// showing custom message
			System.out.println(gameException);
		}
		return Integer.MAX_VALUE;

	}

}
