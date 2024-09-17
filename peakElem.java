// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, len = nums.length - 1, mid = 0;
        if(nums.length == 1){
            return 0;
        }if (nums[0] > nums[1]){
            return 0;
        }if (nums[r] > nums[len-1]){
            return r;
        }
        while (l <= r){
            mid = l + (r-l)/2;
            if (mid-1 != -1 && nums[mid-1] > nums[mid]){
                r = mid - 1;
            }else if(mid < len-1 && nums[mid+1] > nums[mid]){
                l = mid + 1;
            }else if(nums[mid]> nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
        }
        return mid;
    }
}