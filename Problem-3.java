/*

To find the peak within an array.

Two Approaches:

Approach 1: Lineary search: check if nums[i+1]<nums[i]>nums[i-1]; return i;

Approach 2: Binary Search: 

get to an element, check the condition for peak, if not, move the search towards, the direction of element which is greater than current element.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        
        
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            
            
            if((mid==high || nums[mid]>nums[mid+1])&&(mid == low || nums[mid]>nums[mid-1]))
            {
                return mid;
            }
            
            if(mid!=high && nums[mid]<nums[mid+1])
               {
                   low=mid+1;
               }
               
            else if(mid!=low && nums[mid-1]>nums[mid])
               {
                   high=mid-1;
               }
               
        }
               
               return -1;
        
    }
}
