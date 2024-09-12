## Problem 3: (https://leetcode.com/problems/find-peak-element/)
"""

// Time Complexity :  O(logn)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : the edge cases
"""

def peak(nums):
    if len(nums) == 1:
        return 0
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2
        # we check are at extreme left or right if not then check normal element before and after mid
        # if mid is greater than elements before and after return mid, which is index of peak element
        if (mid==0 or nums[mid] > nums[mid - 1] )and (mid==len(nums)-1 or nums[mid] > nums[mid + 1]):
            return mid
        elif nums[mid] > nums[mid + 1]:    #move to left side
            high = mid-1
        else:
            low = mid + 1                 # move to right side
    return -1                             #  we can return low if we run while loop till low < high .

print(peak([1,2,3,1]))