/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Last modified: 17.10.2010
* 
*/


import java.text.DecimalFormat;
import java.util.Random;

public class RandomISBN_advanced {

		private String laendercode;
		private String bandnr;
		private String verlagsnr;
		private int checksum;

		/** Constructor */
		public RandomISBN_advanced(){
			makeNumber();
		}

		/** Returns the ISBN in its string representation XX-XXX-XX-C */
		public String toString(){
			return laendercode+"-"+bandnr+"-"+verlagsnr+"-"+checksum;
		}

		/** generates the ISBN using random numbers */
		private void makeNumber(){

	      	Random generator = new Random();
	        DecimalFormat fmt = new DecimalFormat ("00");

			/** Ländercode zwischen 01 und 99 */
			laendercode = fmt.format(generator.nextInt(99) + 1);

			/** Bandnummer grösser 99 */
			bandnr = Integer.toString(generator.nextInt(900) + 100);
			
			/** Verlagsnummer > 0 */
			verlagsnr = fmt.format(generator.nextInt(99) + 1);

			/** Checksumme */
			
			/** Die Zahlen bestehend aus Ländercode, Bandnummer und Verlagsnummer
			 *  werden zu einer zusammengefügt. (z.B. für 28, 245, 290 wäre es 28245290) 
			 *  und danach in Einzelstücke (char) zerlegt und im Array char[] gespeichert. 
			 *  Danach wird die for-Schlaufe 7-mal durchlaufen. Die chars im Array werden 
			 *  zu Integer umgewandelt (jede zweite Zahl wird dabei mit der Methode hashOp 
			 *  bearbeitet) und anschliessend zu checksumme dazugezählt. 
			 */
			
		    String pampe = laendercode + bandnr + verlagsnr;
		    char[] einzelteile = pampe.toCharArray();
		    for(int i=0; i<7; i++) {
		      int einzelnummer = Integer.parseInt(einzelteile[i] + "");
		      if (i%2 == 0) { 
		    	  einzelnummer = hashOp(einzelnummer);
		      }
		      checksum += einzelnummer;
		    }
		
			checksum = checksum % 10;
			
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

