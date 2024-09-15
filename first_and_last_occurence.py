# Time Complexity: O(logn)
# Space Complexity: O(1)
# Code ran successfully on Leetcode
# 2 binary search approach
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        # Sorted Array
        if target < nums[0] or target > nums[len(nums)-1]:
            return [-1,-1]
        # if target element is not found, target element not present
        first = self.binarySearchLeft(nums, target)
        if first == -1:
            return [-1,-1]
        # second binary search
        second = self.binarySearchRight(nums, target)
        return [first, second]
    
    
    # First Binary Search
    def binarySearchLeft(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                # Checking for 1st occurence and 
                # checking for array out of bound
                if mid == 0 or nums[mid-1] < target:
                    return mid
                else:
                    high = mid - 1
            # general binary search stuff
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def binarySearchRight(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low)//2
            if target == nums[mid]:
                # check or array out of bound 
                # since sorted array
                if mid == len(nums)-1 or nums[mid+1] > target:
                    return mid
                else:
                    low = mid + 1
            # General binary Search Stuff
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1