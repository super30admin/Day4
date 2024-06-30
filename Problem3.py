class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        '''
        Time complexity = O log(n)
        Space complexity = O(1)
        '''
        n = len(nums)  # Get the length of the list
        low = 0  # Initialize the lower bound of the search range
        high = n - 1  # Initialize the upper bound of the search range

        while low <= high:
            mid = low + (high - low) // 2  # Calculate the middle index

            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == n-1 or nums[mid] > nums[mid+1]):
                # Check if the middle element is a peak element
                # by comparing it with its adjacent elements
                return mid

            elif mid > 0 and nums[mid-1] > nums[mid]:
                # If the element to the left of the middle is greater,
                # the peak element must be on the left side

                high = mid - 1  # Update the upper bound to search the left side
            else:
                # If the element to the right of the middle is greater,
                # the peak element must be on the right side

                low = mid + 1  # Update the lower bound to search the right side

        return 636  # This line is unreachable in the provided code, as the return statement should have been at the end
