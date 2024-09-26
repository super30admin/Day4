# Time Complexity : O(logn)
# Space COmplexity : O(1)
# Approach to solve this problem:

class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]                         
        l, r = 0, len(nums) - 1                # 2 pointers at left and right most value
        
        while l <= r:                          
            if nums[l] < nums[r]:              
                res = min(res, nums[l])        # Update our result
                break
                
            m = (l + r) // 2                   # If not sorted
            res = min(res, nums[m])
            if nums[m] >= nums[l]:             # Is it a part of sorted portion
                l = m + 1
            else:
                r = m - 1
        return res