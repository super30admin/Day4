# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        startPos = self.getStartPos(nums,target)
        endPos = self.getEndPos(nums,target,startPos)
        return [startPos,endPos]
    def getStartPos(self,nums,target):
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (low + high)//2
            if nums[mid] == target:
                if mid !=0 and nums[mid-1] == target:
                    high = mid-1
                else:
                    return mid
            elif nums[mid] >target:
                high = mid -1
            else:
                low = mid + 1
        return -1
    
    def getEndPos(self,nums,target,start):
        if start == -1 : return -1
        low = start
        high = len(nums)-1
        while(low <= high):
            mid = (low + high)//2
            if nums[mid] == target:
                if mid !=len(nums)-1 and nums[mid+1] == target:
                    low = mid+1
                else:
                    return mid
            elif nums[mid] >target:
                high = mid -1
            else:
                low = mid + 1
        return -1