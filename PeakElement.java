// Time Complexity : O(log n) for reducing search space by half
// Space Complexity :O(1) -> only pointers are used for left, right, mid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PeakElement {
    public int findPeakElement(int[] nums) {
        
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            
            int mid= low+(high-low)/2;
            
            if((mid== nums.length-1 || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]>nums[mid-1])) // mid needs to be greater than its before and after element to be a peak.
                return mid; //  If its last element you need to check only its prev element and if its first element u need to check only its next element.
                            // check right hand side first to avoid indexout of bounds exception
            if(nums[mid]<nums[mid+1]) // if mid less than its next element, peak is towards the right as u found a bigger element towards right so 
                low=mid+1;              // move low to mid+1. 
                                        // check right hand side first to avoid indexout of bounds exception

            
            else
                high=mid-1;     // else peak is at left so move high to mid-1
            
            
        }
        
        return -1;
    }
}