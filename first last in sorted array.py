# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Binary search
# We run Binary search twise
# first, we find first appaearance of target
# second, we find last appearance of the target
# For first appearance, we check if nums[mid] > nums[mid-1]
# if true return mid
# if false : right = mid-1

class Solution:
    
    def leftIndex(self, nums: List[int], target: int):
        left = 0 
        right = len(nums)-1
        mid = (right+left)//2

        while left<=right:
            if nums[mid]== target:
                if mid == left or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    right = mid - 1 
                    mid = (right+left)//2
                
            elif nums[mid] > target:
                right = mid - 1 
                mid = (right+left)//2
            
            elif nums[mid] < target:
                left = mid + 1 
                mid = (right+left)//2
        return -1
                
    def rightIndex(self, nums: List[int], target: int):
        left = 0 
        right = len(nums)-1
        mid = (right+left)//2

        while left<=right:
            if nums[mid]== target:
                if mid == right or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    left = mid + 1 
                    mid = (right+left)//2
                
            elif nums[mid] > target:
                right = mid - 1 
                mid = (right+left)//2
            
            elif nums[mid] < target:
                left = mid + 1 
                mid = (right+left)//2
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums)==0: 
            return [-1,-1]
        left = self.leftIndex(nums, target)
        right = self.rightIndex(nums, target)
        return [left, right]

                
        