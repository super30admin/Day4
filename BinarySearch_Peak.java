// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(start == mid){
                if(nums[start]>=nums[end]){
                    return start;
                }
                else{
                    return end;
                }
            }
            if(nums[mid+1]<nums[mid] && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){
                start=mid+1;
            }
            else if(nums[mid-1]>nums[mid]){
                end=mid-1;            }
        } 
        return start;
    }
}