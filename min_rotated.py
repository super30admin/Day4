class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        :time complexity: O(logn)
        :space complexity: O(1)
        """
        
        low = 0
        high=len(nums)-1
        n=len(nums)
        
        if n==0 or nums==None: 
            return -1
        if n==1: 
            return nums[-1]
        if high < low: 
            return nums[0]
        
        while low<=high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low+ (high-low)//2  # avoid integer overflow. Not necessary in python
            # check if first or last element is minimum
            if (mid ==0 or nums[mid]<nums[mid-1]) and (mid==n-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            # right check
            elif nums[low]<=nums[mid]:
                low=mid+1
            # left check
            else:
                high=mid-1
        return 
            
            