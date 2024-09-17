Time Complexity: O(log n)
Space complexity: O(n)
Did the problem run on Leetcode: Yes
Problem: 
Given an array of integers nums sorted in ascending order, find the starting 
and ending position of a given target value.Your algorithm's runtime complexity 
must be in the order of O(log n). If the target is not found in the array, return [-1, -1].
"""




class Solution:
    def binSearchRight(self,arr,target):
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                if (mid == len(arr) - 1 or arr[mid] < arr[mid + 1]):
                    return mid
                else:
                    low = mid + 1
            elif arr[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return -1
    
    def binSearchLeft(self,arr,target):
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                if (mid == 0 or arr[mid] > arr[mid - 1]):
                    return mid
                else:
                    high = mid - 1
            elif arr[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return -1

    def searchRange(self,nums,target):
        if len(nums) == 0:
            return [-1,-1]

        left = self.binSearchLeft(nums,target)
        right = self.binSearchRight(nums,target)

        return [left, right]
            
