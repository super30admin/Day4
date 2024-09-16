// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    public int findPeakElement(int[] nums) {
        //check for null
        if(nums == null || nums.length == 0)
            return -1;

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            //check if mid is the peak
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            //left search
            else if(mid>0 && nums[mid-1]>nums[mid]){
                high=mid-1;
            }
            else{
                //right search
                low=mid+1;
            }
        }
        return -1;
    }
}
