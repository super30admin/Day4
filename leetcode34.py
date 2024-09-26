# Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Time complexity - O(logn) since we used binary search
# Successfully executed in 88ms - not very optimized solution.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        if(target < nums[0] or target > nums[-1]):
            return [-1, -1]

        def binaryFirst(nums, target):
            low = 0
            high = len(nums)-1
            while(low <= high):
                mid = low + (high-low)//2
                if(nums[mid] == target):
                    if(mid == low or nums[mid-1] < target):
                        return mid
                    elif(nums[mid-1] == target):
                        high = mid-1
                elif(nums[mid] < target):
                    low = mid+1
                else:
                    high = mid-1
            return -1

        def binarySecond(nums, target):
            low = 0
            high = len(nums)-1
            while(low <= high):
                mid = low + (high-low)//2
                if(nums[mid] == target):
                    if(mid == high or nums[mid+1] > target):
                        return mid
                    elif(nums[mid+1] == target):
                        low = mid+1
                elif(nums[mid] < target):
                    low = mid+1
                else:
                    high = mid-1
            return -1

        first = binaryFirst(nums, target)
        print("first ", first)
        second = binarySecond(nums, target)
        print("second ", second)

        return [first, second]
