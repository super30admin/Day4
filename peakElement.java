// Time Complexity : O(logn) where n is the number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Always move towards the side of the greater element next to the mid by rejecting the other half. If the elements on either side are equal, we can move to any side.


class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1; //invalid
       int low=0;
       int high=nums.length-1;
       while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
                return mid;
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