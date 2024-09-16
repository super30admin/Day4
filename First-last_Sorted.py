#TC : O(logN)
#SC: O(1)
#Approach: Binary Search

class Solution:
    def getStartPos(self, nums, target) -> int:
        start, end = 0, len(nums)-1
        
        while(start<=end):
            mid = (end-start)//2+start
            
            if nums[mid]==target:
                # mid is start pos
                if mid==0 or nums[mid-1]!= target:
                    return mid
                else:
                    end = mid - 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1
                    
    def getEndPos(self, nums, target, start) -> int:
        end = len(nums)-1
        if start == -1:
            return -1
            
        while(start<=end):
            mid = (end-start)//2+start
                
            if nums[mid] == target:
                #mid is end pos
                if mid ==len(nums)-1 or nums[mid+1] != target:
                    return mid
                else:
                    start = mid + 1
            elif nums[mid] < target:
                start = mid+1
            else:
                end = mid - 1
        return -1
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        startPos = self.getStartPos(nums, target)
        endPos = self.getEndPos(nums, target, startPos)
        return [startPos, endPos]
