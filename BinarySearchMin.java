package com.Aug2020.BinarySearch;

//Time Complexity : O(log n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
//there are several occasions where manipulating start and end element was a problem.
//how to make the solution work using one-stack only to avoid extra stack.
class BinarySearchMin {
	public int findMin(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;

		int min = nums[0];

		while (start < end) {
			int mid = start + (end - start) / 2;
			

			if (nums[end] < nums[mid]) {

				end = mid - 1;

			} else {
				start = mid + 1;

			}

		}
		return nums[start];
	}
}
