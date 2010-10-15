/*

*/

import java.text.DecimalFormat;
import java.util.Random;

public class RandomISBN{
	private String laendercode;
	private String bandnr;
	private String verlagsnr;
	private int checksum;

	/** Constructor */
	public RandomISBN(){
		makeNumber();
	}

	/** Returns the ISBN in its string representation XX-XXX-XX-C */
	public String toString(){
		return laendercode+"-"+bandnr+"-"+verlagsnr+"-"+checksum;
	}

	/** generates the ISBN using random numbers */
	private void makeNumber(){

	int laendercodeInt;
	int bandnummerInt;
	int verlagsnummerInt;

      	Random generator = new Random();
        DecimalFormat fmt = new DecimalFormat ("00");

		/** Ländercode zwischen 01 und 99 */
		laendercodeInt = generator.nextInt(99) + 1;
		laendercode = fmt.format(laendercodeInt);

		/** Bandnummer grösser 99 */
		bandnummerInt = generator.nextInt(900) + 100;
		bandnr = Integer.toString(bandnummerInt);

		/** Verlagsnummer > 0 */
		verlagsnummerInt = generator.nextInt(99) + 1;
		verlagsnr = fmt.format(verlagsnummerInt);

		/** Checksumme */
	    int l1, l2, b1, b2, b3, v1, v2;
	    
		l1 = hashOp(Integer.parseInt(laendercode.substring (0, 1)));
		l2 = Integer.parseInt(laendercode.substring (1, 2));
		b1 = hashOp(Integer.parseInt(bandnr.substring(0, 1)));
		b2 = Integer.parseInt(bandnr.substring(1, 2));
		b3 = hashOp(Integer.parseInt(bandnr.substring(2, 3)));
		v1 = Integer.parseInt(verlagsnr.substring(0, 1));
		v2 = hashOp(Integer.parseInt(verlagsnr.substring(1, 2)));
	
		checksum = (l1 + l2 + b1 + b2 + b3 + v1 + v2) % 10;
		
	}

	/** multiplies i with 2 and subtracts 9 if result is >= 10 */
	private int hashOp(int i){
		int doubled = 2 * i;
		if (doubled >= 10){
			doubled = doubled - 9;
		}
		return doubled;
	}
}
