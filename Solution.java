// Time Complexity : O(log n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
	public static int[] searchRange(int[] nums, int target) {
		int fail[] = { -1, -1 };
		if (nums.length > 0) {
			int index = binarySearch(nums, 0, nums.length-1, target);
			
			if (nums.length == 1) {
				if (nums[0] == target) {
					int[] result = { 0, 0 };
					return result;
				} else {
					return fail;
				}
			}
			if(index!=-1)
			{
				int right =index;
				int left=index;
				while (right<nums.length && nums[right]==target)
				{
					right++;
				}
				while(left>0 && nums[left]==target)
				{
					left--;
				}
				return new int[] {left+1,right-1};
				
			}
			else {return fail;}

			
		} else {
			return fail;
		}
	}

	static int binarySearch(int arr[], int l, int r, int x) {
		int middle = (l + r) / 2;

		if (r < l) {
			return -1;
		}

		if (x < arr[middle]) {
			return binarySearch(arr, l, middle - 1, x);
		}

		if (x > arr[middle]) {
			return binarySearch(arr, middle + 1, r, x);
		}

		if (x == arr[middle]) {
			return middle;
		}

		return -1;
	}
	
}