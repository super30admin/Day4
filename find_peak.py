class Solution(object):
    def findPeakElement(self, nums):
        #Time Complexity : Log(T)
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        r = len(nums)-1 #7 #5
        while l<r:
            mid = (l+r)//2   #3 #4
            if nums[mid]<nums[mid+1]:
                l=mid+1 #l=4 
            if nums[mid]>nums[mid+1]:
                r=mid
        return l
        
#[1,2,1,3,5,6,4]