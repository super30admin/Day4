# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : nope

from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or not nums: return -1
        low, high = 0, len(nums) - 1
        while(low <= high):
            mid = (low + high) // 2
            # if mid is first element then we don't need to check it with mid - 1
            # if mid is last element then we don't need to check it with mid + 1
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and 
                (mid == (len(nums) - 1) or nums[mid] > nums[mid + 1])):
                return mid
            elif mid != 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            else: low = mid + 1
            
            
sol = Solution()
print(sol.findPeakElement([1,2,3,1]))