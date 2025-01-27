'''
Time complexity: O(log n)
Space complexity: O(1)
LeetCode: Accepted, #34
Approach: Binary search - 2 times
1. Find the leftmost index of the target element using binary search 
2. Find the rightmost index of the target element using binary search starting from the leftmost index found in step 1.
3. Return range of the target element.
'''

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        rangeStart =  self.BinarySearchLeft(nums, 0, len(nums)-1, target)
        if rangeStart == -1:
            return [-1,-1]        
        rangeEnd = self.binarySearchRight(nums,rangeStart,len(nums)-1,target)
        return [rangeStart,rangeEnd]

    def BinarySearchLeft(self, nums, low, high, target):
        while low<=high:
            mid = (low+high)//2
            if nums[mid] == target:
                if (mid > low and nums[mid]==nums[mid-1]):
                    high = mid - 1
                else:
                    return mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return - 1

    
    def binarySearchRight(self, nums, low, high, target):
        while low<=high:
            mid = (low+high)//2
            if nums[mid] == target:
                if (mid < high and nums[mid]==nums[mid+1]):
                    low = mid + 1
                else:
                    return mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return - 1
    

nums = [5,7,7,8,8,10]
target = 8
print(Solution().searchRange(nums, target)) # Expected [3,4]