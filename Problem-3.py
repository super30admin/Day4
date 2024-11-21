# 162. Find Peak Element
# https://leetcode.com/problems/find-peak-element/

# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums) -> int:
        start = 0
        end = len(nums) - 1
        
        if len(nums) == 1:
            return len(nums) - 1        
        
        
        while start <= end:
            mid = (start + end)//2
            
            if start == end:
                return mid
            
            if nums[mid] > nums[mid -1] and nums[mid] > nums[mid +1]:
                return mid
            
            if nums[mid] > nums[mid+1]:
                end = mid - 1
            else:
                start = mid + 1
        return mid