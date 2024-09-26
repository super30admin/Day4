class Solution:
    def findMin(self, nums: List[int]) -> int:

        # Initialize low and high
        low, high = 0, len(nums) - 1

        # Iterate until low <= high
        while low <= high:

            # Check if the array is not rotated
            if nums[low] <= nums[high]:
                # Return nums[low] when the array is not rotated
                return nums[low]

            # Initialize mid if the array is rotated
            mid = (low + high)//2

            # Check the direction of traversal, 
            # refer the image for explanation
            if nums[low] > nums[mid]:
                high = mid
            else:
                low = mid + 1