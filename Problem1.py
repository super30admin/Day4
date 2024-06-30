class Solution:
    '''
        Time complexity = O(log(n))
        Space comlexity = o(1)
    '''
    def binarySearchFirst(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2  # Calculate the middle index

            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid - 1]:  # Check if the middle element is the first occurrence
                    return mid
                else:
                    high = mid - 1  # Adjust the high to search the left side for the first occurrence
            elif nums[mid] > target:
                high = mid - 1  # Adjust the high to search the left side
            else:
                low = mid + 1  # Adjust the low to search the right side

        return -1

    def binarySearchLast(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2  # Calculate the middle index

            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:  # Check if the middle element is the last occurrence
                    return mid
                else:
                    low = mid + 1  # Adjust the low to search the right side for the last occurrence
            elif nums[mid] > target:
                high = mid - 1  # Adjust the high to search the left side
            else:
                low = mid + 1  # Adjust the low to search the right side

        return -1

    def searchRange(self, nums, target):
        if nums is None or len(nums) == 0:  # Check if the input array is empty or None
            return [-1, -1]

        if nums[0] > target or nums[-1] < target:  # Check if the target is out of the array's range
            return [-1, -1]

        first = self.binarySearchFirst(nums, 0, len(nums) - 1, target)  # Find the first occurrence of the target
        if first == -1:  # If the first occurrence is not found, return [-1, -1]
            return [-1, -1]

        last = self.binarySearchLast(nums, first, len(nums) - 1, target)  # Find the last occurrence of the target
        return [first, last]  # Return the range of occurrences [first, last]