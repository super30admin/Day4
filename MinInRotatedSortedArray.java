// Time Complexity : O(logn) where n is length of the nums array. 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        // only one element array
        if (nums.length == 1)
            return nums[0];
        int start = 0, end = nums.length - 1;

        // sorted array
        if (nums[start] < nums[end])
            return nums[start];
        // iteratively go to the not sorted part till you are left with two elements
        while (end - start > 1) {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid])
                end = mid;
            else if (nums[mid] > nums[end])
                start = mid;
        }
        // return minimum of the two elements
        return Math.min(nums[start], nums[end]);
    }
}