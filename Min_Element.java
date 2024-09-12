// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Min_Element {
	public int findMin(int[] nums) {
		/*
		 * Edge Case is handled for length 1 and 2
		 */
		if (nums.length == 1) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;
		if (nums[right] > nums[0]) {
			return nums[0];
		}
		// While loop executes till we find the minimum element
		while (right >= left) {
			// Integer Overflow Avoided
			int mid = left + (right - left) / 2;
			/*
			 * If the mid element is greater than mid+1 element, mid+1 element is the
			 * smallest element
			 */
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			/*
			 * If the mid-1 element is greater than mid element, mid element is the smallest
			 * element
			 */
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
			if (nums[mid] > nums[left]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}