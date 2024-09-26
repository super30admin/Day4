# Find peak element(https://leetcode.com/problems/find-peak-element/)
# Time complexity: O(log(n)); n=no of elements in array 
# Space complexity: O(1); 
# Did this code successfully run on Leetcode : Yes
# Approach: Binary search



class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return -1
        
        low = 0 
        high = len(nums)-1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            # We encountered our peak
            if (mid == high or nums[mid] > nums[mid+1]) and (mid == low or nums[mid] > nums[mid-1]):
                return mid
            
            # Local falling slope. Means peak is more towards left
            if nums[mid] > nums[mid+1]:
                high = mid - 1
                
            # Local rising slope. Means peak is more towards right
            else:
                low = mid + 1
                
        return -1
                
                        
            
            