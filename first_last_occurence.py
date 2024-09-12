#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution(object):
    
    
    def binsearch(self,nums,target,first):
        
        l = 0 
        h = len(nums) -1
        
        while(l<=h):
            
            mid = l+(h-l)//2
            if nums[mid] == target:
                if first:
                    if mid==0 or nums[mid-1] < nums[mid]:
                        return mid
                    else:
                        h = mid -1
                else:
                    if mid == len(nums)-1 or nums[mid+1]>nums[mid]:
                        return mid
                    else:
                        l = mid +1
     
            elif target < nums[mid]:
                h = mid -1
                
            else:
                l = mid + 1
        return -1
    
    
    
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums)==0:
            return [-1,-1]
        
        first = self.binsearch(nums,target,True)
        last = self.binsearch(nums,target,False)
        return [first,last]
    
    