class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        N = len(nums)
        start, end, mid = 0, N-1, 0
        
        # Binary Search Loop
        while end >= start:
            
            # Find the mid element
            mid = start + (end-start) // 2
            
            # Check whether midpoint is pivot
            if mid-1 >= start and nums[mid] < nums[mid-1]:
                return nums[mid]
            
            # Later half of the array is sorted. Discard it
            if nums[end] > nums[mid]:
                end = mid-1
            
            # First half of the array is sorted. Discard it
            else:
                start = mid+1

        # Termination of the loop means our mid pointer is at pivot
        return nums[mid]


### Complexity Analysis ###

## Time Complexity: O(logN) --> Binary Seach
## Space Complexity: O(1) --> No Extra Space Used