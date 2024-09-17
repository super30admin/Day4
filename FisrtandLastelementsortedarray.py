# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        if not nums or len(nums) == 0:
            return [-1,-1]
        
        if target < nums[0] or target > nums[-1]:
            return [-1,-1]
        
        firstOccurance = self.BinarySearchFirst(nums,target)
        if firstOccurance == -1:
            return [-1,-1]
        LastOccurance = self.BinarySearchLast(nums,target)
        return [firstOccurance,LastOccurance]
    
    def BinarySearchFirst(self,nums,target):
        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low +(high-low)//2
            if(target == nums[mid]):
                if mid == low or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid-1
            elif(target < nums[mid]):
                high = mid -1
            else:
                low = mid+1
        return -1

    def BinarySearchLast(self, nums,target):
        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low +(high-low)//2
            if(target == nums[mid]):
                if mid == high or nums[mid+1] > nums[mid]:
                    return mid
                else:
                    low = mid+1
            elif( target < nums[mid]):
                high = mid -1
            else:
                low = mid+1
        return -1

        