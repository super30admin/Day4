// Time Complexity : O(logn) where n is length of the nums array. 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        // for array with one element
        if (nums.length == 1)
            return 0;
        // for array with two elements
        if (nums.length == 2)
            return (nums[0] > nums[1]) ? 0 : 1;
        int n = nums.length - 1;
        // check first and last elements
        if (nums[0] > nums[1])
            return 0;
        if (nums[n] > nums[n - 1])
            return n;
        int start = 0, end = n;
        // binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // check if mid element is the one
            if (mid - 1 >= 0 && mid + 1 <= n && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
                return mid;
            // else traverse to the side with larger next value
            else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                end = mid;
            else
                start = mid;
        }
        return -1;
    }
}