#Time Complexity : O(log N) beacuse of binary search, Twice we did binarty search 
#Space Complexity : I am using the iterative version of binary serach, so It's O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Your code here along with comments explaining your approach


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        start=0
        end=len(nums)-1
        result_first=-1
        
        while(start<=end):
            mid=(start+end)//2
            if nums[mid]==target:
                result_first=mid
                end=mid-1
            elif nums[mid]<target:
                start=mid+1
            elif nums[mid]>target:
                end=mid-1
        
        start=0
        end=len(nums)-1
        result_last=-1
        
        while(start<=end):
            mid=(start+end)//2
            if nums[mid]==target:
                result_last=mid
                start=mid+1
            elif nums[mid]<target:
                start=mid+1
            elif nums[mid]>target:
                end=mid-1
         
        return [result_first, result_last]
        