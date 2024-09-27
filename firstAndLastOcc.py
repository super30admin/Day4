#Leetcode problem: 34
#Approach: do binary search in left and right part
class Solution:
    def leftBS(self,nums,target):#Search in left part
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==0 or nums[mid-1]!=target:
                    return mid
                else:
                    high=mid-1
            elif target<nums[mid]:
                high=mid-1
            else:
                low=mid+1
        return -1
    
    def rightBS(self,nums,target):#search in right part
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==len(mid)-1 or nums[mid+1]!=target:
                    return mid
                else:
                    low=mid+1
            elif target<nums[mid]:
                high=mid-1
            else:
                low=mid+1
        return -1

    def searchRange(self, nums, target):
        if len(nums)==0:
            return([-1,-1])
        if target<nums[0] or target>nums[len(nums)-1]:
            return ([-1,-1])
        
        first=self.leftBS(nums,target)
        last=self.rightBS(nums,target)
        return([first,last])

#TC: O(log n)
#SC: O(1)
