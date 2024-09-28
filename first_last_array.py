#time complexity: O(logn)
#space complexity: O(1)

class Solution:
    def searchRange(self, nums, target):
        self.nums=nums
        self.target=target
        
        if(nums==None or len(nums)==0):
            return [-1,-1]
        
    
        def get_first(nums, target):
            self.low=0
            self.nums=nums
            self.high=len(nums)-1
            self.target=target
                        
            while(self.low<=self.high):
                mid=(self.low+self.high)//2
                if(nums[mid]==target):
                    if(mid==0 or nums[mid-1]<nums[mid]):
                        return mid
                    else:
                        self.high=mid-1
                elif(target<nums[mid]):
                    self.high=mid-1
                else:
                    self.low=mid+1
                    
            return -1
                    
        def get_last(nums, target):
            self.low=0
            self.nums=nums
            self.high=len(nums)-1
            self.target=target
                        
            while(self.low<=self.high):
                mid=(self.low+self.high)//2
                if(nums[mid]==target):
                    if(mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                        return mid
                    else:
                        self.low=mid+1
                elif(target<nums[mid]):
                    self.high=mid-1
                else:
                    self.low=mid+1
                    
            return -1
        
        first=get_first(nums, target)
        last=get_last(nums, target)
        
        return [first, last]
                    