#// Time Complexity : O(log(n))
#// Space Complexity : O(1)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : No


#// Your code here along with comments explaining your approach in three sentences only
# We try to satisfy 3 conditions : neighbours, outliers: binary search 
# Find mid point then check neighbours
# Tried to implement a condition which checks 2nd and 2nd-last condition but it is already satisfied in neighbour case.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        h = n-1

        while l <= h:
            mid = l+(h-l)//2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == n-1 or nums[mid+1]  < nums[mid]): # neighbour case also eliminates (-inf,-inf)
                return mid
            elif nums[mid] < nums[mid+1]:                                                          # simple binary search
                l = mid +1
            else:
                h = mid
        return -1