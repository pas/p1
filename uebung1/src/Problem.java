/*
 *  
 *  Author: 		Judith Fuog / Pascal Zaugg
 *  Matrikelnr.:	?? / 05-299-425
 *  Aufgabe:		1-3b
 *  Program:		Problem.java
 *  
 */

public class Problem 
{
  public static double a = 17; /* 	final variable kann nicht verändert werden. Sollte int sein, da
  									später double benötigt. */
  
  public static void main(String[] args) /* Hier kommt kein ; */
  {
	  double b = 24; /* double, da sonst c/2 nicht funktioniert */
	  double c = 3.41;
	  System.out.println("a =" + a);
	  a = a + b; /* Cast zu int oder a als double definieren */
	  System.out.println("a = " + a);
	  b = c/2;
	  System.out.println("b = " + b);
  }
}
