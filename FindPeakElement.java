package binarySearch2;

public class FindPeakElement {
	// Time Complexity : O(log n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : Continuing to go left if numbers are in descending
	// or right if ascending
	public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] > nums[mid - 1]))
                return mid;
            else if(nums[mid] > nums[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return low;
    }
}
