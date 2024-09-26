#Time complexity - O(logn) where n = len(nums)
#Space complexity - O(1)

#To find the peak, we need the element which is greater than both of its immediate neighbours.
#iIf middle is greater than right element, peak is in left half
#If middle is less than right element, peak is in right half
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l,r = 0,len(nums)-1
        while l<r:
            mid = l + (r-l)//2
            if nums[mid-1]<nums[mid] and nums[mid]>nums[mid+1]:
                return mid
            elif nums[mid]>nums[mid+1]:
                r = mid -1
            else:
                l = mid +1
        return l if nums[l]>=nums[r] else r