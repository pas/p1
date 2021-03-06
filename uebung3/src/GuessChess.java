/*


*/

import java.util.Random;
import java.util.Scanner;

public class GuessChess{
	private int secretRow;	   // secret row between 1 and 8
	private char secretColumn; // secret column between 'a' and 'h'
	private int score;	   // number of rounds won by player
	private int no_rounds;	   // total number of rounds played
	
	public final int MAX_GUESSES = 3;
 	
	/** Constructor */
	public GuessChess(){
		score = 0;
		no_rounds = 0;
	}
	
	/** Main loop: play until user says stop */
	public void play(){
		showWelcomeScreen();
		String goOn = "y";
		Scanner scn = new Scanner(System.in);
		while (goOn.equals("y")){
			doRound();
			System.out.print("Play another round (y or n)? ");
			goOn = scn.next().toLowerCase();
			System.out.println("");
		}
		printFinalResult();
	}

	/** Choose a field randomly and let the player guess */
	private void doRound(){
		Random generator = new Random();
		secretRow = generator.nextInt(7)+1;
		secretColumn = getColumnAsChar(generator.nextInt(7)+1);
		guessField();
		no_rounds++;
	}
	
	/** Let the player guess the right field at most MAX_GUESSES times */
	private void guessField(){
		
		printEmptyBoard();
		System.out.println();
		
		for (int i = MAX_GUESSES; i > 0; i--) {
			Scanner scn = new Scanner(System.in);
			System.out.print("You have " + i + " attempts left. Guess field: ");
			String line = scn.nextLine();
			char column = line.charAt(0);
			int row = Integer.parseInt(line.substring(1,2));
		
			printBoard(column, row);
			System.out.println();
			
	    	int directionRow = row - secretRow;
	    	int directionColumn = getColumnAsInt(column) - getColumnAsInt(secretColumn);
			
			if (directionColumn == 0 && directionRow == 0) {
		       System.out.println("That was right! You win!");
		       score++;
		       return;
			}
			else {
				if (i > 1) {
					System.out.print(line + " was wrong. Hints: ");
	    	
					if (directionRow  > 0)
						System.out.print("GO DOWN! ");
					if (directionRow < 0) 
						System.out.print("GO UP! ");
		
					if (directionColumn > 0) 
						System.out.print("GO LEFT!");
					if (directionColumn < 0)
						System.out.print("GO RIGHT!");
			
					System.out.println();
				}
				else {
					System.out.println("You lose! The secrect field was " + secretColumn+secretRow + ".");
					System.out.println();
				}
			}
	    }
	}

	/** Prints the final result (who won how often) */
	private void printFinalResult(){
		System.out.println("GAME OVER!");
		System.out.println("Final score: you won " + score + " of " + no_rounds + " rounds!");
	}
	
	
	// ==================================================================
	// Helper methods:
	
	/** prints a chess board with an 'X' on the field defined by column and row */	
	private void printBoard(char column, int row){
		int column_num = getColumnAsInt(column);
		String board = "  _ _ _ _ _ _ _ _\n";
		for(int i=8; i>0; i--){
			board += i;
			if(row==i){
				for(int j=1; j<=8; j++){
					if(column_num==j){
						board += "|X";
					}else{
						board += "|_";
					}
				}
				board += "|\n";
			}
			else{
				board += "|_|_|_|_|_|_|_|_|\n";
			}
		}
		board += "  a b c d e f g h ";
		System.out.println(board);
	}
	/** print the board without an 'X' */
	private void printEmptyBoard(){
		printBoard('z',-1);
	}
	
	private void showWelcomeScreen(){
		String s="";;
		s += "           ()\n";
		s += "         <~~~~>\n";
		s += "          \\__/\n";
		s += "         (____)                    ___/\"\"\"\n";
		s += "          |  |                    |___ 0 }\n";
		s += "          |  |    *************      /   }\n";
		s += "          |__|    *GUESS CHESS*    /~    }\n";
		s += "         /____\\   *************    \\____/\n";
		s += "        (______)                   /____\\\n";
		s += "       (________)                 (______)\n";
		System.out.println(s);
	}
	
	private int getColumnAsInt(char column){
		switch(column){
			case 'a': return 1;
			case 'b': return 2;
			case 'c': return 3;
			case 'd': return 4;
			case 'e': return 5;
			case 'f': return 6;
			case 'g': return 7;
			case 'h': return 8;
			default: return 0;
		}
	}
	private char getColumnAsChar(int column){
		switch(column){
			case 1: return 'a';
			case 2: return 'b';
			case 3: return 'c';
			case 4: return 'd';
			case 5: return 'e';
			case 6: return 'f';
			case 7: return 'g';
			case 8: return 'h';
			default: return 'z';
		}
	}
}