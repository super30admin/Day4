/*
Problem is to find the minimum element.

Approach 1: Linear Search, O(n).
Simply traverse the array by keeping a variable, min.

Approach 2: Binary Search, O(logn).

*/


/* Approach 1.

class Solution {
    public int findMin(int[] nums) {
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }
        }
        
        return min;
        
    }
    
    
}
*/


// Aproach 2:

class Solution {
    public int findMin(int[] nums) {
        
        // 
        // to check which side is sorted we can compare with the first element and the last  element of a particular side.
        // Initially compare last element with the first element, to check wheather the array is already sorted or not. if yes, return the first element.
        // Now, we tend to move towards the side which is not sorted, because that will give us the min, a point where max and min would be next to each other. 
        // If at any point, low <min < high, we conclude that the minimum is low only.
        
        int low=0;
        int high=nums.length-1;
        
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[low]<nums[high])
            {
                return nums[low];
            }
            
            if(( mid==high ||nums[mid]<nums[mid+1]) && (mid==low || nums[mid]<nums[mid-1]))
            {
                return nums[mid];
            }
            
            if(nums[mid]>=nums[low])
            {
                low=mid+1; // since we are already checking the mid element, we can directly skip it/
            }
            else
            {
                high=mid-1; // since we are already checking the mid element, we can directly skip it/
            }
            
            
            
            
        }
        
        
        
        
        return -1;
    }
    
    
}
