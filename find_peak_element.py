
# Time complexity : O(logn)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high-low) //2
#             if mid is the target
            if ((mid == 0 or nums[mid-1] <= nums[mid]) and (mid == len(nums)-1 or nums[mid+1] <= nums[mid])):
                break
#             if the target is on the left side    
            elif (mid > 0 and nums[mid-1] > nums[mid]):
                high = mid - 1
#       if the target is on the right side
            else:
                low = mid + 1
#       return mid as we will be left with one number in the end
        return mid
