// Time Complexity : O(logn)
// Space Complexity : Auxiliary Space: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
   private int startPositionSearch(int min,int max, int[] nums, int target) {
			if (min <= max) {
				int mid = min + (max - min) / 2;
				if (nums[mid] == target && (mid == 0 || target>nums[mid-1]))
					return mid;
				else if (target > nums[mid]) {
					min = mid + 1;
					return startPositionSearch(min,max, nums, target);
				} else {
					max = mid - 1;
					return startPositionSearch(min,max, nums, target);
				}

			}
			return -1;
		}

		private int lastPositionSearch(int min,int max, int[] nums, int target) {
			if (min <= max) {
					int mid=min+(max-min)/2;
				if (nums[mid]==target && ((mid==nums.length-1) || nums[mid]<nums[mid+1]))
					return mid;
				else if (target < nums[mid]) {
					max = mid - 1;
					mid = min + (max - min) / 2;
					return lastPositionSearch(min,max, nums, target);
				} else {
					min = mid + 1;
					mid = min + (max - min) / 2;
					return lastPositionSearch(min,max, nums, target);
				}

			}
			return -1;
		}

		public int[] searchRange(int[] nums, int target) {
			if (nums.length == 0 || nums == null)
				return new int[] { -1, -1 };

			int startingPos = startPositionSearch(0,nums.length-1, nums, target);
			int lastPos = lastPositionSearch(0,nums.length-1, nums, target);

			return new int[] { startingPos, lastPos };
		}
}
