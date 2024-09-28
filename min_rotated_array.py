#time complexity: O(logn)
#space complexity: O(1)

class Solution:
    def findMin(self, nums):
        self.low=0
        self.high=len(nums)-1
        min=-math.inf
        
        if(nums==None or len(nums)==0):
            return None
        if(nums[self.low]<nums[self.high]):
            return nums[self.low]
        
        while(self.low<=self.high):
            mid=(self.low+self.high)//2
            
            if(nums[self.low]<nums[self.high]):
                return nums[self.low]
            
            if((mid==0 or (nums[mid]<nums[mid-1])) and (mid==(len(nums)-1) or nums[mid]<nums[mid+1])):
                return nums[mid]
            
            elif(nums[self.low]<=nums[mid]):
                self.low=mid+1
                #moving to the unsorted part
            else:
                self.high=mid-1
                
        return None
        
        