import java.text.ParseException;

public class BookStore {

	private Book firstBook = new Book();
	private Book secondBook = new Book();
	private Book thirdBook = new Book();
	private Book forthBook = new Book();
	private Book fifthBook = new Book();
	
	private int registeredBooks = 0; 
	
	public BookStore() {
	}
	
	public void registerBooks() throws ParseException {
	  
	  String next = "y";
	  int i = 0;
		
	  while (i < 5 && next.equalsIgnoreCase("y")) {
          Book tmpBook;
		  switch (i) {
			  case 0 :
				  tmpBook = firstBook;
				  break;
			  case 1 :
				  tmpBook = secondBook;
				  break;
			  case 2 :
				  tmpBook = thirdBook;
				  break;
			  case 3 :
			  	  tmpBook = forthBook;
			  	  break;
			  case 4 :
			      tmpBook = fifthBook;
			      break;
			  default :
			      tmpBook = new Book(); // To keep java warnings still
		   }
		  tmpBook.input();
		  registeredBooks++;
		  if (i < 4) {
			  System.out.print("Do you want to register another book (y/n)? ");
			  java.util.Scanner scn = new java.util.Scanner(System.in);
			  next = scn.nextLine();
		  }
	    }
	  
	}
	
	public void listBooks() {
	  switch (registeredBooks) {
		  case 1 :
			  System.out.println(firstBook + "");
		  case 2 :
			  System.out.println(firstBook + "");
			  System.out.println(secondBook + "");
		  case 3 :
			  System.out.println(firstBook + "");
			  System.out.println(secondBook + "");
			  System.out.println(thirdBook + "");
		  case 4 :
			  System.out.println(firstBook + "");
			  System.out.println(secondBook + "");
			  System.out.println(thirdBook + "");
			  System.out.println(forthBook + "");
		  case 5 :
			  System.out.println(firstBook + "");
			  System.out.println(secondBook + "");
			  System.out.println(thirdBook + "");
			  System.out.println(forthBook + "");
			  System.out.println(fifthBook + "");
	   }
	}
	
	public String getCheapestBook() {
		Book cheapest = firstBook;
		
		switch(registeredBooks) {
			case 2:
				cheapest = cheapest.getPrice() > secondBook.getPrice() ? secondBook : cheapest;
			case 3:
				cheapest = cheapest.getPrice() > secondBook.getPrice() ? secondBook : cheapest;
				cheapest = cheapest.getPrice() > thirdBook.getPrice() ? thirdBook : cheapest;
			case 4:
				cheapest = cheapest.getPrice() > secondBook.getPrice() ? secondBook : cheapest;
				cheapest = cheapest.getPrice() > thirdBook.getPrice() ? thirdBook : cheapest;
				cheapest = cheapest.getPrice() > forthBook.getPrice() ? forthBook : cheapest;
			case 5:
				cheapest = cheapest.getPrice() > secondBook.getPrice() ? secondBook : cheapest;
				cheapest = cheapest.getPrice() > thirdBook.getPrice() ? thirdBook : cheapest;
				cheapest = cheapest.getPrice() > forthBook.getPrice() ? forthBook : cheapest;
				cheapest = cheapest.getPrice() > fifthBook.getPrice() ? fifthBook : cheapest;
		}

	  return cheapest + "";
	}
}
