/* 
 * 1.Fehler: Arrays fangen immer bei Index 0 an. i muss 
 * also die Länge des Arrays minus 1 speichern.
 * 
 * 2.Fehler: Die while-Schlaufe erreicht nie null wenn 
 * die Anzahl der Zahlen im Array gerade ist. Somit
 * kommt es zu einem Fehler wegen einem negativen
 * Arrayindex.
 * 
 * Dazu sind je nach Intention zwei Lösungen möglich.
 * 
 */

//Müssen beide Lösungen gezeigt werden oder reicht eine?

public class Aufgabe2 {
	public static void main(String args[]) {
	    a2_1();
	    a2_2();
	}
	
	public static void a2_1() {
	  System.out.println("Lösung 1:");
	  int[] numbers = {1,2,3,7,9,11};
	  int i = numbers.length-1;
	  while(i != 0) {
		  System.out.println(numbers[i] + numbers[i-1]);
		  i = i-1;
	  }
	}
	
	public static void a2_2() {
		  System.out.println("Lösung 2:");
		  int[] numbers = {1,2,3,7,9,11};
		  int i = numbers.length-1;
		  while(i >= 1) {
			  System.out.println(numbers[i] + numbers[i-1]);
			  i = i-2;
		  }
	}
}
