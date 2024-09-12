'''
-- Passed test cases on LeetCode
'''
class Solution:
    #O(logn) - time complexity ; O(1) - space complexity
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = self.bound(nums, target, True)
        if low == -1:
            return [-1, -1]
        
        high = self.bound(nums, target, False)
        
        return [low, high]
    
    def bound(self, nums, target, first):
        n = len(nums)
        start = 0
        end = n - 1
        while start <= end:
            mid = (start + end)//2
            
            if nums[mid] == target:
                if first:
                    if mid == start or nums[mid - 1]< target:
                        return mid
                    end = mid - 1
                else:
                    if mid == end or nums[mid + 1] > target:
                        return mid
                    start = mid + 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1 
        
        
        '''
        if len(nums) == 0:
            return [-1, -1]
        c = 0
        for i in range(len(nums)):
            if nums[i] != target:
                c += 1
            if c == len(nums):
                return [-1, -1]
            
        res = []
        
        for i in range(len(nums)):
            if nums[i] == target:
                res.append(i)
        return (res[0], res[-1])
        ''' 
        
        
        