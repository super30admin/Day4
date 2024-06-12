/*package whatever //do not write package name here */
// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int findMin(int[] nums) 
    {
        //taking variables
     int low=0;
     int high=nums.length-1;
     int mid=0;
        //iterating through the condition
        while(low<=high){
        mid=low+(high-low)/2;
        //sorted array
        if(nums[high]>nums[low])
        {
            return nums[low];   
        }
            //base case
             if((mid==low || nums[mid]<nums[mid-1]) &&(mid==high || nums[mid]<nums[mid+1]))
            {return nums[mid];}
           //if left is sorted,move to right
            else if(nums[low]<=nums[mid])
            {
                low=mid+1;
            }
            //else move to left
            else
            {
                high=mid-1;
            }
        }
       return -1; 
     }
 }