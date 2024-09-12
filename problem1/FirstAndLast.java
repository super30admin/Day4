// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

package problem1;

public class FirstAndLast {

	public FirstAndLast() {
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}

		int[] ans = new int[2];
		ans[0] = findIndex(nums, target, true);
		if (ans[0] == -1) {
			ans[1] = -1;
		} else {
			ans[1] = findIndex(nums, target, false);
		}
		return ans;
	}

	/*
	 * Perform binary search to find lower and upper bounds.
	 */
	public int findIndex(int[] nums, int target, boolean flag) {
		int left = 0;
		int right = nums.length - 1;
		int mid;

		while (left <= right) {
			mid = (right + left) / 2;
			if (nums[mid] == target) {
				if (flag) {
					if (mid == left || nums[mid - 1] != target) {
						return mid;
					} else {
						right = mid - 1;
					}
				} else {
					if (mid == right || nums[mid + 1] != target) {
						return mid;
					} else {
						left = mid + 1;
					}
				}
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstAndLast obj = new FirstAndLast();
		int[] arr = { 5, 7, 7, 8, 8, 10 };
		int[] pos = obj.searchRange(arr, 8);
		System.out.println("Searching for element 8 -- Lower Bound: " + pos[0] + ", Upper Bound: " + pos[1]);
		pos = obj.searchRange(arr, 45);
		System.out.println("Searching for element 45 -- Lower Bound: " + pos[0] + ", Upper Bound: " + pos[1]);
	}
}
