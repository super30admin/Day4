
//Time Complexity :O(logn)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

/*
* Your code here along with comments explaining your approach : 
* I have used binary search separately for finding first and last index.
*/

public class FirstAndLastElementInSortedArray {
	public static void searchRange(int[] nums, int target) {
		int n1 = getFirstIndex(nums, target);
		int n2 = getLastIndex(nums, target);
		System.out.println(n1 + "\t" + n2);

	}

	private static int getLastIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private static int getFirstIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid - 1] < nums[mid]) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = new int[] { 5, 7, 7, 8, 8, 8, 10 };
		searchRange(nums, 11);
	}

}
