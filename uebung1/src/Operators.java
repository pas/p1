/*
 *  
 *  Author: 		Judith Fuog / Pascal Zaugg
 *  Matrikelnr.:	?? / 05-299-425
 *  Aufgabe:		1-3c
 *  Program:		Operators.java
 *  
 */

public class Operators {

	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		int c = 7;
		int d = 10;
		int e = 20;

		/* Zuerst Multiplikation, dann Addition und danach Subtraktion.
		 * da Add. und Sub. gleichwertig, kommt es zu einer Auswertung
		 * von links nach rechts.
		 */
		double result = a + b * c + d * e;
		double check = ((a + (b * c)) + (d * e)); 
		test(result, check);
		
		/* Zuerst Modulo, dann Addition und danach Subtraktion.
		 * Da Add. und Sub. gleichwertig, kommt es zu einer Auswertung
		 * von links nach rechts.
		 */		
		result = a + b % c - d;
		check = (a + (b % c)) - d;
		test(result, check);
		
		/* Zuerst 1.Add., dann Sub. und danach 2.Add.. Da
		 * Add. und Sub. gleichwertig, kommt es zu einer
		 * Auswertung von links nach rechts
		 */		
		result = a + b - c + d;
		check = ((a + b) - c) + d;
		test(result, check);
		
		/* Zuerst Mult., dann Div. und danach Add. Da Mult.
		 * und Div. gleichwertig, kommt es zu einer Auswertung
		 * von links nach rechts.
		 */		
		result = a + b * c / d;
		check = a + ((b * c) / d);
		test(result, check);
   }
	
	public static void test(double result, double check) {		
		if ( result == check) { 
			 System.out.println("Korrekt! " + result + " gleich " + check);
		}
		else {
		  System.out.println("Die Klammerung stimmt nicht! " + result + " ungleich " + check);
		}		
	}

}
