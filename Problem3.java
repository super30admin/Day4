// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
	public int findPeakElement(int[] nums) {
	    
		int low = 0, high = nums.length - 1;
		
        if(low > high) return -1;
		return binarySearch(nums, low, high);
    }
	
	private int binarySearch(int[] nums, int low, int high) {
		
		int mid = low + (high - low)/2;
		
        if(mid < high && nums[mid] < nums[mid+1]){
            low = mid + 1;
            return binarySearch(nums, low, high);
        } else if(mid > low && nums[mid] < nums[mid-1]){
            high = mid - 1;
            return binarySearch(nums, low, high);
        } else {
            return mid;
        }
	}
}
