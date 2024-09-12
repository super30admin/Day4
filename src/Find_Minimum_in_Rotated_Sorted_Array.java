// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* if mid is less than mid-1, then second half is sorted in ascending order and return mid as minimum
 * if mid is greater than next element, then second half is sorted in ascending order and return mid+1 as minimum */

class Find_Minimum_in_Rotated_Sorted_Array {

	public static int findMin(int[] nums) {
		if(nums == null || nums.length == 0)
			return -1;
		
		int low = 0;
        int high = nums.length -1;
        
        if(nums[high] > nums[0] || nums.length == 1)	//if length of array is 1, then return first element
          return nums[0];
        
        while(low <= high) {
        	int mid = low + (high - low) /2;
        	
        	if(nums[mid] < nums[mid-1])			// if mid is less than mid-1, then second half is sorted in ascending order and return mid as minimum
        		return nums[mid];
        	if(nums[mid] > nums[mid+1])			// if mid is greater than next element, then second half is sorted in ascending order and return mid+1 as minimum
        		return nums[mid+1];
        	if(nums[mid] > nums[high])			// if mid is greater than last element, then change the range and search in second half
        		low = mid +1;
        	else
        		high = mid -1;					// else change the range and search in first half
        }
		return -1;
	}
	
	
	public static void main(String[] args) {
			int nums[] = {3,4,5,1,2};
			int min = findMin(nums);
			System.out.println("Min is " +min);
		}
	}



/*---------------------------In the above approach had to include base case condition--------------------------------------------------------------------------------------------*/
class Solution {
    public int findMin(int[] nums) {
       
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid == nums.length-1 || nums[mid+1]>nums[mid]))
                return nums[mid];
            else if(nums[mid] < nums[high])
                high = mid -1;
            else
                low = mid +1;
        }
        return -1;  
    }
}
