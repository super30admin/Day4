/*
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] != nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -infinity.

Example 1:

Input: 

nums = [1,2,3,1]

Output: 2

Explanation: 

3 is a peak element and your function should return the index number 2.

Example 2:

Input: 
nums = [1,2,1,3,5,6,4]

Output: 
1 or 5 

Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
             
Follow up: Your solution should be in logarithmic complexity.

 */



/*
 * Time Complexity: O (logN) -> Binary Search implementation
 * 	
 * Space Complexity: O (1) -> Since we are not using any extra space to store the elements of array
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: 
 * 	- Scanning the array with Binary search is almost same as previous example, but needed some trial and error on the conditions to check.
 * 
 */

package com.s30.edu.binarysearch2;

class PeakElement {
	   
    public int findPeakElement(int[] nums) {
       
        int low = 0;
        int high = nums.length-1;
     
        while(low <= high){
            /*
            * Instead of mid = low + high / 2, do as below to avoid overflow error if low and high is too large
            */
            int mid = low + (high - low) / 2;
           
            /*
            * This is the base condition, it checks for extreme edge cases.
            * 1. It checks if mid reached to leftmost element && mid+1 element < mid element,
                 In this case, we return leftmost element index as peak
            * 2. It checks if mid reached to rightmost element && mid-1 element < mid element,
                 In this case, we return rightmost element index as peak
            *    When nums.length = 1, (mid == 0) && (mid == num.length - 1) conditions will be satisfied
            */
            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])){
                return mid;
            }
            /*
             * If we do not find peak element at mid, we check
            */
            else if(nums[mid+1] > nums[mid]){ // If true
                low = mid+1; // move to right to find peak element
            }
            else{
                high = mid-1; // move to left to find peak element
            }
        }
       
        return -1;   // In case, if we don't find peak element in given array
       
    }
   
}
