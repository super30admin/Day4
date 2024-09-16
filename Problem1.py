'''
Time Complexity: O(log(n))
Space Complexity: O(1)
Run on Leetcode: YES
Problems: Handling base cases
'''
class Solution:      
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        low = 0
        high = len(nums) - 1
        target_flag = True
        first = -1
        last = -1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if target_flag:
                    last_low = mid
                    last_high = high
                    target_flag = False
                first = mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
            
        if first != -1:
            while last_low <= last_high:
                mid = last_low + (last_high - last_low)//2
                if nums[mid] == target:
                    last = mid
                    last_low = mid + 1
                else:
                    last_high = mid - 1
            return [first, last]
        return [-1,-1]