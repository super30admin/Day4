//Time complexity is O(logn)
//space complexity is O(1)
//Able to run in leetcode

class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public int helper(int[] nums, int l, int r){
        if(l==r)
        return l;
        int m = l+(r-l)/2;
        if(nums[m]>nums[m+1]){
            return helper(nums, l, m);
        }
        return helper(nums, m+1, r);
    }
}
