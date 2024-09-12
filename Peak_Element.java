// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Peak_Element {
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		// The loop executes till we find the peak element
		while (left < right) {
			// Integer Overflow Avoided
			int mid = left + (right - left) / 2;
			/*
			 * If statement is executed in the loop until left becomes equal to right and
			 * when that happens we have found one of the peak elements in the array
			 */
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}