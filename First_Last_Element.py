"""
Time Complexity: O(log n)
Space complexity: O(n)
Did the problem run on Leetcode?: Yes

Problem: 
Given an array of integers nums sorted in ascending order, find the starting 
and ending position of a given target value.Your algorithm's runtime complexity 
must be in the order of O(log n). If the target is not found in the array, return [-1, -1].
"""

class Solution:
    def binSearchRight(self, arr, target):
        l = 0
        h = len(arr) - 1
        
        while l <= h:
            mid = l + (h - l) // 2
            if arr[mid] == target:
                if mid == (len(arr) - 1) or arr[mid] < arr[mid + 1]:
                    return mid
                else:
                    l = mid + 1
            elif arr[mid] > target:
                h = mid - 1
            else:
                l = mid + 1
        
        return -1
    
    def binSearchLeft(self, arr, target):
        l = 0
        h = len(arr) - 1
        
        while l <= h:
            mid = l + (h - l) // 2
            if arr[mid] == target:
                if mid == 0 or arr[mid] > arr[mid - 1]:
                    return mid
                else:
                    h = mid - 1
            elif arr[mid] > target:
                h = mid - 1
            else:
                l = mid + 1
        
        return -1
    
    def searchRange(self, nums, target):
        if len(nums) == 0:
            return [-1,-1]
        
        left, right = self.binSearchLeft(nums, target), self.binSearchRight(nums, target)
        
        return [left, right]

s = Solution()
print(s.searchRange([5,7,7,8,8,10], 7))
print(s.searchRange([2,2], 2))
print(s.searchRange([3, 5], 1))




