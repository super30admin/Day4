# Time complexity: O(logn)
# Space complexity: O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1

        while left <= right:
            mid = left + (right-left)//2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif (mid !=0 and nums[mid-1] > nums[mid]):
                right = mid -1
            else:
                left = mid +1
        return