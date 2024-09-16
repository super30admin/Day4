// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PeakElement {
    public int findPeakElement(int[] nums) {

        int low=0;
        int high=nums.length-1;

        while(low<=high){

            int mid= low+(high-low)/2;

            if((mid== nums.length-1 || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]>nums[mid-1]))
                return mid; 
            if(nums[mid]<nums[mid+1]) // if mid less than its next element, peak is towards the right as u found a bigger element towards right so 
                low=mid+1;              // move low to mid+1. 
                                        
            else
                high=mid-1;     // else peak is at left so move high to mid-1
        }
        return -1;
    }
}
