/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Excercice 6-2a + 6-2c
* Last modified: 09.12.2010
* 
*/

public class Rec {
	
	public static void main(String args[]) {
		for (int i = 1; i<=10; i++) {
			System.out.println(exp(i));
		}
		
		int times = 8;
		System.out.println(rec(times));
		System.out.println("RecCount: " + (recCount));
		double formel = Math.pow(2, (times-1)-2)+2*((times-1)-2);
		System.out.println("Formel: " + formel);
	}
	
	static long exp(int i) {
		long n=0;
		long nMinusTwo=0;
		long nMinusOne=1;
	
		if (i==1  || i==2) {
			return (i-1);
		}
		
		while (i > 2) {
		  n = nMinusTwo+nMinusOne;
		  nMinusTwo = nMinusOne;
		  nMinusOne = n;
		  i--;
		}
		
		return n;
	}
		
	static int recCount;
	
	static long rec(int i) {
		if (i == 1) {
			return (0);
		}
		else if (i == 2) {
			return (1);
		}
		else {
			recCount = recCount+2;
			long m1 = rec(i-1);
			long m2 = rec(i-2);
			long result = m1 + m2;
			return (result);
		}
	}
}
