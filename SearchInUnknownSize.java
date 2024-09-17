// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int low=0,high=n-1,ans=Integer.MAX_VALUE;
        if(nums[low]<=nums[high]) return nums[low];
        while(low <= high) {
            int mid=low+(high-low)/2;
            if(mid==0) {if(nums[0]<nums[1]) return nums[0];else return nums[1];}
            if(mid==n-1) {if(nums[n-2]<nums[n-1]) return nums[n-2]; else return nums[n-1];}
            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            if(nums[mid]<nums[mid-1]) return nums[mid];
            if(nums[low]<=nums[mid]) low=mid+1; else high=mid-1;
        }
        return ans;
    }
}