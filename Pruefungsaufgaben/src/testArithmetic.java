import java.util.ArrayList;

public class testArithmetic {
	  public static void main(String args[]) {
		    Arithmetic test2 = new Arithmetic(2000);
		    System.out.println(test2);
		  }	
}

class Arithmetic {
	private int number;
	private ArrayList factors = new ArrayList();
	
	public Arithmetic(int i) {
		number = i;
		
		if (i == 1 || i == 0) {
			factors.add(i);
		}
		else {
			split();
		}
	}
	
	private void split() {
		
		int number = this.number;
		
		if (this.number < 0) {
			factors.add(-1);
			number = number*-1;
		}
			
		while (number != 1) {
			int factor = findFactor(number);
			factors.add(factor);
			number = number/factor;
		}
	}
	
	private int findFactor(int number) {
		for (int i = 2; i<number; i++) {
			if (number%i == 0) {
				return(i);
			}
		}
		return number;
	}
	
	public String toString() {
		String string = number+": ";
		for(Object factor: factors) {
			string = string + "" + factor + " * ";
		}
		return(string.substring(0, (string.length()-3)));
	}
}
