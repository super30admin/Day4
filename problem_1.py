#  Time Complexity : o(log n)
#  Space Complexity : o(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

#  Your code here along with comments explaining your approach in three sentences only
#  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

#  I have used binary search to find the first and last index of the target element.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lower_bound = self.binarysearch(nums, target, True)
        if lower_bound == -1:
            return [-1, -1]

        upper_bound = self.binarysearch(nums, target, False)

        return [lower_bound, upper_bound] 
    
    def binarysearch(self, nums, target, isFirst):
        left = 0 
        right = len(nums) - 1

        while left <= right:
            mid = left + (right- left) // 2

            if nums[mid] == target:
                if isFirst:
                    if mid == left or nums[mid - 1] < target :
                        return mid
                    else:
                        right = mid - 1
                
                else:
                    if mid == right or nums[mid + 1] > target:
                        return mid
                    else:
                        left = mid + 1
            
            elif nums[mid] < target:
                left  = mid + 1
            
            else:
                right = mid - 1
        return -1 
        
                