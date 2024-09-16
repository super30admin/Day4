// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        //check null
        if(nums == null || nums.length==0){
            return -1;
        }

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            if(nums[low]<=nums[high]){ //already sorted
                return nums[low];
            }

            int mid=low+(high-low)/2;
            //check id mid is minimum
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){ //check if sorted
                low=mid+1; //if not, go to unsorted side
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}