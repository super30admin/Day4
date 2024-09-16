/*
   
A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.


*/

//Time comlpexity - O(log n) 
//space complexity - O(1) 
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/

// Your code here along with comments explaining your approach

public class Solution {
    public int findPeakElement(int[] nums) {
        //edge case
        if(nums == null || nums.length ==0) return -1;
        
        int low = 0;
        int high = nums.length -1 ;
        
        while(low <= high)
        {
            int mid = low +(high-low)/2; //find the mid value
            //check for the peak element with edge cases
            if((mid == 0 || nums[mid] > nums[mid-1]) 
               && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if (mid>0 && nums[mid] < nums[mid-1])
                high = mid-1; //search towards the left of th emid
            else low = mid+1;//search towards the rightof the mid
        }
        return -1;
    }
}