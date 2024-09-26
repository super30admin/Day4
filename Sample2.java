//Problem-2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length ==0 || nums==null) // if no element in array
            return -1;
        
     int low = 0;
     int high = nums.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
           if(nums[low]<=nums[high]) //perfectly sorted array
               return nums[low];   // return lowest value
            
            if((mid==0 ||nums[mid]<nums[mid-1]) 
                && (mid==nums.length-1 || nums[mid] < nums[mid+1])) // value at mid should be lower than its surrounding elements, handled edge cases 
                return nums[mid];
            else if( nums[mid] >= nums[low]) // finding the unsorted part of the rotated array
                low = mid+1;
            else
                high = mid-1;
        }
     return -1;
    }
}

//Problem-3
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0 || nums == null)
            return -1;
        
        int low=0;
        int high = nums.length-1;
        while(low<=high)
        {
           int mid = low + (high-low)/2;
           if((mid==nums.length-1 || nums[mid]>nums[mid+1]) && 
              (mid==0 || nums[mid]>nums[mid-1])) // value at mid should be greater than its surrounding elements, handled edge cases 
               return mid;
           else if(mid < nums.length-1 && nums[mid]<nums[mid+1]) // go towards the side where value is greater than mid element
                low=mid+1;
            else
                high = mid-1;
                
        }
        return -1;
    }
}