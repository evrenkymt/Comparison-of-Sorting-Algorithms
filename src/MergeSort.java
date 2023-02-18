import java.io.*;
import java.util.Scanner;
/* Java program for Merge Sort */
public class MergeSort
{
	
	static int count = 0;	//this variable counts the # of comparison in merge sort.
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			count +=1;
			if (L[i] <= R[j]) {
				
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	int sort(int arr[], int l, int r,int k)
	{
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;
			

			// Sort first and second halves
			sort(arr, l, m,k);
			sort(arr, m + 1, r,k);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
		return arr[k];
	}

	

	// Driver code
	public static void main(String args[]) throws IOException
    {
		
		//Reading input txt codes are below.
    	FileReader fReader = new FileReader("repeatedOrder100k.txt");
    	String line;
    	int index = 0;
    	int[] sayilar2 = new int[100000];
    	BufferedReader bReader = new BufferedReader(fReader);
    	while((line =bReader.readLine()) != null) {
    		//System.out.println(line);
    		sayilar2[index] = Integer.parseInt(line);
    		index +=1;
    		
    	}
    	bReader.close();
    	Scanner input = new Scanner(System.in);
		System.out.println("Please enter which smallest value you want to find in the list: ");
		
		int kvalue = input.nextInt();
		//Merg sorting  the array.
    	MergeSort ob = new MergeSort();
    	System.out.println(ob.sort(sayilar2, 0, sayilar2.length-1,kvalue));
    	System.out.println("Number Of comparisons : " + count);
    	
    }
	
}
/* This code is contributed by Rajat Mishra */
//	https://www.geeksforgeeks.org/merge-sort/
