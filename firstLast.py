# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def returnBound(self,nums,lower,target):
        start,end = 0,len(nums)-1
        while start <= end:
            mid = (start+end)//2
            if nums[mid] == target:
                if lower:
                    #lower bound
                    #the position at which number changes or mid = start for first index
                    if mid == start or nums[mid-1] < target:
                        return mid
                    end = mid-1
                else:
                    #upper bound
                    #the position at which number changes or mid = last for last index
                    if mid == end or nums[mid+1] > target:
                        return mid
                    start= mid+1
            elif nums[mid] > target:
                end = mid-1
            else:
                start = mid+1
            
        return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #get upper and lower bound by switching the lower flag
        lowerBound = self.returnBound(nums,True,target)
        upperBound = self.returnBound(nums,False,target)
        if lowerBound == -1:
            return [-1,-1]
        return [lowerBound,upperBound]  
