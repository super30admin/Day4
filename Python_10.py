# Time Complexity : O(logn) since we are using binary search
# Space Complexity : No auxiliary space needed. O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while low <= high:
            if nums[low] <= nums[high]:
                # Returm low element if the whole array is already sorted
                return nums[low]
            mid = low + (high-low)//2
            
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                # If current element is less than both neighbours. Also considering if mid is the first or last element
                return nums[mid]
            elif nums[low]<=nums[mid]:
                # Left side is sorted, move the search to right half
                low = mid+1
            else:
                # Right side is sorted, move search to left side
                high = mid-1