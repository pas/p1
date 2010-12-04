
public class Factorial {

	public static void main(String[] args) {
		long fac = factorial(Integer.parseInt(args[0]));
		System.out.println(fac);
	}
	
	public static long factorial (int n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}
	
}
