// Time Complexity :O(log n)
// Space Complexity :O(1) As array is not an Auxiliary  space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -
class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        if(nums==null || nums.length==0)
            return -1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            System.out.println(mid);
            if(mid<nums.length-1 && nums[mid] < nums[mid+1])
                start=mid+1;
            else if(mid>0 && nums[mid] < nums[mid-1])
                end=mid-1;
            else 
                return mid;
            
        } 
        return -1;
    }
}