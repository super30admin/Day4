class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def bs(nums,target,l,r):
            if l>r:
                return [-1,-1]
            mid=(l+r)//2
            if nums[mid]==target:
                startPointer=mid
                while startPointer-1>=0 and nums[startPointer-1]==target:
                    startPointer-=1
                endPointer=mid
                while endPointer+1<len(nums) and nums[endPointer+1]==target:
                    endPointer+=1
                return [startPointer,endPointer]
            elif nums[mid]<target:
                return bs(nums,target,mid+1,r)
            else:
                return bs(nums,target,l,mid-1)
        return bs(nums,target,0,len(nums)-1)