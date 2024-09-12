// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution {
	
	public int[] searchRange(int[] nums, int target) {
		
		int low = 0, high = nums.length - 1;
		
		int start = binarySearchLeft(nums, low, high, target);
		int end = binarySearchRight(nums, low, high, target);
		return new int[] {start, end};
		
	}
	
	private int binarySearchLeft(int[] nums, int low, int high, int target) {
		
		if(low > high) {
			return -1;
		}
		int mid = low + (high - low)/2;
		
		if(mid > low && target <= nums[mid-1]) {
			high = mid - 1;
			return binarySearchLeft(nums, low, high, target);
		} else if(target == nums[mid]) {
			return mid;
		} else if(mid < high && target >= nums[mid + 1]) {
			low = mid + 1;
			return binarySearchLeft(nums, low, high, target);
		} else {
			return -1;
		}	
	}
	
	private int binarySearchRight(int[] nums, int low, int high, int target) {
		
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high - low)/2;
		
		
		if(mid < high && target >= nums[mid + 1]) {
			low = mid + 1;
			return binarySearchRight(nums, low, high, target);
		} else if(target == nums[mid]) {
			return mid;
		} else if(mid > low && target <= nums[mid-1]) {
			high = mid - 1;
			return binarySearchRight(nums, low, high, target);
		} else {
			return -1;
		}
	}
}
