class Solution(object):
    def findPeakElement(self, nums):

        low = 0
        high = len(nums) - 1
        while low < high:
            mid = (high + low) //2
            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid + 1
        return low
#time complexity : O(logn)
#space complexity ;O(1)