# Binary-Search-2 Explain your approach in **three sentences only** at top of your code

## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value. Your algorithm's runtime complexity must be in the order of O(log n).If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

# Create two functions that will return the starting and ending position indexes. Optimal path is
# where our middle element returns as the start and end position and we return it. Also edge cases
# where we get the answer directly.
# The starting position will first look at the mid element with the target and parse through the array
# until the array element is less than the target element.
# For the ending position first look for the mid element and parse through the array until the array
# element is less than the target element. 

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

# Check length of the array to cover all edge cases
# Check if the mid element is less than its neighbouring elements, return the mid element as it is
# our best case scenario.
# Continue moving either left of the array of right till so that we reduce our search space
# Finally we will have two elements where the lowest index element is less than highest index element
# We will return comparing the elements and return the lowest.

## Problem 3: (https://leetcode.com/problems/find-peak-element/) A peak element is an element that is greater than its neighbors. Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index. The array may contain multiple peaks, in that case return the index to any one of the peaks is fine. You may imagine that nums[-1] = nums[n] = -∞.
Example 1: Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
Note:
Your solution should be in logarithmic complexity.
# Check edge cases if the array is empty then return -1 or if has one element return 0
# Check if my mid element is greater than neighbouring elements then its the peak element
# If not then if the mid element is greater than mid - 1 we go to the right side of the array
# as there is a gurantee that the peak will be on the increasing number numbers rather than 
# decreasing numbers

