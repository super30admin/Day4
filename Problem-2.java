// Time Complexity : O(log N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int start=0;
        int end = nums.length-1;
        
        if(nums[end]>nums[start])
            return nums[start];
        
        while(start<=end){
            int mid=(start+end)/2;
            
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid]<nums[mid-1])
                return nums[mid];
            
            if(nums[mid]>nums[0])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}