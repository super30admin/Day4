# Time complexity - O(logn)
# Space complexity - O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = (low + high) //2
            
            if nums[mid] == nums[high]:
                high = high -1
            elif nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[high]
            
