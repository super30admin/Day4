// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        //null check
        if(nums == null || nums.length ==0) 
            return -1;
        int low=0;
        int high= nums.length-1;
        //binary search
        while(low<=high){
            int mid= low+(high-low)/2;
            //if elements adjacent to the mid on both sides are lower than the mid, 
            //then return mid as peak, else go to the increasing side
            //if mid is the smallest index, then we cannot do  mid-1 check also mid will be low, 
            //we return mid in such case beacuse in the wuestion we have elements outside array is considered as -infinity, viseversa for last index.
            if((mid==low || nums[mid]>nums[mid-1]) && (mid==high || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]> nums[mid]){
                low=mid+1;
            }
               else 
               high =mid-1;
               }
               return high;
}
}