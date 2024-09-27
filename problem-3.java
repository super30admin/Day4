// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(nums.length==1) return 0;
        int mid =low+(high-low)/2;
        while(low<=high){
            
            if((mid==0 && nums[mid]>nums[mid+1]) || 
               (mid==(nums.length-1) && nums[mid]>nums[mid-1]) ||
               (mid > 0 && mid < (nums.length-1) && nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])){
                return mid;
            }
            else if(mid > 0 && nums[mid-1]>nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            mid=low+(high-low)/2;
        }
        return 0;
    }
}
