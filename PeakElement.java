// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach

class Solution {
	public int findPeakElement(int[] nums) {
		 
		 if (nums.length == 1) return 0;
		 
		 int n = nums.length;
		 int low = 0;
		 int high = n - 1;
		 
		 while (low <= high) {
			  int mid = low + (high - low) / 2;
			  if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n -1 || nums[mid] > nums[mid+1])) {
					return mid;
			  } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
					high = mid - 1;
			  } else {
					low = mid + 1;
			  }
		 }
		 
		 return -1;
		 
	}
}