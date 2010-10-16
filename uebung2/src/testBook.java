import java.text.*;

public class testBook {

	public static void main (String[] args) throws ParseException {

		Book test = new Book(1001, "der Antichrist", "Friedrich Nietsche", "01.01.1895");
		Book test2 = new Book(1002, "Kritik der praktischen Vernunft", "Immanuel Kant", "01.01.1788");

		System.out.println("Testing first book");
		System.out.println("------------------");
		test(42291, test.age());
		test("Friedrich Nietsche", test.getAuthor());
		test("der Antichrist", test.getTitle());
		test(1001, test.getId());
		test("01.01.1895", test.getDate());
		
		test2.setAuthor("Georg Büchner");
		test2.setId(1003);
		test2.setTitle("Leonce und Lena");
		test2.setDate("01.01.1879");
	
		System.out.println("");
		System.out.println("Testing second book after using set-methods");
		System.out.println("------------------");
		test(48135, test2.age());
		test("Georg Büchner", test2.getAuthor());
		test("Leonce und Lena", test2.getTitle());
		test(1003, test2.getId());
		test("01.01.1879", test2.getDate());
		
		System.out.println("");
		System.out.println("Testing input()");
		System.out.println("------------------");
		test.input();

		System.out.println("");
		System.out.println("Print all input");
		System.out.println("------------------");
		System.out.println("Alter: " + test.age() + " Tage");
		System.out.println("Autor: " + test.getAuthor());
		System.out.println("Titel: " + test.getTitle());
		System.out.println("ID: " + test.getId());
		System.out.println(test.getDate());
	
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