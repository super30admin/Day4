
# time complexity = O(logn)
# space complexity = O(1)
# Tested on leetcode
# Use bianry search to find the first and last index for target element
# Finding both first and last element in one lass is possible in O(n) time
# split the search and find the first index in one pass
# and then the last index in another pass

class Solution:
    '''Find the first index of the target element O(logn)''' 
    def binarySearchFirst(self, nums, low, high, target):
        while (low <= high):
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if mid == 0 or nums[mid] != nums[mid - 1]:
                    return mid
                high = mid - 1   
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    '''Find the last index of the target element O(logn)'''
    def binarySearchLast(self, nums, low, high, target):
        while (low <= high):
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if mid == len(nums)-1 or nums[mid] != nums[mid + 1]:
                    return mid
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1 
    

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or nums[0] > target or nums[-1] < target:
            return [-1, -1]
        first = self.binarySearchFirst(nums, 0, len(nums)-1, target)
        print(first)
        if first >= 0:
            last = self.binarySearchLast(nums, first, len(nums)-1, target)
            return [first, last]
        return [-1,-1]
