/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Last modified: 17.10.2010
* 
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testBook {

	public static void main (String[] args) throws ParseException {

		Book test = new Book(1001, "der Antichrist", "Friedrich Nietzsche", "01.01.1895");

		System.out.println("Testing first book-object");
		System.out.println("------------------");
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
		
		long differenceInDays 
		= (  (new Date()).getTime() - (fmt.parse("01.01.1895")).getTime() ) /1000/60/60/24; 
		
		test( (int) differenceInDays, test.age());
		test("Friedrich Nietzsche", test.getAuthor());
		test("der Antichrist",test.getTitle());
		test(1001, test.getId());
		test("01.01.1895", test.getDate());
		test("1001, der Antichrist, Friedrich Nietzsche, 01.01.1895", test + "");
		
		test.setAuthor("Georg Büchner");
		test.setId(1003);
		test.setTitle("Leonce und Lena");
		test.setDate("01.01.1879");
	
		System.out.println("");
		System.out.println("Testing first book-object after using set-methods");
		System.out.println("------------------");
		
		differenceInDays 
		= (  (new Date()).getTime() - (fmt.parse("01.01.1879")).getTime() ) /1000/60/60/24; 
		
		test((int) differenceInDays, test.age());
		test("Georg Büchner", test.getAuthor());
		test("Leonce und Lena", test.getTitle());
		test(1003, test.getId());
		test("01.01.1879", test.getDate());
		
		System.out.println("");
		System.out.println("Testing input()");
		System.out.println("------------------");
		
		Book test2 = new Book();

		System.out.println("");
		System.out.println("Print all input");
		System.out.println("------------------");
		System.out.println("Alter: " + test2.age() + " Tage");
		System.out.println("Autor: " + test2.getAuthor());
		System.out.println("Titel: " + test2.getTitle());
		System.out.println("ID: " + test2.getId());
		System.out.println(test2.getDate());
	
	}
	

	private static void test (int should, int is) {
		if (should == is) {
			System.out.println("OK");
		}
		else { 
			System.out.println("Not OK!");
			System.out.println("Should: " + should);
			System.out.println("Is: " + is);
		}
	}

	private static void test (String should, String is) {
		if (should.compareTo(is) == 0) {
			System.out.println("OK");
		}
		else { 
			System.out.println("Not OK!");
			System.out.println("Should: " + should);
			System.out.println("Is: " + is);
		}
	}
	
}