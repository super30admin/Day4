/*
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non decreasing array.
-10^9 <= target <= 10^9

 */

/*
 * Time Complexity: O (logN) -> Binary Search implementation
 * 	
 * Space Complexity: O (1) -> Since we are not using any extra space to store the elements of array
 * 
 * Did this code successfully run on leetcode: Yes
 * Any problem you faced while coding this: 
 * 	- Scanning the array with Binary search is almost same as previous example, but needed some trial and error on the conditions to check.
 * 
 */

package com.s30.edu.binarysearch2;

class Solution {
	
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1}; // Initialize the targetRange array to {-1, -1}
        
        /*
         * boolean left parameter to decide what to do if nums[mid] == target
         * If left parameter is true, we traverse left subarray, else go to right subarray
         */
        int leftIndex = leftRightInsertionIndex(nums, target, true); // find left index
        
        /*
         * After getting the leftmost index, we check if that index is within the 
         * array bounds and target exists in the 'nums' array
         * 
         * If target does not exist in left subarray, return targetRange = {-1,-1}
         * No need to traverse right subarray in that case
         */
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return targetRange;
        }
        
        /*
         * else, if target exists at left index, we add leftIndex to array 'targetRange'
         * and traverse right subarray with passing left parameter as 'false'
         */
        targetRange[0] = leftIndex;
        // Since, high is at nums.length, when low becomes equal to high, we subtract 1 to get the rightmost index
        targetRange[1] = leftRightInsertionIndex(nums, target, false)-1; 
        
        return targetRange; 
    }
    
    // Binary Search to find the leftmost(first) and rightmost(last) position of target  
    public int leftRightInsertionIndex(int[] nums, int target, boolean left){
        int low = 0;
        int high = nums.length;
        
        while(low < high){
            int mid = low + (high-low) / 2;
            
            // Condition to traverse the left subarray
            if((nums[mid] > target) || (left && nums[mid] == target)){
                high = mid;
            }
            else{ // traverse the right subarray
                low = mid+1;
            }
        }
        
        return low; // return the leftmost/rightmost index of target
        
    }
    
}
