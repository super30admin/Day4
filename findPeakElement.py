class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # Handle edge cases: if the list is empty or None, return -1
        if len(nums) == 0 or nums == None:
            return -1
        # If the list contains only one element, return the index 0
        if len(nums) == 1:
            return 0
        
        # Initialize the start and end pointers
        start = 0
        end = len(nums) - 1
        
        # Binary search loop
        while start <= end:
            # Calculate the middle index
            mid = start + (end - start) // 2 # to prevent integer overflow
            
            # Check if the middle element is a peak
            # A peak element is greater than its neighbors or it's at the boundary
            if (mid == start or nums[mid - 1] < nums[mid]) and (mid == end or nums[mid] > nums[mid + 1]):
                return mid
            # If the element at (middle -1) position is less than element at (middle+1), move to the right half
            elif mid == start or nums[mid - 1] < nums[mid + 1]:
                start = mid + 1
            # Otherwise, move to the left half
            else:
                end = mid - 1
