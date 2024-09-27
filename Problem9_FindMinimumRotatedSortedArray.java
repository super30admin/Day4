// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] < nums[1] ? nums[0] : nums[1];
        if(nums[left] < nums[right])
            return nums[left];
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if(nums[mid - 1] > nums[mid])
                return nums[mid];
            if(nums[mid] < nums[right])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}