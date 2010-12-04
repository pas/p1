public class Rec {

	public static void main(String args[]) {
		for (int i = 1; i<=50; i++) {
			System.out.println(exp(i));
		}
		
		for (int i = 1; i<=50; i++) {
			System.out.println(rec(i));
		}
	}
	
	static long exp(int i) {
		long n=0;
		long nMinusTwo=0;
		long nMinusOne=1;
	
		if (i==1) {
			return 0;
		}
		if (i==2) {
			return 1;
		}
		
		while (i > 2) {
		  n = nMinusTwo+nMinusOne;
		  nMinusTwo = nMinusOne;
		  nMinusOne = n;
		  i--;
		}
		
		return n;
	}
	
	static long rec(int i) {
		if (i == 1) {
			return (0);
		}
		else if (i == 2) {
			return (1);
		}
		else {
			long m1 = rec(i-1);
			long m2 = rec(i-2);
			long result = m1 + m2;
			return (result);
		}
	}
}
