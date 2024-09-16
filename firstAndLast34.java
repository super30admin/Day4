package nov18th2020;

// S30 Big N Problem #7 {Medium }
// Source Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// https://github.com/super30admin/Binary-Search-2
public class firstAndLast34 {
	private int binaryfirst(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (nums[mid] == target) {
					if (mid == low || nums[mid] > nums[mid - 1]) {
						return mid;
					} else {
						high = mid - 1;
					}
				}
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private int binaryLast(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (nums[mid] == target) {
					if (mid == high || nums[mid] < nums[mid + 1]) {
						return mid;
					} else {
						low = mid + 1;
					}
				}
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int firstOccurence = binaryfirst(nums, target);
		int lastOccurence = binaryLast(nums, target);
		return new int[] { firstOccurence, lastOccurence };

	}
}

//. Time Complexity : O(log n)
// Space Complexity : O (1)

