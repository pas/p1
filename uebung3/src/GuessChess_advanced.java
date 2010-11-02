/*


*/

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class GuessChess_advanced {
	private int secretRow;	   // secret row between 1 and 8
	private char secretColumn; // secret column between 'a' and 'h'
	
	private int guessedRow;
	private char guessedColumn;
	private String guessed;
	
	private int score;	   // number of rounds won by player
	private int no_rounds;	   // total number of rounds played
	
	private int scoreFile;
	private int no_roundsFile;

	private int boardsize_rows;
	private int boardsize_columns;
	
	public final int MAXSIZE_ROWS = 25;
	public final int MAXSIZE_COLUMNS = 25;
	
	public final int MINSIZE_ROWS = 1;
	public final int MINSIZE_COLUMNS = 1;
	
	private int max_guesses;
	
	private ArrayList<Integer> guessedRows = new ArrayList<Integer>();
	private ArrayList<Character> guessedColumns = new ArrayList<Character>();
	 	
	/** Constructor with default values for row and column-size(8) and maximum guesses(3).*/
	public GuessChess_advanced() {
		score = 0;
		no_rounds = 0;
		boardsize_rows = 8;
		boardsize_columns = 8;
		max_guesses = 3;
		Initialize_ArrayList();
	}
	
	/** Constructor reading row-size, columns-size and maximum possible guesses specified in the arguments.*/
	public GuessChess_advanced(int rows, int columns, int guesses) {
		score = 0;
		no_rounds = 0;
		
		if (columns > MAXSIZE_COLUMNS || columns < MINSIZE_COLUMNS) {
			throw new IllegalArgumentException("Column is out of range!");
		}
		if (rows > MAXSIZE_ROWS || rows < MINSIZE_COLUMNS) {
			throw new IllegalArgumentException("Row is out of range!");
		}
		
		boardsize_rows = rows;
		boardsize_columns = columns;
		max_guesses = guesses;
		Initialize_ArrayList();
	}
	
	/** Initialize the ArrayList*/	
	private void Initialize_ArrayList() {
		for(int i = 0; i<boardsize_rows; i++) guessedRows.add(i, boardsize_rows+1);
		for(int i = 0; i<boardsize_columns; i++) guessedColumns.add(i, (char) (boardsize_columns+98));
	}
	
	/** Main loop: play until user says stop */
	public void play(){
		showWelcomeScreen();
		
		File statistic = new File(boardsize_rows + "x" + boardsize_columns + "-score.guess");
		try {
			statistic.createNewFile();
		}
		catch (IOException e) {
			System.out.println("Couldn't create new file. Statistics cannot be saved");
			e.printStackTrace();
		}
		
		try {
			Scanner file = new Scanner(statistic);
			file.useDelimiter(";"); file.next(); file.next();
			no_roundsFile = Integer.parseInt(file.next());
			scoreFile = Integer.parseInt(file.next());
		} 
		catch (FileNotFoundException e) {
			System.out.println("Couldn't read statistic file! Rounds and Score set to 0");
			e.printStackTrace();
			scoreFile = 0;
			no_roundsFile = 0;
		}
		
		showStatistic(scoreFile, no_roundsFile);
		
		String goOn = "y";
		Scanner scn = new Scanner(System.in);
		while (goOn.equals("y")){
			clearBoard();
			doRound();
			System.out.print("Play another round (y or n)? ");
			goOn = scn.next().toLowerCase();
		}
		printFinalResult();
		saveStatistics();
	}

	/** Choose a field randomly and let the player guess */
	private void doRound(){
		Random generator = new Random();
		secretRow = generator.nextInt(boardsize_rows-1)+1;
		secretColumn = getColumnAsChar(generator.nextInt(boardsize_columns-1)+1);
		guessField();
		no_rounds++;
	}
	
	/** Let the player guess the right field at most MAX_GUESSES times */
	private void guessField(){
		printEmptyBoard();
		System.out.println();
		
		for (int i = max_guesses; i > 0; i--) {
			readUserinput(i);
			
			printBoard(guessedColumn, guessedRow);
			System.out.println();
			
			if (i > 1) {
				guessedColumns.set(Math.abs(i-3), guessedColumn);
				guessedRows.set(Math.abs(i-3), guessedRow);
			}
	    	int directionRow = guessedRow - secretRow;
	    	int directionColumn = getColumnAsInt(guessedColumn) - getColumnAsInt(secretColumn);
			
			if (directionColumn == 0 && directionRow == 0) {
		       System.out.println("That was right! You win!");
		       score++;
		       return;
			}
			else {
				if (i > 1) {
					System.out.print(guessed + " was wrong. Hints: ");
	    	
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
			}
	    }
		System.out.println("You lose! The secrect field was " + secretColumn+secretRow + ".");
		System.out.println();
	}

	/** Reads the users input and checks for correctness. Saves the result in guessedRow and
	  guessedColumn and guessed. If input equals "exit" the program is terminated.
	  The active round counts as lost. */
	
	private void readUserinput (int attempts) {
		Scanner scn = new Scanner(System.in);
		boolean notValid = true;
		
		while(notValid) {
			System.out.print("You have " + attempts + " attempts left. Guess field: ");
			guessed = scn.nextLine().toLowerCase();
			
			if (guessed.equalsIgnoreCase("exit")) {
				no_rounds++;
				printFinalResult();
				saveStatistics();
				System.exit(0);
			}
			
			guessedColumn = guessed.charAt(0);
			
			try { 
				guessedRow = Integer.parseInt(guessed.substring(1,guessed.length()));
							
				if(isInsideTable(guessedColumn) && isInsideTable(guessedRow))
					notValid = false;	
			}
			catch (NumberFormatException e) { }
			
			if (notValid)
				System.out.println("Your input " + guessed.toUpperCase() + " is not valid! " +
						"Try again.");
		}
	}
		
	/** Saves statistic to a file named as "boardsize_rows"x"boardsize_columns"-scores.guess */
	
	private void saveStatistics() {
	      File ausgabeDatei = new File(boardsize_rows + "x" + boardsize_columns + "-score.guess"); 
	      
	      try { 
	    	  FileWriter fw = new FileWriter(ausgabeDatei); 
	    	  BufferedWriter bw = new BufferedWriter(fw); 
	    	  bw.write(boardsize_rows + ";" + boardsize_columns + ";" + (no_rounds+no_roundsFile) 
	    			  + ";" + (score+scoreFile) + ";"); 
	    	  bw.newLine(); 
	    	  bw.close();
	      }
	      catch (IOException e) { 
	    	  System.out.println("Couldn't write score!" + e.getStackTrace()); 
	      }
	}
	
	/** Prints the final result (who won how often) */
	private void printFinalResult(){
		System.out.println("GAME OVER!");
		System.out.println("Final score: you won " + score + " of " + no_rounds + " rounds!");
		
		showStatistic(scoreFile+score, no_roundsFile+no_rounds);	      
	}
	
	
	// ==================================================================
	// Helper methods:
	
	/** Reads the file score.guess and shows the statistic of the game */
	
	public void showStatistic(int score, int no_rounds) {		
		NumberFormat fmt = NumberFormat.getPercentInstance();
		
		String statistics = " _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n";
		statistics += "| \n";
		statistics += "| YOUR GUESS CHESS STATISTIC\n";
		statistics += "| \n";
		statistics += "| Boardsize: " + boardsize_rows + " rows, " + boardsize_columns + " columns\n";
		statistics += "| \n";
		statistics += "| Played rounds: " + no_rounds + "\n";
		statistics += "| \n";
		statistics += "| Score: " + score + "\n";
		statistics += "| \n";
		statistics += "| You won " + fmt.format((float)score/no_rounds) + " of your games!\n";
		statistics += "| _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ";
		
		System.out.println(statistics);
	}
	
	/** Clears all former guesses */
	
	private void clearBoard () {
		for(int i = 0; i<guessedRows.size(); i++) guessedRows.set(i, boardsize_rows+1);
		for(int i = 0; i<guessedColumns.size(); i++) guessedColumns.set(i, (char) (boardsize_columns+97)); // Convert int to char (97 == a in ASCII)		
	}
	
	/** prints a chess board with an 'X' on the field defined by column and row and an O on 
	 *  former guessed fields. */	
	private void printBoard(char column, int row){
		int column_num = getColumnAsInt(column);
		String board = " ";
		if (boardsize_columns > 9) board += " ";
		
		for(int i=0; i<boardsize_columns; i++) board += " _";
		
		board += "\n";
				
		for(int i=boardsize_rows; i>0; i--) {
			if (boardsize_rows<10) 
				board += i;
			else {
				DecimalFormat fmt = new DecimalFormat("00");
				board += fmt.format(i);
			}
				for(int j=1; j<=boardsize_columns; j++){
					if(column_num==j && row==i)
						board += "|X";
					else
						board += "|_";
					for (int g=0; g<guessedColumns.size(); g++) {
						if ( 	   getColumnAsInt(guessedColumns.get(g))==j 
								&& guessedRows.get(g)== i 
								&& !(row == i && column_num == j) ) {
							board = board.substring(0, board.length()-2);
							board += "|O";
						}
					}
				}
				board += "|\n";
			}
		
		board += " ";
		if (boardsize_columns>9) board += " ";
		
		for(int i=97; i<boardsize_columns+97; i++) board += " " + (char) i;
		
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
		if (Character.isLowerCase(column) && column < 122)
			return ((int) column)-96; 
		else
			return 0;		
	}
	
	private char getColumnAsChar(int column){			
		if (column < 25)
			return (char) (column + 97);
		else
			return 'z';		
	}
	
	/** Checks if the given character is inside the table (column). */
	private boolean isInsideTable (char toCheck) {
		if (toCheck <= boardsize_rows+96 && toCheck >= 96 )
			return true;
		else
			return false;
	}
	
	/** Checks if the given integer is inside the table (row). */
	private boolean isInsideTable (int toCheck) {
		if (toCheck <= boardsize_columns && toCheck > 0)
			return true;
		else
			return false;	
	}
}