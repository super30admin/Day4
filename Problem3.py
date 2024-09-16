#
# Time Complexity = O(log(n)) where n is the total number of characters
# Space Complexity = O(1)
# Works on Leetcode https://leetcode.com/problems/find-peak-element/
#
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        else:
            if nums[1] < nums[0]:
                return 0
            if nums[len(nums)-1] > nums[len(nums)-2]:
                return len(nums)-1
            l = 1
            r = len(nums)-2
            while(l <= r):
                mid = l+(r-l)//2
                if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                    return mid
                elif nums[mid] < nums[mid-1]:
                    r = mid-1
                else:
                    l = mid+1
