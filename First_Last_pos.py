# Time complexity : O(log n)
# Space complexity : O(1)
# Leetcode : Solved and sibmiteed

class Solution:
  
    # main function which does two calls, one for to get the index for the first element and then another one, for the last element
    # If the first element is not found, then return -1 for both the indexes.
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.BinarySearch(nums, target, True)
        
        if first == -1:
            return [-1,-1]
        
        last = self.BinarySearch(nums, target, False)
        
        return [first, last]
        
        
        
        
        
    # This is the basic binary search function, where check for the index of the target
    # For the first occurence of element, we move towards the left as much such that we reach an element which is less than the target, return its index
    # for the last occurence, we move towards right, and check for element which is greater than the target element and return its index
    def BinarySearch(self, nums: List[int], target: int, isFirst: bool) -> int:
        low = 0
        high = len(nums)-1
        
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                if isFirst:
                    if low == mid or nums[mid-1] < target:
                        return mid
                    high = mid - 1
                else:
                    if high == mid or nums[mid+1] > target:
                        return mid
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
