//Problem
162. Find Peak Element
        A peak element is an element that is strictly greater than its neighbors.
        Given an integer array nums,find a peak element,and return its index.If the array contains multiple peaks,return the index to any of the peaks.

        You may imagine that nums[-1]=nums[n]=-∞.

        You must write an algorithm that runs in O(log n)time.


// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
Keep comparing mid's value with its next element and slide the right point to mid if its greater or else left = mid+1;
peak element would be in left variable;
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else
                end = mid - 1;

        }

        return -1;
    }
}