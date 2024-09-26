// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            //check if number is greater than both its neighbors
            if((mid==0 || (nums[mid]>nums[mid-1])) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
                
        }
        return -1;
    }
}