package binarySearch2;

public class FindFirstAndLastPositionOfElementInSortedArray {
	// Time Complexity : O(log n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : Continuing to go left to find the leftmost index
	// and similarly, continuing to go right to find the rightmost index
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        result[0] = startingIndex(nums, target);
        result[1] = endingIndex(nums, target);
        
        return result;
    }
    
    private int startingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target <= nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
            
            if(target == nums[mid])
                index = mid;
        }
        
        return index;
    }
    
    private int endingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target >= nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
            
            if(target == nums[mid])
                index = mid;
        }
        
        return index;
    }
}
