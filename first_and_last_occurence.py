#find_minimum_rotated_sorted_array
#time complexity: O(logN)
#space complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = []
        if nums == None:
            return [-1, -1]
        else:
            first_occur = self.find_first(nums, target)
            last_occur = self.find_last(nums, target, first_occur)
            return [first_occur, last_occur]
        
    
    def find_first(self, nums, target):
        left = 0
        right = len(nums) - 1
        first_index = -1
        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target:
                right = mid - 1
                first_index = mid
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return first_index
    
    def find_last(self, nums, target, left):
        if left == -1:
            left = 0
        right = len(nums) - 1
        last_index = -1
        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target:
                left = mid + 1
                last_index = mid
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1

        return last_index
                
                