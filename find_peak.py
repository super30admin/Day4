#time complexity: O(logn)
#space compexity: O(1)
class Solution:
    def findPeakElement(self, nums):
        self.nums=nums
        if(nums==None or len(nums)==0):
            return -1
        self.low=0
        self.high=len(nums)-1
        
        while(self.low<=self.high):
            mid=(self.low+self.high)//2
            if((mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid
            elif(mid!=len(nums)-1 and nums[mid+1]>nums[mid]):
                self.low=mid+1
            else:
                self.high=mid-1
                
        return -1
            
        