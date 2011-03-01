/*
*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Last modified: 17.10.2010
*
*
*/

import java.util.Date;
import java.text.*;
import java.util.Scanner;


public class Book{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;

	public static final String DATE_FORMAT = "dd.MM.yyyy";

	public Book (int idCons, String titleCons, String authorCons, String dateCons) {
	  id = idCons;
	  title = titleCons;
	  author = authorCons;
	  try { dateOfPublication = stringToDate(dateCons); }
	  catch (ParseException e) { 
		  System.out.println("No valid date in constructor. Date of publication set to today."); 
		  dateOfPublication = new Date();
	  }
	}

	public Book () {
		input();
	}

	/** Returns the age of the book in days since publication */
	public int age(){
		Date today = new Date();
		long age = today.getTime() - dateOfPublication.getTime();
		age = age / 1000 / 60 / 60 / 24; 
		return (int) age;
	}

	/** Returns a String representation of the book */
	public String toString(){
		return (id + ", " + title + ", " + author 
			 + ", " + dateToString(dateOfPublication));
	}

	/** Reads all book data from user input */
	public void input() {
		Scanner scn = new Scanner(System.in);
			
		boolean notValidId = true;
		while (notValidId) {
			  System.out.print("Please enter id: ");		
		      try { id = Integer.parseInt(scn.nextLine()); notValidId = false; }
			  catch (NumberFormatException e) { System.out.println("No valid input."); }
		}
				
		System.out.print("Please enter booktitle: ");
		title = scn.nextLine();
		System.out.print("Please enter author: ");
		author = scn.nextLine();
		
		boolean notValidDate = true;
		
		while (notValidDate) {
		  System.out.print("Please enter date of publication (format: dd.mm.yyyy): ");		
	      try { dateOfPublication = stringToDate(scn.nextLine()); notValidDate = false; }
		  catch (ParseException e) { System.out.println("No valid input."); }
		}
	
	}

	// Get-/Set-methods
	public void setId (int input) {
	  id = input;
	}
	public int getId() {
		return(id);
	}

	public void setTitle(String input) {
		title = input;
	}
	public String getTitle() {
		return(title);
	}
	
	public void setAuthor (String input) {
		author = input;
	}
	public String getAuthor() {
		return(author);
    }
	
	public void setDate (String input) {
		try { dateOfPublication = stringToDate(input); } 
		catch (ParseException e) { System.out.println("No valid input for setDate"); }
	}
	public String getDate() {
		return(dateToString(dateOfPublication));
	}
	
	// private methods --------------------------------------------
	/** Converts the Date object d into a String object */
	private String dateToString(Date d){
		SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT);
		return fmt.format(d);
	}

	/** Converts the String object s into a Date object */
	private Date stringToDate(String s) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT);
		return fmt.parse(s);
	}
}
