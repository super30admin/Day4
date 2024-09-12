// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

package problem3;

public class FindPeak {
	// Modify Binary Search to find the elements.
	public int findPeakElement(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}

		int low = 0;
		int high = nums.length - 1;

		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (mid == 0) {
				return nums[mid] > nums[mid + 1] ? mid : mid + 1;
			}

			if (mid == nums.length - 1) {
				return nums[mid] > nums[mid - 1] ? mid : mid - 1;
			}

			if ((nums[mid] > nums[mid + 1]) && nums[mid] > nums[mid - 1]) {
				return mid;
			}

			if (nums[mid] > nums[mid - 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindPeak obj = new FindPeak();
		int[] arr = { 4, 5, 6, 8, 13, 45, 756, 1, 2, 3 };
		System.out.println("Peak element index in the array -- " + obj.findPeakElement(arr));
	}
}
