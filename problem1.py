# Time Complexity : O(log(n))
# Space Complexity : O(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach

class Solution:

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch(nums, target):
            if not nums:
                return -1
            
            l, r = 0, len(nums)-1    
            mid = (l + r) // 2
            
            while l <= r:
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1
                
                mid = (l + r) // 2
                
            return -1
        
    
        idx = binarySearch(nums, target)
        if idx == -1:
            return [-1, -1]
        
        l = r = idx
        while (l-1 >= 0 and nums[l-1] == target) or (r+1 < len(nums) and nums[r+1] == target):
            if (l-1 >= 0 and nums[l-1] == target):
                l -= 1
            if (r+1 < len(nums) and nums[r+1] == target):
                r += 1
        return [l, r]