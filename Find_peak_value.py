# Time complexity: O(logn)
# Space complexit: O(1)
# Does this code run on Leetcode: Yes
# Problems faced while coding the solution: None

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        while l<=r:
            mid = l + (r-l)//2
            # we will see if the element left to the mid value is less than the mid value or not.
            gtThanLeft = nums[mid] > nums[mid-1] or mid==0
            # We will see if the element right to the mid value is less than the mid valu or not.
            gtThanRight = mid == len(nums)-1 or nums[mid]>nums[mid+1]
            # if both are true, we have the peak value at mid, and we will return it. 
            if gtThanRight and gtThanLeft:
                return mid
           
            else:
                 # We will eliminate the left half of the array if the value left to the mid is less than the mid value.
                if gtThanRight:
                    r = mid-1
                 # We will eliminate the right half of the array if the value right to the mid is less than the mid value.
                else:
                    l = mid+1
        return -1
                