# Find First and Last Position of Element in Sorted Array
'''
Leetcode all test cases passed: Yes
Solution:
    Space Complexity: O(1)
    bisect_left(self,arr,target):
        Let n be the length of the array
        Time Complexity: O(log n)
    bisect_right(self,arr,target):
        Let n be the length of the array
        Time Complexity: O(log n)
    searchRange(self, nums, target):
        Time Complexity: time to fetch left index + 
                         time to fetch right index = O(log n) + O(log n) = O(2 log n) = O(log n)
    
'''


class Solution:

    def bisect_left(self, arr, target):
        l = 0
        r = len(arr)
        while l < r:
            mid = l + ((r - l) // 2)
            if arr[mid] < target:
                l = mid + 1
            else:
                r = mid
        return l

    def bisect_right(self, arr, target):
        l = 0
        r = len(arr)
        while l < r:
            mid = l + ((r - l) // 2)
            if arr[mid] <= target:
                l = mid + 1
            else:
                r = mid
        return l

    def searchRange(self, nums, target):
        left_index = self.bisect_left(nums, target)
        if (left_index < len(nums) and nums[left_index] == target) or (left_index + 1 < len(nums) and nums[left_index + 1] == target):
            right_index = self.bisect_right(nums[left_index:], target)
            return [left_index, left_index + right_index - 1]
        return [-1, -1]
