class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #divide and conquer
        #O(logN)
        #O(1)
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+((h-l)//2)
            #if mid is greater than its neighbours plus satisfying the bounds, got answer
            if (mid==l or nums[mid]>nums[mid-1]) and (mid==h or nums[mid]>nums[mid+1]):
                print("m")
                return mid
            #if peak is to right of mid, start BS in right half
            elif nums[mid]<nums[mid+1]:
                print("l")
                l=mid+1
            #else BS in left half
            else :
                print("h")
                h=mid-1
        return -1
                
                
    
        
        