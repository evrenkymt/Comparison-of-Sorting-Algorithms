

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class partialHeapSort {



static int cs1; // counting how many times basic operation executed



	public static void main(String[] args) throws FileNotFoundException {
			
			File myObject = new File("RO100000.txt");    
	        Scanner myReader = new Scanner(myObject);         // Reading inputs  
			
	        String array[] = new String[100000];
	        int i = 0;
	        while (myReader.hasNextLine()) {
				array[i] = myReader.nextLine();      // Storing inputs as strings in array
				i++;
			}
			
	        
	        int array1[] = new int[array.length];
			for (int k = 0;k <array.length;k++) {
				array1[k] = Integer.parseInt(array[k]);   // converting strings to integers and storing them.
				
			}
		    
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter which smallest value you want to find in the list: ");
			
			int kvalue = input.nextInt();
			System.out.println("Value: "+ partialHeapSort(array1,100000,kvalue)); // returning the kth smallest element
	}
	
	public static int heapify(int arr[], int n, int i)
	{
        int count = 0;
        int smallest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2; 
 
        // If left child is smaller than root
        if (l < n && arr[l] < arr[smallest])
         
            smallest = l;
 
        // If right child is smaller than smallest so far
        if (r < n && arr[r] < arr[smallest])
          
            smallest = r;
 
        // If smallest is not root
        if (smallest != i) {
  
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
 
            // Recursively heapify the affected sub-tree
            count = heapify(arr, n, smallest);

        }
        
        return count+2;
    }
 
  
    static int partialHeapSort(int arr[], int n,int k)
    {
         
        for (int i = n / 2 - 1; i >= 0; i--) {
        	cs1 += heapify(arr, n, i);
        
        }
 
        for (int i = n-1 ; i >= n-k; i--) {
    
          
           
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
         
 
           
           cs1 += heapify(arr, i, 0);
        }
        
        return arr[n-k];
    }
}

//  This code is contributed by vt_m. https://www.geeksforgeeks.org/heap-sort-for-decreasing-order-using-min-heap/
