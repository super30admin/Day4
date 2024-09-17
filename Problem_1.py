# Search in roatated array
# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed the solution from class
# // Your code here along with comments explaining your approach

class Solution:
    def binarySearchFirst(self, nums, target):
        low, high = 0, len(nums)-1
        while(low <= high):
            mid = low + (high - low)//2
            if( nums[mid] == target):
                #if the mid is actually  the very first index of target
                if (mid == 0 or nums[mid-1] != nums[mid]):
                    return mid
                else:
                    high = mid - 1
            elif (nums[mid]> target):
                high = mid -1
                #this keeps moving left to find the first index
            else:
                low = mid + 1
        return -1
    def binarySearchLast(self, nums, target):
        low, high = 0, len(nums)-1
        while(low <= high):
            mid = low + (high - low)//2
            if( nums[mid] == target):
                #if the mid is actually  the very last index of target
                if (mid == len(nums)-1 or nums[mid+1] != nums[mid]):
                    return mid
                else:
                    low = mid + 1
            elif (nums[mid]> target):
                high = mid -1
                #this keeps moving right to find the last index
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums, target):
        if (nums == None or len(nums) == 0): return [-1, -1]
        if (nums[0] > target or nums[-1] < target): return [-1, -1]
        first = self.binarySearchFirst(nums, target)
        if (first == -1): return [-1, -1]
        last = self.binarySearchLast(nums, target)
        return [first, last]
        