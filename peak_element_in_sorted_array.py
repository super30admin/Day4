class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + (high - low) // 2

            print(mid)

            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] < nums[mid]):
                return mid

            elif (mid < len(nums) and nums[mid + 1] > nums[mid]):
                low = mid + 1

            else:
                high = mid - 1

        return -1



# Note:
# Time complexity O(n)
# Space complexity O(1)



