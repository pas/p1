public class RemChar {

	public static void main (String args[]) {
		System.out.println(removeChar("Pogammieen", 'r'));
	}
	
	public static String removeChar(String s, char chr) {
		String[] characters = s.split(chr+"");
		String newString = "";
		
		for (int i = 0; i < characters.length; i++) {
			newString = newString + characters[i];
		}
		return (newString);
	}
}
