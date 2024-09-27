# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        if len(nums)==1:
            return nums[0]
        
        if nums[low] < nums[high]:
            return nums[low]
        
        while low <= high:
            mid = (low+high)//2
            
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            elif mid != len(nums)-1 and nums[mid] > nums[mid+1]:
                return nums[mid+1]    
            elif nums[low] < nums[mid]:
                low = mid + 1
            else:
                high = mid - 1                  