public class BookStore {

	private Book firstBook = new Book();
	private Book secondBook = new Book();
	private Book thirdBook = new Book();
	private Book forthBook = new Book();
	private Book fifthBook = new Book();
	
	public BookStore() {
	}
	
	public void registerBooks() throws java.text.ParseException {
	  for (int i = 0 ; i<5; i++) {
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
		  System.out.print("Do you want to register another book (y/n)? ");
	      java.util.Scanner scn = new java.util.Scanner(System.in);
		  if (scn.nextLine().equals("n")) {
	        break;
	      }
	    }
	  
	}
	
	public void listBooks() {
	  if (! firstBook.isEmpty())
		  System.out.println(firstBook + "");
	  if (! secondBook.isEmpty())
		  System.out.println(secondBook + "");
	  if (! thirdBook.isEmpty())
		  System.out.println(thirdBook + "");
	  if (! forthBook.isEmpty())
		  System.out.println(forthBook + "");
	  if (! fifthBook.isEmpty())
		  System.out.println(fifthBook + "");
	}
	
	public String getCheapestBook() {
		Book cheapest = firstBook;
		
		  if (! secondBook.isEmpty())
			  cheapest = cheapest.getPrice() > secondBook.getPrice() ? secondBook : cheapest;
		  if (! thirdBook.isEmpty())
			  cheapest = cheapest.getPrice() > thirdBook.getPrice() ? thirdBook : cheapest;
		  if (! forthBook.isEmpty())
			  cheapest = cheapest.getPrice() > forthBook.getPrice() ? forthBook : cheapest;
		  if (! fifthBook.isEmpty())
			  cheapest = cheapest.getPrice() > fifthBook.getPrice() ? fifthBook : cheapest;
	  return cheapest + "";
	}
}
