# Time Complexity : O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = nums[0]
        left, right = 0, len(nums) -1
        while left<=right:
            if nums[left] < nums[right]:
                result = min(result, nums[left])
                break
            mid = (left + right) // 2
            result = min(result, nums[mid])
            if nums[mid] >= nums[left]:
                left = mid +1
            else:
                right = mid - 1
        return result
            
        
         
        