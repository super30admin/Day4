// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class First_Last_Index {
	public int binarySearchleft(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		// We execute this loop till we find the first index of target
		while (low <= high) {
			// MidPoint of Array is calculated
			int midpoint = low + (high - low) / 2;// Integer Overflow Avoided
			/*
			 * If the the element at midpoint is equal to target, edge case is handled and
			 * starting index is found
			 */
			if (nums[midpoint] == target) {
				if (midpoint == 0 || nums[midpoint] > nums[midpoint - 1]) {
					return midpoint;
				} else {
					high = midpoint - 1;
				}
			} else if (nums[midpoint] < target) {
				low = midpoint + 1;
			} else {
				high = midpoint - 1;
			}
		}
		return -1;
	}

	public int binarySearchright(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		// We execute this loop till we find the first index of target
		while (low <= high) {
			// MidPoint of Array is calculated
			int midpoint = low + (high - low) / 2;
			/*
			 * If the the element at midpoint is equal to target, edge case is handled and
			 * ending index is found
			 */
			if (nums[midpoint] == target) {
				if (midpoint == nums.length - 1 || nums[midpoint] < nums[midpoint + 1]) {
					return midpoint;
				} else {
					low = midpoint + 1;
				}
			} else if (nums[midpoint] < target) {
				low = midpoint + 1;
			} else {
				high = midpoint - 1;
			}
		}
		return -1;
	}

	public int[] searchRange(int[] nums, int target) {
		// Edge cases are handled
		if (nums.length == 0 || nums == null) {
			return new int[] { -1, -1 };
		}
		// The Start index of target is searched
		int start = binarySearchleft(nums, target);
		// The end index of target is searched
		int end = binarySearchright(nums, target);
		return new int[] { start, end };
	}
}