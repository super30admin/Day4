//Find Minimum in a rotated sorted array
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid= low + (high-low)/2;
           if((mid==0 ||nums[mid]<nums[mid-1]) && (mid==nums.length-1||nums[mid]<nums[mid+1]))
           {
               return nums[mid];
           }
            else if(nums[mid]>nums[high])
            {
                //right side og the array is unsorted and lowest value is here
                low=mid+1;
            }
            else
            {
               high=mid;
            
                //left side of the array is unsorted and lowest value is here
             }
                            
        }
        return -1;
    }
}

// Find peak Element
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+ (high-low)/2;
            if((mid==0 ||nums[mid]>nums[mid-1]) && (mid==nums.length-1|| nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1])
            {
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return -1;
    }
}
