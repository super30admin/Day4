/*
## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
*/

// Time Complexity : O(lognN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//ask interviewer(assumptions/follow up ques): Duplicates not allowed, multiple peaks can be found(only return 1 peak) and negative infinity is around left elements
//approach:we have to find index for peak element if element is greater than its left and right neighbouring element
//consider edge cases: 1. if nums is null or length is 0, return -1
//2. if while traversing, it reaches leftmost or rightmost element, then return mid 

class Solution {
    public int findPeakElement(int[] nums){
        //initialise low and high pointer
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            //mid pointer
            int mid = low + (high-low)/2;
            //base case
            //1.if it reaches the leftmost or right most element, return mid element
            //2.if mid element is greater than its left and right neighbouring element, then return mid element
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            //otherwise, if it doesn't reach leftmost element and mid element is lesser than its left element
            //then shift high pointer to left side of mid, else, shift low pointer to tight side of mid
            else if(mid > 0 && nums[mid] < nums[mid - 1]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return - 1;
    }
}

//Brute force approach-Linear Scan(O(N))
//We will compare each element with its left and right neighbouring element and check if its greater, and return index of that element