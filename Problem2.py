class Solution:
    '''
        Time comlexity O (log n)
        Space Complexity O(1)    
    '''

    def findMin(self, nums: List[int]) -> int:
        if nums is None:  # Check if the input list is None
            return -1

        n = len(nums)  # Get the length of the list
        low = 0  # Initialize the lower bound of the search range
        high = n - 1  # Initialize the upper bound of the search range

        while low <= high:
            if nums[low] <= nums[high]:  # Check if the sublist is already sorted
                # If so, the minimum element is the first element
                return nums[low]

            mid = low + (high - low) // 2  # Calculate the middle index

            if (mid == 0 or nums[mid] < nums[mid-1]) and (nums[mid] < nums[mid+1]):
                # Check if the middle element is the minimum element
                # by comparing it with its adjacent elements
                return nums[mid]

            elif nums[low] <= nums[mid]:
                # If the left side of the sublist is sorted

                low = mid + 1  # Update the lower bound to search the right side
            else:
                # If the right side of the sublist is sorted

                high = mid - 1  # Update the upper bound to search the left side

        return 636  # This line is unreachable in the provided code, as the return statement should have been at the end
