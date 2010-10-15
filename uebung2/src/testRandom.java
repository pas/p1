
public class testRandom {

	public static void main (String[] args) {

	  for(int i=0; i<3; i++) {
		  RandomISBN test = new RandomISBN();
		  System.out.println(test.toString());
	  } 
System.out.println("\nZweite Version:");	  
	  for(int i=0; i<3; i++) {
		  RandomISBN_advanced test = new RandomISBN_advanced();
		  System.out.println(test.toString());
	  }
	}
	
}
