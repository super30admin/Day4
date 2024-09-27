# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    
    # to get sart position
    def getStartPos(self, nums, target):
        s, e = 0, len(nums) - 1
        
        while(s<=e):
            
            m = s+ (e-s) // 2
            
            # if target is mid and previous index of mid is not target
            if nums[m] == target and nums[m-1]!=target and m>0:
                return m
            
            if nums[m]<target:
                s = m + 1
            else:
                e = m - 1
          
    # get end pos, give startpos as parameter
    def getEndPos(self, nums, target, startpos):
        s, e = startpos, len(nums) -1    
        
        while(s<=e):
            m = s + (e-s) // 2
            
            # if target is mid and nexr index of mid is not target
            if nums[m] == target and nums[m+1]!=target and m<len(nums)-1:
                return m
            
            if nums[m]< target:
                s = m + 1
                
            else:
                e = m - 1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        startpos = self.getStartPos(nums, target)
        endpos = self.getEndPos(nums, target, startpos)
        return startpos,endpos