# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, was very near to solution but couldn't device a fully functional answer.
# Your code here along with comments explaining your approach
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        # if array is not rotated or array has only 1 element
        if len(nums) == 1 or nums[0] < nums[len(nums) - 1]:
            return nums[0]
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            # point of rotation between these two
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            
            # point of rotation between these two 
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            
            # if left half is sorted, point of rotation is on the right
            if nums[left] < nums[mid]:
                left = mid + 1
            
            # otherwise it is on the left
            else:
                right = mid - 1
        
