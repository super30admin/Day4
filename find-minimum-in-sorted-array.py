
#  Time complexity 

 0(logn)

# Space complexity 

0(1)



# it worked succesfully on leetcode


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or nums is None:
            return -1
        low ,high = 0, len(nums)-1
        if nums[low]< nums[high]:
            return nums[low]
        while (low<=high):
            if nums[low]< nums[high]:
                return nums[low]
            mid = low + (high-low)/2
            if (mid ==0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[low]<=nums[mid]:
                low = mid+1
            else:
                high = mid-1
