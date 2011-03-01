/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Last modified: 17.10.2010
* 
*/

public class testRandom {

	public static void main (String[] args) {

System.out.println("Erste Version:");
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
