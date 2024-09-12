#Time Complexity: O(logn)
#Space Complexity: O(1)
#Successfully ran on leetcode

class Solution:
    def searchRange(self, nums: list(int), target: int) -> list(int):
        if len(nums)==0:
            return [-1,-1]
        first = self.firstOccurence(nums,target)
        last = self.lastOccurence(nums,target)
        return [first,last]
    def firstOccurence(self,nums:list(int),target:int) -> int:
        self.low = 0
        self.high = len(nums)-1
        while self.low<=self.high:
            self.mid = (self.low+self.high)//2
            if target == nums[self.mid]:
                if nums[self.mid-1]!=target or self.mid==self.low:
                    return self.mid
                self.high = self.mid-1
            elif target > nums[self.mid]:
                self.low = self.mid + 1
            else:
                self.high = self.mid-1
        return -1
    def lastOccurence(self,nums:list(int),target:int) -> int:
        self.low = 0
        self.high = len(nums)-1
        while self.low<=self.high:
            self.mid = (self.low+self.high)//2
            if target == nums[self.mid]:
                if self.mid==self.high or nums[self.mid+1]!=target:
                    return self.mid
                self.low = self.mid+1
            elif target > nums[self.mid]:
                self.low = self.mid + 1
            else:
                self.high = self.mid-1
        return -1