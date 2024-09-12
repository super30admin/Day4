// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

package problem2;

public class RSArrayMinimum {
	// Perform binary search with slight modification
	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int low = 0;
		int high = nums.length - 1;

		if (nums[low] < nums[high]) {
			return nums[low];
		}

		int mid;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}

			if (nums[mid] > nums[0]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		RSArrayMinimum obj = new RSArrayMinimum();
		int[] arr = { 4, 5, 6, 8, 13, 45, 756, 1, 2, 3 };
		System.out.println("Minimum element in the array -- " + obj.findMin(arr));
	}

}
