// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        
        if(nums==null || nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums[low]<nums[high]){
            return nums[0];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            else if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }  
            else if(nums[low]>nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}