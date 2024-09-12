# // Time Complexity : O(LogN)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

# Your algorithm's runtime complexity must be in the order of O(log n).

# If the target is not found in the array, return [-1, -1].

# Example 1:

# Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:

# Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]


class Solution:
    def binarySearchFirst(self,nums, target):
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if(nums[mid]==target):
                if mid == 0 or (nums[mid-1]) != nums[mid]:
                    return mid
                else:
                    #keep moving left
                    high = mid -1
            elif nums[mid] > target:
                high = mid -1
                
            else:
                low = mid + 1
                
        return -1
        
        
    def binarySearchLast(self,nums, target, first):
        low = first
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if(nums[mid]==target):
                if (mid == len(nums) -1 ) or (nums[mid+1]) != nums[mid]:
                    return mid
                #keep moving right
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid -1
                
            else:
                low = mid + 1
                
        return -1
        
                    
                    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == [] and len(nums) == 0:
            return [-1,-1]

        if (nums[0]> target) or (nums[len(nums)-1] < target):
            return[-1,-1]
        # search first position of target
        first = self.binarySearchFirst(nums, target)
        
        #if the search cannot find element at first BS then no need to search
        if first == -1:
            return [-1,-1]
        
        # search last position of target
        last =  self.binarySearchLast(nums, target, first)
        return[first,last]
    
            
        