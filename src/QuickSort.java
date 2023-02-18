import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort{
	static int count = 0; 					//This variable counts the # of comparison
    public int partition(int[] a, int left, int right) {
    	
        int pivot = a[left];				//We select the most left index as a pivot
        while(left<=right) {				//This loop continues until left <= right. If left
        	count +=1;						//bigger than right, that means our pivot value should
            								//locate between left and right index.
        	
        									//The aim is locate the pivot value to the right place.
        									//Right place means , the left of pivot value is always smaller,
        									//the right of pivot value is always bigger than pivot value.
        	
        	while(a[left] < pivot) {		//This while loop compares left part.
            	count +=1;				
                left++;						
            }
            while(a[right] > pivot) {		//This while loop compares right part
                count +=1;
            	right--;
            }
            if(left<=right) {				//When left and right part indexes equal, switch 
            	count +=1;					//the values between parts.
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
        }
        return left;						//this return left ensures that we again start from left most index.
    }
    public int recursiveQuickSort(int[] a, int i, int j,int k) {
       int idx = partition(a, i, j);
       if(i < idx-1) {						//This if statement ensures we sort left part of pivot value.
    	   
           recursiveQuickSort(a, i, idx-1,k);
        }
       if(j > idx) {						//This if statement ensures we sort right part of pivot value.
    	   
           recursiveQuickSort(a, idx, j,k);
        }
       return a[k];
    }

    
    public static void main(String[] args) throws NumberFormatException, IOException,StackOverflowError {
    
    	//Reading input.txt codes are below.
    	FileReader fReader = new FileReader("RO10000.txt");
    	String line;
    	int index = 0;
    	int[] sayilar2 = new int[10000];
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
        QuickSort ob = new QuickSort();
        System.out.println(ob.recursiveQuickSort(sayilar2, 0,sayilar2.length-1,kvalue));
        System.out.println("Number of comparisons : " + count);
    }
}
// The code link : https://stackoverflow.com/questions/6740183/quicksort-with-first-element-as-pivot-example