# // Time Complexity : O(lg n) 
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
    
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            if nums[low] <= nums[high]: return nums[low]
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid+1] > nums[mid]):
                return nums[mid]
            elif nums[low] > nums[mid]: # unsorted side
                high = mid - 1
            else: # sorted or the unsorted side
                low = mid + 1
        return -1