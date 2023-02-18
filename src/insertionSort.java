

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class insertionSort {

	public static void main(String[] args) throws FileNotFoundException {
		File myObject = new File("RO100000.txt"); // Reading inputs
        Scanner myReader = new Scanner(myObject);
		
        String array[] = new String[100000]; 
        int i = 0;
		while (myReader.hasNextLine()) {          // Storing inputs as strings in array
			array[i] = myReader.nextLine();
			i++;
		
		}
		
		
		int array1[] = new int[array.length];
		for (int k = 0;k <array.length;k++) {            // converting strings to integers and storing them. 
			array1[k] = Integer.parseInt(array[k]);
		
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter which smallest value you want to find in the list: ");
		
		int kvalue = input.nextInt();
		System.out.println("Value: "+ sort(array1,kvalue)); // returning the kth smallest element
		
	
		
	}
	
	
	public static int sort(int arr[],int k)   // Here is the sorting algorithm
    
	{
		// long count = 0;     // counting how many times basic operation executed
        
		int n = arr.length;
        
		for (int i = 1; i < n; ++i) {
            
			int key = arr[i];
            int j = i - 1;
            //count++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
               // count++;
               
            }
            arr[j + 1] = key;
            
           //System.out.print("numberOfComp:"); ->  counting number of comparisons.
           //System.out.println(count);---------->
        }
		
		
		return arr[k];
    }

	}

 // This code is contributed by Rajat Mishra. */ https://www.geeksforgeeks.org/insertion-sort/#:~:text=Insertion%20sort%20is%20a%20simple,Algorithm

