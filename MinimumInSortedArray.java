// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[end]>nums[start]){//if there is no pivot
            return nums[start];
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]>nums[start]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}