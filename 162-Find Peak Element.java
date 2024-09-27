//Time Complexity=O(log N)
//Space Complexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Here we are performing binary search on the array, and are checking at every mid whether its left and right element are less than it, else we are changing the start and end index

class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if((mid==end || nums[mid]>nums[mid+1]) && (mid==start || nums[mid]>nums[mid-1]))
                return mid;
            else if(nums[mid]<nums[mid+1])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}