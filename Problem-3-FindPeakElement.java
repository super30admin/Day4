
// Time Complexity :  O(logn) where n is number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int low =0, high = nums.length-1;
        if(nums.length==1) return 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(mid==0 && nums[mid+1]<nums[mid])
                return mid;
            if(mid==nums.length-1 && nums[mid-1]<nums[mid])
                return mid;
            if(mid>0 && mid<nums.length-1 && nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid])
                return mid;
            if(nums[mid+1]>nums[mid])
                low=mid+1;
            else if (nums[mid-1]>nums[mid])
                high=mid-1;
        }
        return -1;
    }
}