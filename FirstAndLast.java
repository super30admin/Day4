// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach
class Solution {
	public int[] searchRange(int[] nums, int target) {
		 
		 if (nums == null || nums.length == 0) return new int[] {-1, -1};
		 
		 int n = nums.length;
		 
		 int low = 0;
		 int high = nums.length - 1;
		 int resLow = -1, resHigh = -1;
		 
		 while(low <= high) {
			  int mid = low + (high - low) / 2;
			  if (nums[mid] == target) {
					if (mid != 0 && nums[mid - 1] == target) {
						 high = mid - 1;
					} else {
						 resLow = mid;
						 break;
					}
			  } else if (nums[mid] > target) {
					high = mid - 1;
			  } else {
					low = mid + 1;
			  }
		 }
		 
		 if (resLow == -1) return new int[] {-1, -1};
		 
		 low = resLow;
		 
		 high = nums.length - 1;
		 
		 while (low <= high) {
			  int mid = low + (high - low) / 2;
			  if (nums[mid] == target) {
					if (mid != n-1 && nums[mid + 1] == target) {
						 low = mid + 1;
					} else {
						 resHigh = mid;
						 break;
					}
			  } else if (nums[mid] < target) {
					low = mid + 1;
			  } else {
					high = mid - 1;
			  }
		 }
		 return new int[] {resLow, resHigh};
	}
}