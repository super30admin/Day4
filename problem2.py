class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Binary Search
        # l, r, mid_point
        l=0
        r=len(nums)-1
        while l<r:
            mid=(l+r)//2
            if nums[l]<nums[r]:
                return nums[l]
            else:
                # Mid term value is greater than right pointer value and greater than left
                if nums[mid]>nums[mid+1]:
                    return nums[mid+1]
                if nums[mid-1]>nums[mid]:
                    return nums[mid]
                if nums[mid]>nums[l]:
                    l=mid+1
                else:
                    r=mid-1
        return nums[0]