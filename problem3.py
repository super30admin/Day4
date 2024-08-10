class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ## Approach
        ## 2 pointers:l and r
        ## initialize mid in each iteration
        ## check the value of mid-1 and mid+1 -> if it is less than mid return mid
        l=0
        r=len(nums)-1
        while l<r:
            mid=(l+r)//2
            lower_bound_val,upper_bound_val=-float('inf'),-float('inf')
            if mid-1>=0:
                lower_bound_val=nums[mid-1]
            if mid+1<=len(nums)-1:
                upper_bound_val=nums[mid+1]
            if nums[mid]>lower_bound_val and nums[mid]>upper_bound_val:
                return mid
            if nums[mid]<lower_bound_val and nums[mid]>upper_bound_val:
                r=mid
            else:
                l=mid+1
        return l