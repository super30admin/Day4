// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int[] searchRange(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
					(mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {  // if mid is peak
				return mid;
			} else if (mid > 0 && nums[mid - 1] > nums[mid]) { // move to left
				high = mid - 1;
			} else { // move to right
				low = mid + 1;
			}
		}

		return -1;
	}
}