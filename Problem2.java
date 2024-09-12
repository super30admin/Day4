// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // if nums[l] > nums[r] then array is rotated
        while (nums[l] > nums[r]) {
            // find mid-pt and if its greater than or equal to nums[left] then it means nums[mid] is the biggest and we updteaa left               // ptr to mid+1 else left is still biggest then we update right = mid
            int m = (l + r) / 2;
            if (nums[m] >= nums[l]) l = m + 1;
            else r = m;
        }

        return nums[l];
    }
}