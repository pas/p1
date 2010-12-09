/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Excercise: 6-1
* Last modified: 09.12.2010
* 
*/


public class MergeSort {
	public static void sort (Comparable[] array) {
		Comparable[] array_new = new Comparable[array.length];
		array_new = mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			array[i] = array_new[i];
		}
	}
	private static Comparable[] mergeSort (Comparable[] array) {
		if (array.length == 1) {
			return array;
		}
		else {
			Comparable[] arrayFirstHalf = new Comparable[array.length/2];
			Comparable[] arraySecondHalf = new Comparable[array.length-array.length/2];
			
			for (int i = 0; i<array.length/2; i++) {
					arrayFirstHalf[i] = array[i];
			}
			for (int i = array.length/2; i<array.length; i++) {
				arraySecondHalf[i-array.length/2] = array[i];
			}
			
			arrayFirstHalf = mergeSort(arrayFirstHalf);
			arraySecondHalf = mergeSort(arraySecondHalf);
						
			return merge(arrayFirstHalf, arraySecondHalf);
		}
	}
	private static Comparable[] merge (Comparable[] array1, Comparable[] array2) {
		Comparable[] array = new Comparable[array1.length+array2.length];

		int a2Count = 0;
		int aCount = 0;
		int a1Count = 0;
		while (a1Count<array1.length) {

			if (a2Count < array2.length && array1[a1Count].compareTo(array2[a2Count]) > 0) {
				array[aCount] = array2[a2Count];
				aCount++;
				a2Count++;
			}
			else {
				array[aCount] = array1[a1Count];
				aCount++;
				a1Count++;
			}				
		}
		for (;a2Count<array2.length;a2Count++) {
			array[aCount] = array2[a2Count];
			aCount++;
		}
		
		return array;
	}
}
