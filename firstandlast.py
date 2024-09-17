# Time Complexity : log(N) + log(N), since we run 2 binary search for the same array
# Space Complexity : O(1) no extra memory allocated, only constant variables are used
# 34. Find First and Last Position of Element in Sorted Array

class Solution:
    def firstBinarySearch(self, nums, target):
            highestIndex = 0
            low, high = 0, len(nums)-1
            while low <= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid > highestIndex:
                        highestIndex = mid
                    if mid == 0 or nums[mid] > nums[mid-1]:
                        return mid, highestIndex
                    else:
                        high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid -1
            return - 1, highestIndex
        
    def secondBinarySearch(self, nums, target, startIndex):
        low, high = startIndex, len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return - 1
        
    def searchRange(self, nums, target):
        if len(nums) == 0 or (len(nums) == 1 and nums[0]!= target):
            return [-1, -1]
        
        first, highestIndex = self.firstBinarySearch(nums, target)
        if first == -1:
            return [-1,-1]
        startIndex = max(first,highestIndex)
        second = self.secondBinarySearch(nums, target, startIndex)
        return[first, second]

nums = [5,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,10]
target = 8
obj = Solution()
print(obj.searchRange(nums, target))