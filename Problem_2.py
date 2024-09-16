# """
# Time complexity is O(log n)
# Space complexity is O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        low = 0
        high = len(nums)-1
        while(low<=high):
            if nums[low]<nums[high]:
                return nums[low]
            mid = low + (high-low)/2
            if(mid==0 or nums[mid]<nums[mid-1])and(mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low = mid+1
            else:
                high = mid-1
