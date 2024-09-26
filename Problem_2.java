
//Time Complexity :O(logn)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

/*
* Your code here along with comments explaining your approach : 
* I have used binary search. One side of the mid element is always sorted.
* Using this, I have moved low and high pointers.
*/

public class RotatedSortedArraySearch {

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && nums[mid] >= target) {
					high = mid - 1;
				} else
					low = mid + 1;
			} else {
				if (nums[high] >= target && nums[mid] <= target) {
					low = mid + 1;
				} else
					high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(nums, 0));
	}

}
