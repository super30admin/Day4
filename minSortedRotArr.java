// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int l = 0;
        int r = nums.length-1;
        int result = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l + (r-l)/2;
            result = Math.min(result, nums[mid]);
            if(nums[mid] >= nums[l]){
                result = Math.min(result, nums[l]);
                l = mid + 1;
            }else{
                r = mid - 1;
            }

        }
        return result;
    }
}