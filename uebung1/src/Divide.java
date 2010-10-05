/*
 *  
 *  Author: 		Judith Fuog und Pascal Zaugg
 *  Matrikelnr.:	?? / 05-299-425
 *  Aufgabe:		1-2
 *  Program:		Divide.java
 *  
 */

import java.util.Scanner;

public class Divide {

	public static void main (String[] args) {
      System.out.println("Dieses Programm berechnet den Quotienten von a(hoch2) / b. Dazu müssen Sie zwei natürliche Zahlen eingeben.");
      int a[] = new int[2];
	  int count = 0;
	  Scanner scan = new Scanner(System.in);
	  Exception div0 = new Exception("Division by zero.");
	  
	  while (count < 2) {
	    System.out.println("Eine natürliche Zahl bitte: ");
	    try { 
	    	  a[count] = Integer.parseInt(scan.nextLine()); 
	    	  if (count == 1 && a[count] == 0) { throw div0; };
	    	  count++;
	    }
	    catch (Exception e) { 
	    	System.out.println("Keine natürliche Zahl eingegeben oder die zweite Zahl war 0: " + e); 
	    }
	  }
	  
	  System.out.println("Sie haben die Zahlen " + a[0] + " und " + a[1] + " eingegeben.");
	  System.out.println("Das Resultat aus " + a[0] + "*" + a[0] + "/" + a[1] + " wird berechnet.");
	  a[0] = (int) Math.pow(a[0], 2); /* oder a[0]*a[0] */
	  System.out.println((double) a[0]/a[1]);
	  System.out.println(a[0]/a[1] + " Rest " + a[0]%a[1]);
	}
}