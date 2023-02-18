

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class partialSelectionSort  {
	//static long count = 0; 
	public static void main(String[] args) throws FileNotFoundException {
		
		File myObject = new File("RO100000.txt");   // Reading inputs
        Scanner myReader = new Scanner(myObject);
		
        String array[] = new String[100000];
		int i = 0;
		while (myReader.hasNextLine()) {          // Storing inputs as strings in array
			array[i] = myReader.nextLine();
			i++;
		}
		
		int array1[] = new int[array.length];
		for (int k = 0;k <array.length;k++) {          // converting strings to integers and storing them.
			array1[k] = Integer.parseInt(array[k]);
			
		}
	
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter which smallest value you want to find in the list: ");
		
		int kvalue = input.nextInt();
		System.out.println("Value: "+ partialSelectionSort(array1,kvalue)); // returning the kth smallest element
		
		
		
		
		
		
	
 
	}
	
	public static int partialSelectionSort(int array[],int k ) {
		
	    int size = array.length;

	    for (int step = 0; step < k; step++) {     // Modified: We are sorting until k!
	      int min_idx = step;

	      for (int i = step + 1; i < size; i++) {
	    	  // count++;
	        if (array[i] < array[min_idx]) {
	        	
	       
	          min_idx = i;
	        }
	      }

	      int temp = array[step];
	      array[step] = array[min_idx];
	      array[min_idx] = temp;
	    }
	    
	    return array[k-1];
	    
	  }
	
}


// code taken : https://www.programiz.com/dsa/selection-sort
	   


	

	


