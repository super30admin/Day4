class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # if input list is empty
        if nums is None or len(nums) == 0:
            return [-1, -1]
        n = len(nums) - 1

        # find the first and last index in two different functions
        def binarysearchfirst(nums, low, high, target):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:

                    if (mid == 0) or (nums[mid - 1] < nums[mid]):
                        return mid
                    else:
                        # Search in the left half for the first occurrence
                        high = mid - 1
                elif nums[mid] > target:
                    # Target is in the left half
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def binarysearchlast(nums, low, high, target):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    # Check if it's the last occurrence
                    if (mid == len(nums) - 1) or nums[mid + 1] > nums[mid]:
                        return mid
                    else:
                        # Search in the right half for the last occurrence
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

        first = binarysearchfirst(nums, 0, n, target)
        if first == -1:
            return [-1, -1]
        last = binarysearchlast(nums, first, n, target)
        return [first, last]

    def binarysearchfirst(nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarysearchlast(nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (mid == len(nums) - 1) or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1


# amortizeed time complexity is O(log n)
# space complexity is O(1)
