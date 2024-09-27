//Time Complexity : O(log n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
//there are several occasions where manipulating start and end element was a problem.
//how to make the solution work using one-stack only to avoid extra stack.

class Solution {
	public int[] searchRange(int[] nums, int target) {
		// Map<Integer, Integer> nuMap = new HashMap<Integer, Integer>();
		/*
		 * int arr[] = new int[]{-1, -1}; int count = 0; for (int i = 0; i <
		 * nums.length; i++) {
		 * 
		 * 
		 * 
		 * 
		 * nuMap.put(nums[i], i);
		 * 
		 * 
		 * 
		 * }
		 * 
		 * for (Map.Entry<Integer, Integer> en : nuMap.entrySet()) {
		 * System.out.println(en.getKey() + " => " + en.getValue()); if (
		 * nuMap.containsKey(target) && nums.length == 1) { return new int[] {0, 0}; }
		 * if (en.getKey() == target) { // System.out.println(count + " target => " +
		 * target); arr[count] = nuMap.get(target); count++; } }
		 * 
		 * return arr;
		 */

		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };

		int firstPos = firstPos(nums, target);

		int lastPos = lastPos(nums, target);

		return new int[] { firstPos, lastPos };
	}

	public int firstPos(int nums[], int target) {

		int L = 0;
		int H = nums.length - 1;
		int start = -1;

		while (L <= H) {

			int mid = L + (H - L) / 2;

			if (nums[mid] == target) {
				start = mid;
				H = mid - 1;
			} else if (target < nums[mid]) {
				H = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return start;
	}

	public int lastPos(int nums[], int target) {

		int L = 0;
		int H = nums.length - 1;
		int last = -1;

		while (L <= H) {

			int mid = L + (H - L) / 2;

			if (nums[mid] == target) {
				last = mid;
				L = mid + 1;
			} else if (target < nums[mid]) {
				H = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return last;
	}

	// throw new IllegalArgumentException("No sum found");
}