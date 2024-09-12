#Time Complexity: O(logn)
#Space Complexity: O(1)
#Successfully ran on leetcode

class Solution:
    def findMin(self, nums: list(int)) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1
        if nums[low]<nums[high]:
            return nums[low]
        while low<=high:
            mid = (low+high)//2
            if (mid==low or nums[mid]<nums[mid-1]) and (mid==high or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[mid]>nums[high]:
                low = mid+1
            else:
                high = mid-1
        return -1