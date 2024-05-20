"""
Binary-Search-2
Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your function should return the index number 2. Example 2:

Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can return either index number 1 where the peak element is 2,

         or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

Time Complexity : O(logn)
Space Complexity :  O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
To find the peak element we're implementing binary search here but key is finding when to return the peak and to move in which direction? So here when our mid is either at low or high we return its index as peak
or we check if nums[mid] is greater than it's neighbours i.e., mid-1 and mid+1 then also we return it's peak. If it doesn't satisfy, then we try to move towards the element which is greater that means if mid+1 element
is > than mid then we move towards right else we move towards left as that side will have peak element for sure.
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1
        
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid == high or nums[mid] > nums[mid+1]) and (mid == low or nums[mid] > nums[mid-1]):
                return mid
            elif mid < high and nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1

        return -1


        
        
           
