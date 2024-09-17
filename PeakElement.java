/*
Author: Akhilesh Borgaonkar
Problem: Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
Approach: Using binary search to find the mid element which is larger than its neighboring elements. If a peak element is not found at
    mid then, explore towards the side of the mid which has larger element. So that as array is sorted then, you will hit the peak.
Time Complexity: O(logn) where n is number of elements in the array.
Space complexity: O(1) constant
LC Verified.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if((mid==low || nums[mid-1]<nums[mid]) && (mid==high || nums[mid+1]<nums[mid]))     //find element viz. larger than its neighbors
                return mid;
               
            else if(mid==high || nums[mid]<nums[mid+1])             //if the right neighbor is larger then explore the right sub array
                low = mid+1;
            
            else if(nums[mid]>nums[mid+1])                          //if the left neighbor is larger then explore the left sub array
                high = mid-1;
        }
        return -1;      
    }
}