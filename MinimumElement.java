// Time Complexity : O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : finding the pattern took most of the time.

public class Main {

    public static void main(String[] args) {
	    int[] arr = {2,1};		// Test case
        System.out.println(findMin(arr));	// print statements
    }

    public static int findMin(int[] nums) {
        
        if (nums.length == 1) {		// if the array length is of 1, return the element
            return nums[0];
        }

        
        int left = 0;					// initializing the left and right pointers of the array
		int right = nums.length - 1;

       
        if (nums[right] > nums[0]) {	// if the right pointer is greater than the initial pointer, the array is sorted, first element is Minimum
            return nums[0];
        }

        
        while (right >= left) {			// binary search until the left index crosses over right - exit case
            
            int mid = left + (right - left) / 2;		// mid point calculation

            if (nums[mid] > nums[mid + 1]) {			// if mid is greater than next element, we find the pivot used to rotate the array, it's the minimum
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {			// if preceding element is greater the mid, then we are at the minimum value.
                return nums[mid];
            }
            if (nums[mid] > nums[left]) {				// if the minimum is not surrounded by the minimum element, compare both the ends and set the left and right index accordingly
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;		// if not found, return -1
    }
}
