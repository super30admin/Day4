// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + ((end - start) >> 1);
            if(nums[mid] < nums[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}