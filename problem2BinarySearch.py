"""
Time Complexity : O(logn) where n is the number of elements in the array.
                  logn is the time complexity for the binary search
Space Complexity : O(1) as no auxillary data structure is use

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Check if array is already sorted, if yes return the first element otherwise continue Binary Search.
2. Check if mid element is smaller. We can verify it by checking if it not a peak element, if yes return the mid element.
3. Otherwise, check if array is left sorted, if yes move to the unsorted part.
4. Otherwise move to the left
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return None
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            #Check if array is already sorted, if yes return the first element otherwise continue Binary Search
            # = condition will take care if nums has only one element
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = (low+high) // 2
            
            #Check if mid element is smaller. We can verify it by checking if it not a peak element.
            if (mid == 0 or nums[mid] < nums[mid+1]) and (mid == len(nums)-1 or nums[mid] < nums[mid-1]):
                return nums[mid]
            elif nums[mid] >= nums[low]: #Array is left sorted
                low = mid + 1
            else:
                high = mid - 1
        
        return -1