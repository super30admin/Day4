# Time Complexity: O(logn)
# Space Complexity: O(1)

# This code was passsed on LC: Yes
# Problems: No


class Solution(object):
    def findMin(self, nums):
        
        if len(nums) == 1:
            return nums[0]
        l = 0
        r = len(nums)-1
        
        while l<=r:
            mid = (l+r)//2
            #print(mid)
            # Return that element which is after or before the peak element.
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
            if nums[mid]<nums[mid-1]:
                return nums[mid]
            
            if nums[l]<=nums[mid]:
                l = mid+1
            else:
                r = mid-1