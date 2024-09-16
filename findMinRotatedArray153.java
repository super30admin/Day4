package nov192020;

// Problem 8
// Source Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// https://github.com/super30admin/Binary-Search-2
public class findMinRotatedArray153 {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[low] < nums[high]) {
				return nums[low];
			}
			if ((mid == low || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid + 1])) {
				return nums[mid];
			} else if (nums[low] <= nums[mid])
				low = mid + 1;
			else {
				high = mid - 1;
			}

		}
		return -1;
	}

}
// Time complexity : O(log n )
// Space Complexity : O (1)
