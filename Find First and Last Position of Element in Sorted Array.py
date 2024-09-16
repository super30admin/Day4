# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


def BSForFirstOccurance(nums:List[int], target: int) -> List[int]:
        l=0
        r=len(nums)-1
    
        index =-1
        while(l<=r):
            mid = l+(r-l)//2
            
            if(nums[mid]==target):
                if mid ==0 or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    r=mid-1
            elif target< nums[mid]:
                r=mid-1
            else:
                l = mid+1
        return index
    
def BSForLastOccurance(nums:List[int], target: int) -> List[int]:
        l=0
        r=len(nums)-1
    
        index =-1
        while(l<=r):
            mid = l+(r-l)//2
            
            if(nums[mid]==target):
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    l=mid+1
            elif target< nums[mid]:
                r=mid-1
            else:
                l = mid+1
        return index       
        
class Solution:

    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if(nums==0 or len(nums)==0):
            return [-1,-1]
        if(target > nums[len(nums)-1] or nums[0]>target):
            return [-1,-1]
        
        first = BSForFirstOccurance(nums,target)
        if first ==-1 :
            return [-1,-1]
        second = BSForLastOccurance(nums,target)
        return [first,second]
    
    
    