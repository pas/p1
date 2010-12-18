public class Reverse {
	public static void main(String args[]) {
		    String s = reverse("Programmieren");
		    System.out.println(s);
	}	

	public static String reverse (String s) {
		String result;
		if (s.length() <= 1) {
			result = s;
		}
		else  {
			result = s.substring(s.length()-1, s.length()) + reverse(s.substring(0, s.length()-1));
		}
		return result;
	}
}
