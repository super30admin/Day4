//Time complexity=O(log N)
//Space complexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            // If the array is already sorted we are returning the start element
            if(nums[end] > nums[start]) return nums[start];
            //For an element to be minimum/pivot its both side values should be greater than that value
            if((mid==start || nums[mid] < nums[mid-1]) && (mid==end || nums[mid]<nums[mid+1]))
                return nums[mid];
            else if(nums[end]<nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}