package binarySearch2;

public class FindMinimumInARotatedSortedArray {
	// Time Complexity : O(log n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int idx = findMin(nums, 0, nums.length - 1);
        
        return nums[idx];
    }
    
    private int findMin(int[] nums, int left, int right) {
        if(nums[left] < nums[right])
            return 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid + 1] < nums[mid])
                return mid + 1;
            else if(nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return 0;
    }
}
