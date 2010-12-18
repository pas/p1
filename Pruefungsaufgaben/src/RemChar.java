public class RemChar {

	public static void main (String args[]) {
		System.out.println(removeChar("Programmieren", 'r'));
	}
	
	public static String removeChar(String s, char chr) {
		char[] characters = s.toCharArray();
		String newString = "";
		
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] != chr) {
				newString = newString + characters[i];
			}
		}
		return (newString);
	}
}
