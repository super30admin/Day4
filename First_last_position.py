#time:O(logn)
#space:O(1)
#LeetCode: no, TimeLimit Exceeded
#Problem Faced:how to apply binary search
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def BinarySearchRight(nums,target):
            l,r=0,len(nums)-1
            while l<=r:
                mid=l+(r-l)//2
                if target > nums[mid]:
                    left=mid+1
                else:
                    right=mid-1
            return left
        def BinarySearchLeft(nums,target):
            l,r=0,len(nums)-1
            mid=l+(r-l)//2
            if target >=nums[mid]:
                l=mid+1
            else:
                r=mid-1
            return r
        l=BinarySearchLeft(nums,target)
        r=BinarySearchRight(nums,target)
        if l<=r:
            return [l,r]
        else:
            return [-1,-1]