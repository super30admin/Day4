# Time Complexity : O(logN)
# Space Complexity : O(1) as no extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took me a little while to understand the logic

class Solution:

    def findmin(self, nums) -> int:
        if len(nums) == 1:
            return nums[0]
        
        lo, hi = 0, len(nums) - 1
        
        # if array is not rotated
        if nums[hi] > nums[0]:
            return nums[0]
    
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            if nums[mid - 1] > nums[mid]:
                return nums[mid]
            
            if nums[mid] > nums[0]:
                lo = mid + 1
            else:
                hi = mid - 1
            

nums = [11,13,15,17]
obj = Solution()
print(obj.findmin(nums))