class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        # if input is empty return -1
        if len(nums) == 0 or nums is None:
            return -1

        while low <= high:
            # If the current segment is already sorted
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            # Check if the middle element is the minimum
            if (mid == 0 or nums[mid] < nums[mid + 1]) and (
                mid == len(nums) - 1 or nums[mid] < nums[mid - 1]
            ):
                return nums[mid]
            # If the left side is sorted search in the right side
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                # If the right side is sorted, search in the left side
                high = mid - 1
        return -1


# amortizeed time complexity is O(log n)
# space complexity is O(1)
