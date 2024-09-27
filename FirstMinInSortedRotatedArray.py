"""
Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if(len(nums)==0 or nums == None):
            return -1
        low = 0
        high = len(nums) - 1
        # If the the first element is lower than the last
        # then we deduce that array is sorted and we return first element
        if(nums[low] <= nums[high]):
            return nums[low]
        
        #Binary Search
        while low <= high:
            mid = low + (high - low)//2
            if(nums[low] <= nums[high]):
                return nums[low]
            # Check if the mid element is the lowest
            if(nums[mid] < nums[mid - 1] and nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
            