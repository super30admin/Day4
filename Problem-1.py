class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #Time-O(n)
        #Space-O(n)
        if(len(nums)==0 or nums==None):
            return [-1,-1]
        if(nums[0]>target):
            return [-1,-1]
        frst = self.BinarySearchFirst(nums,target)
        last = self.BinarySearchLast(nums,target)
        return [frst,last]
        
    def BinarySearchFirst(self,nums,target):
        low = 0
        high= len(nums)-1
        while(low<=high):
            mid = low+(high-low)//2
            if(nums[mid]==target):
                if((mid==0) or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid-1
            elif(nums[mid]<target):
                low=mid+1
            elif(nums[mid]>target):
                high=mid-1
        return -1
    
    def BinarySearchLast(self,nums,target):
        low = 0
        high= len(nums)-1
        while(low<=high):
            mid = low+(high-low)//2
            if(nums[mid]==target):
                if((mid==len(nums)-1) or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid+1
            elif(nums[mid]<target):
                low=mid+1
            elif(nums[mid]>target):
                high=mid-1
            
        return -1
                    
        