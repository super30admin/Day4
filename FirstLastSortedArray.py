# Time complexity: O(log(n))
# Space Complexity: O(1) 
# Approach: We call 2 methods for searching first and last occurence.
# For first occurence, we check if nums[mid] == target, if so, nums[mid]> nums[mid-1] means it should be the first and return that index, else it must be last or
# some other ocurrence so decrement high pointer. If target is > nums[mid], means we need to search other sublist (low = mid+1) else high = mid-1, and we haven't 
# reach to any occurence yet. 
# And vice-versa for last occurence. If don't find that element only return -1.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0:
            return [-1,-1]
        first = self.binarySearchFirst(nums, target)
        last = self.binarySearchLast(nums, target)
        return [first,last]
    
    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) //2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        
        
    def binarySearchLast(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) //2
            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1