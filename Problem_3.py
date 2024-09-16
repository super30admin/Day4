"""
Problem 3: A peak element is an element that is greater than its neighbors.

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



"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        """
        find the peak in the list
        Itypre: list
        rtype: num(int)
        """
        if num == []:
            return -1
        # low: l; high: h; mid: m
        l, h = 0, len(nums) -1 
        while l < h :
            m = (l+h) // 2
            if nums[m] > nums[m +1]:
                h = m +1
            else:
                l = m -1
        return l

#   Time Complexity: O(log n), where n is the number of elements in the list
#   Space Complexity: O(1)

