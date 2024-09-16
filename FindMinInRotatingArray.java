// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : stuck at last and first index thing (when middle was first or last element)


// Your code here along with comments explaining your approach
1. see if array is already sorted with 0 rotation and return element
2.Using binary search find the mid index and check which side is sorted based on that choose the unsorted or opposite of sorted side 

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
      
           
        if(nums[start] <= nums[end])
        {
            return nums[start];
        }
        
       //  int  mid = start + (end-start)/2;
        
        while(start<=end)
        {   
              int  mid = start + (end-start)/2;
            
             if(nums[start] <= nums[end] )
                {
                    return nums[start];
                }
            
            if((mid == 0 || nums[mid] < nums[mid-1])&&
              ( mid == nums.length -1 || nums[mid] < nums[mid+1]
              ))
            {
                return nums[mid];
            }
             else  if(nums[start] <= nums[mid])  // LEFT IS SORTED 
                {
                  // thn go to right 
                    start = mid+1;

                }
             else
                {
                    end = mid-1;
                } 
        }
        
     return -1;
    }
}
