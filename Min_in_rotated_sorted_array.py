'''
Time Complexity - O(logn)
Space Complexity - O(1)
'''


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while(low <= high):
            mid = low+(high-low)//2
            if nums[low] <= nums[high]:
                return nums[low]
            if nums[mid] >= nums[low]:
                low = mid+1
            else:
                high = mid
