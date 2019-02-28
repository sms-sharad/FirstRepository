package com.virtusa.BT;

import java.util.Scanner;

public class TicTacToeExample {
	 public static final int EMPTY = 0;
	   public static final int CROSS = 1;
	   public static final int NOUGHT = 2;
	 
	   public static final int PLAYING = 0;
	   public static final int DRAW = 1;
	   public static final int CROSS_WON = 2;
	   public static final int NOUGHT_WON = 3;
	 
	   // The game board and the game status
	   public static final int ROWS = 3, COLS = 3; // number of rows and columns
	   public static int[][] board = new int[ROWS][COLS]; // game board in 2D array
	                                                      //  containing (EMPTY, CROSS, NOUGHT)
	   public static int currentState;  // the current state of the game
	                                    // (PLAYING, DRAW, CROSS_WON, NOUGHT_WON)
	   public static int currentPlayer; // the current player (CROSS or NOUGHT)
	   public static int currntRow, currentCol; // current seed's row and column
	 
	   public static Scanner in = new Scanner(System.in); // the input Scanner
	 
	   /** The entry main method (the program starts here) */
	   public static void main(String[] args) {
	      initGame();
	      do {
	         playerMove(currentPlayer); // update currentRow and currentCol
	         updateGame(currentPlayer, currntRow, currentCol); // update currentState
	         printBoard();
	         if (currentState == CROSS_WON) {
	            System.out.println("'X' won! Bye!");
	         } else if (currentState == NOUGHT_WON) {
	            System.out.println("'O' won! Bye!");
	         } else if (currentState == DRAW) {
	            System.out.println("It's a Draw! Bye!");
	         }
	         // Switch player
	         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
	      } while (currentState == PLAYING); // repeat if not game-over
	   }
	 
	   /** Initialize the game-board contents and the current states */
	   public static void initGame() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            board[row][col] = EMPTY;  // all cells empty
	         }
	      }
	      currentState = PLAYING; // ready to play
	      currentPlayer = CROSS;  // cross plays first
	   }
	 
	   public static void playerMove(int theSeed) {
	      boolean validInput = false;  // for input validation
	      do {
	         if (theSeed == CROSS) {
	            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
	         } else {
	            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
	         }
	         int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
	         int col = in.nextInt() - 1;
	         if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
	            currntRow = row;
	            currentCol = col;
	            board[currntRow][currentCol] = theSeed;  // update game-board content
	            validInput = true;  // input okay, exit loop
	         } else {
	            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
	                  + ") is not valid. Try again...");
	         }
	      } while (!validInput);  // repeat until input is valid
	   }
	 
	   public static void updateGame(int theSeed, int currentRow, int currentCol) {
	      if (hasWon(theSeed, currentRow, currentCol)) {  // check if winning move
	         currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
	      } else if (isDraw()) {  // check for draw
	         currentState = DRAW;
	      }
	      // Otherwise, no change to currentState (still PLAYING).
	   }
	 
	   public static boolean isDraw() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            if (board[row][col] == EMPTY) {
	               return false;  // an empty cell found, not draw, exit
	            }
	         }
	      }
	      return true;  // no empty cell, it's a draw
	   }
	 
	   public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
	      return (board[currentRow][0] == theSeed         // 3-in-the-row
	                   && board[currentRow][1] == theSeed
	                   && board[currentRow][2] == theSeed
	              || board[0][currentCol] == theSeed      // 3-in-the-column
	                   && board[1][currentCol] == theSeed
	                   && board[2][currentCol] == theSeed
	              || currentRow == currentCol            // 3-in-the-diagonal
	                   && board[0][0] == theSeed
	                   && board[1][1] == theSeed
	                   && board[2][2] == theSeed
	              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
	                   && board[0][2] == theSeed
	                   && board[1][1] == theSeed
	                   && board[2][0] == theSeed);
	   }
	 
	   public static void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   public static void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }
	}
