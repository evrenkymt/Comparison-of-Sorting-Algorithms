

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quickselect {
	
static int count = 0; // Calculating basic operation number

	public static void main(String[] args) throws FileNotFoundException {
		
		File myObject = new File("RO100000.txt");
        Scanner myReader = new Scanner(myObject);  // Reading inputs
		
        String array[] = new String[100000];
		int i = 0;  
		while (myReader.hasNextLine()) {           // Storing inputs as strings in array
			array[i] = myReader.nextLine();
			i++;
			
		}
		
		int array1[] = new int[array.length];
		for (int k = 0;k <array.length;k++) {
			array1[k] = Integer.parseInt(array[k]);        // converting strings to integers and storing them. 
			
		}
		
		
		

	

		
		
	 
/*   Calculating the kthSamllest 100 
     time due to realiability.
*/
	 long startTime = System.nanoTime();
	 long endTime = System.nanoTime();
	 
	 int totalSecond = 0;
	 for ( int a = 0; a< 2;a++) {
    	 
		 
		 startTime = 0;
		 endTime = 0;
		 startTime = System.nanoTime();
         kthSmallest(array1,0,99999,25000);                        
    	 endTime = System.nanoTime();
    	 //System.out.print("iteration" + a+  " -> ");
    	 long time = endTime-startTime;
    	//  System.out.println(time);
    	 totalSecond += time;
     }
	 
	 //System.out.println("Total second: " + totalSecond);
	// System.out.println("Avarage: " + totalSecond /2);
    
	 
	 Scanner input = new Scanner(System.in);
		System.out.println("Please enter which smallest value you want to find in the list: ");
		
		int kvalue = input.nextInt();
		System.out.println("Value: "+ kthSmallest(array1,0,99999,kvalue)); // returning the kth smallest element

	}
	
	
	
	public static int partition(int[] arr, int low,
            int high)
    {
		

        int pivot = arr[high], pivotloc = low;
       for (int i = low; i <= high; i++) {

	
	    count++;
        if (arr[i] < pivot) {
	

      int temp = arr[i];
     arr[i] = arr[pivotloc];
       arr[pivotloc] = temp;
       pivotloc++;

        }
}


        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

     return pivotloc;
}

           public static int kthSmallest(int[] arr, int low,
              int high, int k)
            {

	
	
                int partition = partition(arr, low, high);
 

              if (partition == k - 1)
               return arr[partition];

                 else if (partition < k - 1)
                  return kthSmallest(arr, partition + 1, high, k);


                  else
                   return kthSmallest(arr, low, partition - 1, k);
 }


}

// This code is contributed by Saiteja Pamulapati  https://www.geeksforgeeks.org/quickselect-algorithm/

