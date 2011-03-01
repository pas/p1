/* 
 * Folgender Output wird generiert:
 * 
 * 33
 * 50
 * 100
 * 0-Divide
 * Done
*/

public class Exceptions { 
	Exceptions () {
/**/
	}
	
	public void testMich () {
		try { 
			for (int n= 3; n>= -3; n--) {
				System.out.println(100/n);
			}
		}
		catch (ArithmeticException e) {
			System.out.println("0-Divide");
			
		}
		finally {
			System.out.println("Done");
		}
		return;
	}
	
	public static void main(String[] args) {
		Exceptions test = new Exceptions();
		test.testMich();
	}

}
