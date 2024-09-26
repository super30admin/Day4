// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution:
    first=0
    def binaryFirst(self,nums,target):
        high=len(nums)-1
        low=0
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                if(mid==0 or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    high =mid-1
            elif (nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
    
    def binarySecond(self,nums,target):
        high=len(nums)-1
        low=first
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                if(mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    low =mid+1
            elif (nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if (nums==None or len(nums)==0):
            return [-1,-1]
        if(nums[0]>target or nums[len(nums)-1]<target):
            return [-1,-1]
        global first
        first= self.binaryFirst(nums,target)
        if(first==-1):
            return [-1,-1]
        second=self.binarySecond(nums,target)
        return [first,second]
    
    
