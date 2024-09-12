class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        # [1,2,1,3,5,6,4]
        while (low <= high):  # l: 0, h: 6
            mid = low + (high - low) // 2  # m:3

            if ((mid == 0 or nums[mid - 1] < nums[mid]) and (
                    mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):  # 1 < 3 > 5
                return mid

            if (nums[mid] < nums[mid + 1]):  # 3 < 5
                low = mid + 1
            else:
                high = mid - 1
        return -1

    """
    Time Complexity : O(Log n)
    Space Complexity: O(1)
    """