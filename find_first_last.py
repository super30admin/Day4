#Do the binary search on the left and keep shifting left until you find the leftmost. Same goes for right side.
class Solution(object):
    def searchRange(self, nums, target):
        if not nums or len(nums)==0:
            return [-1,-1]
        left=self.getLowerBound(nums,target)
        if left==-1:
            return [-1,-1]
        right=self.getUpperBound(nums,target,left)
        return [left,right]
    
    def getLowerBound(self, nums, target):
        ans=-1
        left=0
        right=len(nums)-1
        while(left<=right):
            mid=left+(right-left)//2
            if(nums[mid]==target):
                ans=mid
                right=mid-1
            elif(nums[mid]<target):
                left=mid+1
            else:
                right=mid-1
        return ans
    
    def getUpperBound(self, nums, target, leftBound):
        ans=-1
        left=leftBound
        right=len(nums)-1
        while(left<=right):
            mid=left+(right-left)//2
            if(nums[mid]==target):
                ans=mid
                left=mid+1
            elif(nums[mid]<target):
                left=mid+1
            else:
                right=mid-1
        return ans

#Time Complexity: 2*O(LogN)= O(LogN)
#Compiled on Leetcode