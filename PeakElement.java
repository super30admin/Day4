// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :wrong answer

class Solution {
    public int findPeakElement(int[] nums) 
    {  //taking variables
        int low=0;
        int high=nums.length-1;
        
        //iterative loop
        while(low<=high)
        {
            //updating mid
           int mid=low+(high-low)/2;
            //if number is greater than both neighbour elements return number
            if((mid==low||nums[mid]>nums[mid-1]) && (mid==high || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            //if mid is smaller than left,move to left
            else if(mid==high||nums[mid]<nums[mid+1])
            {
                low=mid+1; 
                
            }
            //else move to right
            else 
            {
                 high=mid-1; 
            }
        }
     return -1;
    }
}