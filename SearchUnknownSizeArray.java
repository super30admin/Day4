/*
    Leetcode Problem 702: Search in a sorted array of unknown size
    T.C: O(log(n)) :: S.C: O(1)
    
    Solved using B.S technique -
    First find if the target element falls within the range of low and high pointers
    i.e set low and high to indices 0, 1 respectively and increment high * 2 until 
    target is less than reader.get(high) after this perfrom B.S to find the target index.
*/

import java.util.Random;

// ArrayReader Interface
interface ArrayReader {
    int get(int index);
}

// ArrayReader Implementation
class ArrayReaderImpl implements ArrayReader {
    private int[] array;

    public ArrayReaderImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        if (index >= array.length) {
            return Integer.MAX_VALUE; // Return MAX_VALUE for out-of-bounds indices
        }
        return array[index];
    }
}

public class SearchUnknownSizeArray {
    //Instance Variable
    private int[] secretArray;
    //Constructor
    public SearchUnknownSizeArray(int n) {
        this.secretArray = new int[n];
        Random random = new Random();
        
        int current = random.nextInt(10);
        for (int i = 0; i < n; i++) {
            if (current > Integer.MAX_VALUE) {
                //Fill rest of the array with Integer.MAX_VALUE
                for (int j = i; j < n; j++) {
                    secretArray[j] = Integer.MAX_VALUE;
                }
                break;
            }
            secretArray[i] = current;
            current += random.nextInt(10) + 1;
        }
    }
    
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == Integer.MAX_VALUE || reader.get(1) == Integer.MAX_VALUE) return -1;
        
        int low = 0;
        int high = 1;
        
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        
        return binarySearch(reader, low, high, target);
    }
    
    public int binarySearch(ArrayReader reader, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int size = 100;
        
        SearchUnknownSizeArray obj = new SearchUnknownSizeArray(size);
        
        // Display the first 20 elements for brevity
        System.out.println("First 20 elements:");
        for (int i = 0; i < 20; i++) {
            System.out.print(obj.secretArray[i] + " ");
        }
        System.out.println("\n...");
        
        // Create the ArrayReader
        ArrayReader reader = new ArrayReaderImpl(obj.secretArray);

        // Search for a target value
        int target = 16;
        int result = obj.search(reader, target);

        // Print the result
        if (result != -1) {
            System.out.println("The target element is at index " + result + " in the secret array of unknown size.");
        } else {
            System.out.println("The target element " + target + " is not found.");
        }
        
    }
}