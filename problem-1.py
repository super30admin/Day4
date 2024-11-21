#Time complexity O(log n) and space complexity O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums) - 1
        first = last = -1
        
        if nums is None and target == 0:
            return [-1,-1]
        
        while l <= r:
            m = l + (r-l) // 2
            if nums[m] == target:
                first = m
                r = m - 1
            elif nums[m] > target:
                r = m - 1
            elif nums[m] < target:
                l = m + 1
                
        
        
        l, r = 0, len(nums) - 1
        while l <= r:
            m = l +(r-l) // 2
            if nums[m] == target:
                last = m
                l = m + 1
            elif nums[m] > target:
                r = m - 1
            elif nums[m] < target:
                l = m + 1
                
        return[first,last]
