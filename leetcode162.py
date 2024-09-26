# Problem 3: (https://leetcode.com/problems/find-peak-element/)
# Time Complexity - O(logn)
# Space complexity - O(1)


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums)-1
        if(low == high):
            return low
        while(low <= high):
            mid = low + (high-low)//2
            if(nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]):
                return mid
            elif(nums[mid+1] > nums[mid]):
                low = mid+1
            else:
                high = mid-1
        return -1
