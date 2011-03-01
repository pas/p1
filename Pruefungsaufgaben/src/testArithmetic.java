import java.util.ArrayList;

//Dürfen immer neue Methoden gemacht werden auch wenn nichts steht?

public class testArithmetic {
	  public static void main(String args[]) {
		    Arithmetic test2 = new Arithmetic(2000);
		    System.out.println(test2);
		  }	
}

class Arithmetic {
	private int number;
	private ArrayList<Integer> factors = new ArrayList<Integer>();
	
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
			
		int candidate = 2;
		int rest = number;
		   
		while (rest > 1) {
		  	if (rest%candidate == 0) {
		  		rest = rest/candidate;
		    	factors.add(candidate);
		    }
		  	else { candidate++; }
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
		for(Integer factor: factors) {
			string = string + "" + factor + " * ";
		}
		return(string.substring(0, (string.length()-3)));
	}
}
