# Time complexity = o(logn)
# Space complexity = o(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        
        while (low<=high):
            if(nums[low]<=nums[high]):
                return nums[low]
            mid = low +(high-low)/2
            if( nums[mid]<nums[mid-1]) and ( nums[mid] < nums[mid+1]):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low = mid +1
            else:
                high = mid-1