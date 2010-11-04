/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Last modified: 04.11.2010
* 
*/

import java.util.Scanner;

public class PlayGuessChess_advanced {

  public static void main (String[] args) {
	boolean notValid = true;
	
	int row = 0;
	int column = 0;
	
	while (notValid) {
		System.out.println("Please enter Boardsize (rowsize x columnsize e.g. 7 x 8). Press Enter to use standard (8x8)");
		
		Scanner scn = new Scanner(System.in);
				
		if (scn.hasNextInt())
		  row = scn.nextInt();
		else {
		  System.out.println("Wrong input format (first Integer)! Try again.");
		  continue;
		}
		
		if (scn.hasNext("x"))
		  scn.next("x");
		else {
		  System.out.println("Wrong input format (x)! Try again.");
		  continue;
		}
		
		if (scn.hasNextInt()) { 
		  column = scn.nextInt();
		  notValid = false;
		}
		else {
		  System.out.println("Wrong input format (second integer)! Try again.");
		  continue;
		}
		
		try {
			  int tries = 1;
			  
			  int max = row > column ? row : column;
			  if (max >= 16) {
				  tries = 4;
			  }
			  else if (max >= 8) {
				  tries = 3;
			  }
			  else if (max >= 4) {
			      tries = 2;
			  }
			  
			  GuessChess_advanced gChess = new GuessChess_advanced(row, column, tries);
			  gChess.play();
		}
		catch (IllegalArgumentException e) { 
			  continue;
	    }
	}	
  }
}
