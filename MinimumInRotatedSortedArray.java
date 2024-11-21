/*
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1

Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

 */

/*
 * Time Complexity: O (logN) -> Binary Search implementation
 * 	
 * Space Complexity: O (1) -> Since we are not using any extra space to store the elements of array
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: 
 * 	- Scanning the array with Binary search is almost same as finding the peak element example, just small change in condition.
 * 	- No issues faced
 * 	- Approach suggested by Shaazman of trying our algorithm first on given problem and then considering edge/other cases/problems was really helpful
 * 
 */

package com.s30.edu.binarysearch2;

class MinimumInRotatedSortedArray {
	
    public int findMin(int[] nums) {
    	
    	/*
    	 * Initialize low and high variables
    	 */
        int low = 0;
        int high = nums.length-1;
        
        /*
         * Implement Binary Search to find minimum element in rotated sorted array
         */
        while(low <= high){
        	// Instead of low + high / 2, do as below to avoid overflow error
            int mid = low + (high-low) / 2;
            
            /*
             * This is the base condition, it checks for extreme edge cases.
             * 1. It checks if mid reached to leftmost element && mid+1 element > mid element,
                  In this case, we return leftmost element as minimum element in array
             * 2. It checks if mid reached to rightmost element && mid-1 element > mid element,
                  In this case, we return rightmost element as minimum element
             *    When nums.length = 1, (mid == 0) && (mid == num.length - 1) conditions will be satisfied
             */
            if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == nums.length-1 || nums[mid+1] > nums[mid])){
                return nums[mid];   
            }
            /* Compare the mid element with high index element,
             * if mid element is greater, then definitely our minimum element is on the right side
             * move to the right side
            */
            else if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            /* if mid element is less than high element, then our minimum element is on the left side
             * move to the left
            */
            else{
                high = mid - 1;
            }
            
        }
        return -1; // If minimum element is not found in array, return -1
        
    }
    
}
