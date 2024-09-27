class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = len(nums)-1
        index=0

        if(len(nums)==1):
            return 0


        while(l<=r):
            m = (l+r)/2

            if(m==len(nums)-1):
                return m

            elif(nums[m]>nums[m+1]):
                index= m
                r= m-1

            elif(nums[m]<nums[m+1]):
                l=m+1


        return index