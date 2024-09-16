package nov192020;

// Problem 9 
// https://leetcode.com/problems/find-peak-element/
// https://github.com/super30admin/Binary-Search-2
public class peakElement162 {
	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}

//. Time Complexity : O(log n)
// Space Complexity : O (1)
