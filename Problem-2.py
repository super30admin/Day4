# 153. Find Minimum in Rotated Sorted Array
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def findMin(self, nums):
        if not nums:
            return -1
        if len(nums) == 1:
            return nums[0]

        start = 0
        end = len(nums) - 1

        if nums[start] < nums[end]:
            return nums[start]
        if nums[end] < nums[end - 1]:
            return nums[end]

        while start <= end:
            mid = (start + end)//2

            if start == end:
                return nums[mid]
            
            if mid > 0 and mid < len(nums) -1:
                if nums[mid] < nums[end]:
                    end = mid
                elif nums[mid] > nums[end]:
                    start = mid + 1
                
            elif mid == 0:
                if nums[mid] < nums[len(nums)-1]:
                    return mid
                else:
                    start = mid + 1
        return nums[mid]

obj = Solution()
print(obj.findMin([3,4,5,6,1,2]))
print(obj.findMin([5,1,2]))
print(obj.findMin([1,2,3,4]))
print(obj.findMin([11,13,15,17]))