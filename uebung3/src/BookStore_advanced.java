/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Last modified: 04.11.2010
* 
* Using array to store books
*/

public class BookStore_advanced {
	private Book[] Books = new Book[5];
		
	public BookStore_advanced() {
	}
	
	public void registerBooks() throws java.text.ParseException {
	  for (int i = 0 ; i<Books.length; i++) {
		  Books[i] = new Book();
		  Books[i].input();
		  System.out.print("Do you want to register another book (y/n)? ");
	      java.util.Scanner scn = new java.util.Scanner(System.in);
		  if (scn.nextLine().equals("n")) {
	        break;
	      }
	   }	  
	}
	
	public void listBooks() {
		for (int i = 0 ; i<Books.length; i++) {
				  if (Books[i] != null) System.out.println(Books[i] + "");
		 }
	}
	
	public String getCheapestBook() {
		Book cheapest = Books[0];
		
		for (int i = 1 ; i<Books.length; i++) {
			  if (Books[i] != null && Books[i-1].getPrice() > Books[i].getPrice() )
				  cheapest = Books[i];
		 }
	  return cheapest + "";
	}
}

