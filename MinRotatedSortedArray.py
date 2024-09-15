"""

Suppose an array of length n sorted in ascending order is rotated between 
1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:

        # base case
        if nums == None or len(nums) == 0:
            return -1
        
        # Can use binary search as its sorted array
        low = 0
        high = len(nums) -1
        
        
        while low <= high:
            
            # before finding mid, if nums[low] element is smaller,
            # the array is not rotated and can return the first element
            if(nums[low] < nums[high]):
                return nums[low]
            
            mid = low + (high - low) // 2
            
            # for nums[mid] has to be smallest, it either has to be 0 or less than nums[mid-1]
            # it also has to be less than its next element as well as less than last element (rotated at the mid)
            if ((mid == 0 or nums[mid] < nums[mid - 1]) and 
                (mid == len(nums) - 1 or nums[mid] < nums[mid + 1])):
                return nums[mid]
            
            # moving pointer if smallest element is on the right half
            elif nums[low] <= nums[mid]:
                low = mid + 1

            # moving pointer if smallest element is on the left half  
            else:
                high = mid - 1
                
        return 1
            