/*## Problem 3: (https://leetcode.com/problems/find-peak-element/) - 162
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

Your solution should be in logarithmic complexity.*/

/*
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Syntax error which were fixed later.


// Your code here along with comments explaining your approach
1. We are required to return any of the available peak element.
In order to do that we start with a binary search and start comparing middle element with the elements towwards its immediate right or left.
Then we move towards one side where next/previous element from mid is greater and continue to iterate.
We also make sure to handle situations wherein the frist and last element are only comapred with next and prev element respectively.
*/
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){return 9070;}
        int low = 0, high = nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
               return mid; 
            }
            else if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 9070;
    }
}