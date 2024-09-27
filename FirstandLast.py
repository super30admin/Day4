#Time Complexity: O(log n)
#Space Complexity: O(1); no extra space being used
# successful run on Leetcode: yes
# Issue while coding: no
'''
We do binary search twice, once to find start index and next to find ending index
first time we find the element, we move to the left to search for the start for start index and we move to the right to find the end index
'''
class Solution:
    def __init__(self):
        self.firstLow = 0
    def firstIdxSearch(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def secondIdxSearch(self, nums: List[int], target: int) -> int:
        low = self.firstLow
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid+1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
            
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[len(nums) - 1]:
            return [-1, -1]
        start = self.firstIdxSearch(nums, target)
        if start == -1:
            return [-1, -1]
        self.firstLow = start
        end = self.secondIdxSearch(nums, target)
        return [start, end]
        
        
        
        
