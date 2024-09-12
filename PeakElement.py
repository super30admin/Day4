# // Time Complexity : O(LogN)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# A peak element is an element that is greater than its neighbors.

# Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

# The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

# You may imagine that nums[-1] = nums[n] = -∞.

# Example 1:

# Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your function should return the index number 2. Example 2:

# Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can return either index number 1 where the peak element is 2,


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        if nums==[] or len(nums)==0:
            return -1
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            return 0 if nums[0]>nums[1] else 1
        
        low = 0
        high = len(nums) -1
        
        while(low < high-1):
            mid = low + (high - low)//2
            if nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
                return mid
            elif nums[mid] < nums[mid-1]:
                high = mid - 1
            else:
                low = mid + 1
        return low if nums[low]> nums[high] else high
        
        