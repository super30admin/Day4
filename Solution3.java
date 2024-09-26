// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/*
 * 162. Find Peak Element
 * 
 * 
 * still working on this
 * Pseudocode: 
 * idea is just use basic binary search to find the 
 * peak.
 * 
 * work still pending: 
 * 
 * 
 * */

public class Solution3 {

	public static int findPeakElement(int[] nums) {
		
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (nums[mid] > nums[mid+ 1]) { 
				high = mid -1;
			}
            else if (nums[mid] < nums[mid+ 1]){ 
            	low = mid + 1;
            }
            }
        
        return low;

}
	
	public static void main(String[] args) {

		int[] arr = {7,8,9,1,2,3,4,5};
		System.out.println("the returned first occurence val is " + findPeakElement(arr));
	}
	

}







