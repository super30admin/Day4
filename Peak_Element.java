// 162. Find Peak Element - https://leetcode.com/problems/find-peak-element/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {                                   // index -0,1,2,3
    public int findPeakElement(int[] nums) {      // nums = [1,2,3,1]
        int l = 0, r = nums.length - 1;
        while (l < r) { //size 0<3
            int mid = l + (r - l) / 2; // index 1
            if (nums[mid] > nums[mid + 1]) // values 2>3
                r = mid;
            else
                l = mid + 1; // index - 2
        }
        return l; // index - 2
    }
}
