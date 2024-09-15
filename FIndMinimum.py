//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO




class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if  (len(nums)==0):
            return -1
        low = 0
        high = len(nums ) -1
        if(nums[low]<=nums[high]):
            return nums[low]
        while(low<=high):
            mid = low + high - low /2
            # if(nums[low]<=nums[high]):
            #     return nums[low]
            if ((mid == 0 or nums[mid] < nums [mid-1] )and (mid == len(nums) -1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low = mid + 1
            else:
                high = mid -1
        return -1
                
#         import math
        
#         x= float('inf')
#         for i in nums:
#             x=min(x,i)
#         return x


    
    