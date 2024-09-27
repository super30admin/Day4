#Time Complexity: log(n)
#Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        start = 0
        end = len(nums) - 1

        while start <= end:

            mid = (start + end) // 2

            if ((mid == 0) or (nums[mid] > nums[mid-1])) and ((mid == len(nums) - 1) or (nums[mid] > nums[mid+1])) :
                return mid
            elif (mid==0 or nums[mid]>nums[mid-1]):
                start = mid + 1
            else:
                end = mid - 1

        return -1