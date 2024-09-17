#implemented binary search method
# time complexity is o(logn)
# yes my code ran on leeet code

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def leftsearch(A,x):
            left=0
            right=len(A)-1
            while left<=right:
                mid=left+(right-left)//2
                if x>A[mid]:
                    left=mid+1
                else:
                    right=mid-1
            return left
        def rightsearch(A,x):
            left=0
            right=len(A)-1
            while left<=right:
                mid=left+(right-left)//2
                if x>=A[mid]:
                    left=mid+1
                else:
                    right=mid-1
            return right
        left,right=leftsearch(nums,target),rightsearch(nums,target)
        return (left,right) if left<=right else [-1,-1]
    
    
    
#2nd solution

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def left(nums,target): #left index
            low=0
            high=len(nums)-1
            left=-1
            while low<=high:
                mid=low+(high-low)//2
                if nums[mid]==target:
                    if (mid==0 or nums[mid-1]<target):
                        left =mid
                        break
                    else:
                         high=mid-1
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            return left
        
        
        def right(nums,target): #right index
            low=0
            high=len(nums)-1
            right=-1
            while low<=high:
                mid=low+(high-low)//2
                if nums[mid]==target:
                    if (mid==len(nums)-1 or nums[mid+1]>target):
                        right=mid
                        break
                    else:
                        low=mid+1
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            return right
        left=left(nums,target)
        right=right(nums,target)
        return [left,right] 
        
        
                    