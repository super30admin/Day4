# Time Complexity : O(log n) because twith every iteration the length of array in which we search reduces to half
# Space Complexity : O(1) constant space is required 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach : - Just apply normal binary search and if it matches target then 
# look for lower bound and upper bound until you don't get the lower bound value and upper bound value equal to target



class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0:
            return [-1, -1]
        elif len(nums) == 1 and nums[0] == target:
            return [0,0]
        first = 0
        last = len(nums)-1
        index = -1
        while first<= last:
            mid = (first+ last)//2
            if nums[mid] == target:
                index = mid
                upperBound = self.findUpperBound(nums, index)
                lowerBound = self.findLowerBound(nums, index)
                return [lowerBound, upperBound]
            elif nums[mid] < target:
                first = mid + 1
            elif nums[mid] > target:
                last = mid -1
        return [-1, -1]
        
    def findUpperBound(self, nums, index):
        n = len(nums)
        while index+1<n and nums[index] == nums[index+1]:
            index+=1
        return index
        
    def findLowerBound(self, nums,index):
        while index-1 >-1 and nums[index] == nums[index-1]:
            index-=1
        return index
        