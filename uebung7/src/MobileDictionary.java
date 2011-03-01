/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Excercice 7-1
* Last modified: 17.12.2010
* 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MobileDictionary {
	
	private HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
	private int ignored = 0;
	
	public void loadDictionary(String filename) throws FileNotFoundException {
    
		File dictFile = new File(filename);		
		Scanner file = new Scanner (dictFile);
		
		int count = 0;
		
		System.out.print("Loading dictionary");
		
		long fileSize = dictFile.length();
		long startFileSize = fileSize;
		
		while(file.hasNextLine()) {
			String line = file.nextLine();
			fileSize = fileSize - (line.getBytes().length + 1);
			int procent = (int) ((100*fileSize/startFileSize));
			procent = 100 - procent;
			
			String keyComb = getKeyCombination(line);
			if (keyComb == null) continue;

			List<String> list = hash.get(keyComb);
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(line);
			hash.put(keyComb, list);
			
			if (count % 10000 == 0) { System.out.print("\r" + procent + "%"); };
			count++;
		}
		System.out.println("\rSuccesfully loaded " + count + " words!\n" + "Ignored " + ignored + " words." );
    }
	
	public List<String> decode(String code) {
		return(hash.get(code));
	}
    
    private String getKeyCombination (String word) {
    	String combination = "";
    	for (int i = 0; i<word.length(); i++) {
    		char character = ' ';
    		try {
    			character = getKeyNumber(Character.toLowerCase(word.charAt(i)));
    		}
    		catch (Exception e) { ignored++; return null; }
    		combination += character;
    	}
    	return combination;
    }
    
	/** Given a character, returns a keycode between '1' and '9'.
	    Raises an exception if character is unknown. */
	private char getKeyNumber(char c) throws Exception{
		if(c=='a'||c=='ä'||c=='à'||c=='b'||c=='c'||c=='ç')	return '2';
		else if(c=='d'||c=='e'||c=='é'||c=='f')			return '3';
		else if(c=='g'||c=='h'||c=='i') return '4';
		else if(c=='j'||c=='k'||c=='l') return '5';
		else if(c=='m'||c=='n'||c=='o'||c=='ö') return '6';
		else if(c=='p'||c=='q'||c=='r'||c=='s')	return '7';
		else if(c=='t'||c=='u'||c=='ü'||c=='v') return '8';
		else if(c=='w'||c=='x'||c=='y'||c=='z') return '9';
		else if(c=='\''||c=='-')	return '1';
		else throw new Exception("unknown character: "+c);
	}

}
