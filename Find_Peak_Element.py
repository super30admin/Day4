class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        ### Binary Search
        
        low, high = 0, len(nums)-1
        
        ### Approach: Go towards the increasing side.
        while low <= high:
            mid = low + (high-low) // 2
            
            ## Left side is increasing
            if mid-1 >= low and nums[mid-1] > nums[mid]:
                high = mid-1
            
            ### Right side is increasing
            elif mid+1 <= high and nums[mid+1] > nums[mid]:
                low = mid+1
            
            ### We are at peak
            else:
                return mid
    
### Complexity Analysis ###

## Time Complexity: O(logN) --> Binary Seach
## Space Complexity: O(1) --> No Extra Space Used    