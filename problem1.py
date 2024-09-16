'''
Find First and Last Position of Element in Sorted Array
TIME COMPLEXITY: O(logN)
SPACE COMPLEXITY: O(1)
Yes, it passed all the test cases in the leetcode
Any problems faced? A bit, yes.
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        low = 0
        high = n-1
        low_target = -1
        high_target = -1
        
        if n == 0:
            return [-1, -1]
        
        # first occurence
        while low <= high:
            mid = (low+high) // 2
            if target == nums[mid]:
                low_target = mid
                high = mid-1
            elif target <= nums[mid]:
                high = mid -1
            else:
                low = mid+1
        
        # if nums[mid] != target:
        #     return [-1, -1]
        # res.append(mid)
        
        
        # last occurence
        low = 0
        high = n-1
        
        while low <= high:
            mid = (low+high) // 2
            if target == nums[mid]:
                high_target = mid
                low = mid+1
            elif target <= nums[mid]:
                high = mid -1
            else:
                low = mid+1
                
        
        return [low_target, high_target]
